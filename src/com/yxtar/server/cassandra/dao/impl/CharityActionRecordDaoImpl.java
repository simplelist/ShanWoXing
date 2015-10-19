package com.yxtar.server.cassandra.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;
import com.yxtar.app.shared.enums.DailyCampActionType;
import com.yxtar.app.shared.enums.MbrAccTransactionType;
import com.yxtar.server.cassandra.dao.CharityActionRecordDao;
import com.yxtar.server.cassandra.dao.MemberDao;
import com.yxtar.server.cassandra.dao.respository.CharityActionRecordRespository;
import com.yxtar.server.cassandra.dao.respository.DailyCampStatRespository;
import com.yxtar.server.cassandra.dao.respository.MbrAccBalanceRespository;
import com.yxtar.server.dao.DailyCampDao;
import com.yxtar.server.dto.DailyCamp;
import com.yxtar.server.dto.cassandra.CharityActionRecord;
import com.yxtar.server.dto.cassandra.DailyCampStat;
import com.yxtar.server.dto.cassandra.MbrAccBalance;
import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.Member;
import com.yxtar.server.util.DateUtil;
import com.yxtar.server.util.UUIDUtil;

@Repository()
public class CharityActionRecordDaoImpl implements CharityActionRecordDao {

	@Autowired
	private CassandraOperations operation;
	@Autowired
	private DailyCampDao dailyCampDao;
	@Autowired
	private CharityActionRecordRespository charityActionRecordRespository;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MbrAccBalanceRespository mbrAccBalanceRespository;
	@Autowired
	private DailyCampStatRespository dailyCampStatRespository;

	@Override
	public Boolean choiceVote(Integer charityCampId, Integer fundId, UUID memberId, Integer periodNum, Date createTime) {
		Boolean done = false;
		try {
			Update updateRecord = QueryBuilder.update("charity_action_record");
			updateRecord.with(QueryBuilder.set("charityfundid", fundId));
			updateRecord.where(QueryBuilder.eq("charitycampid", charityCampId));
			updateRecord.where(QueryBuilder.eq("periodnum", periodNum));
			updateRecord.where(QueryBuilder.eq("memberid", memberId));
			updateRecord.where(QueryBuilder.eq("createtime", createTime));
			operation.execute(updateRecord);

			PreparedStatement insertPreparedStatement = operation.getSession().prepare(
					"BEGIN COUNTER BATCH " + " update camp_fund_vote_stat set numofvote=numofvote+1  where campid=? and periodnum=? and fundid=?;" + "APPLY BATCH");

			operation.getSession().execute(insertPreparedStatement.bind(charityCampId, periodNum, fundId));
			done = true;
		} catch (Exception e) {
			done = false;
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public Boolean setCharityCompleted(MbrActionRecord record, CharityActionRecord charityAction) {
		Boolean done = false;
		try {
			if (record == null || record.getPk() == null) {
				return false;
			}
			Select select = QueryBuilder.select().from("mbr_acc_balance");
			select.where(QueryBuilder.eq("memberid", record.getPk().getMemberId()));
			select.setConsistencyLevel(ConsistencyLevel.ALL);
			MbrAccBalance accBalance = operation.selectOne(select, MbrAccBalance.class);
			Integer numOfCampSupported = -99;
			if (accBalance == null) {
				// if accBalance is null then return ;
				return false;
			}
			numOfCampSupported = accBalance.getNumOfCampSupported();
			if (numOfCampSupported == null) {
				numOfCampSupported = 0;
			}
			numOfCampSupported = numOfCampSupported + 1;
			BatchStatement batch = new BatchStatement();
			PreparedStatement insertMbrRecord = operation.getSession().prepare(
					"INSERT INTO mbr_action_record(memberid,charitycampid,periodnum,createtime,campintrodshort,campmainphoto,camptitle,periodcamp) VALUES (?,?,?,?,?,?,?,?);");
			batch.add(insertMbrRecord.bind(record.getPk().getMemberId(), record.getPk().getCharityCampId(), record.getPk().getPeriodNum(), record.getCreateTime(),
					record.getCampIntrodShort(), record.getCampMainphoto(), record.getCampTitle(), record.getPeriodCamp()));
			PreparedStatement insertCharityRecord = operation.getSession().prepare(
					"INSERT INTO charity_action_record(charitycampid,periodnum,memberid,createtime,actioncontent,actiontype) VALUES (?,?,?,?,?,?);");
			batch.add(insertCharityRecord.bind(record.getPk().getCharityCampId(), record.getPk().getPeriodNum(), record.getPk().getMemberId(), record.getCreateTime(),
					charityAction.getActionContent(), charityAction.getActionType()));
			PreparedStatement updateBalance = operation.getSession().prepare("update  mbr_acc_balance set numofcampsupported=? where memberid=?;");
			/**
			 * a table for holding member account's balance data, need to read and write with high consisitency
			 */
			updateBalance.setConsistencyLevel(ConsistencyLevel.ALL);
			batch.add(updateBalance.bind(numOfCampSupported, record.getPk().getMemberId()));

			operation.execute(batch);

			PreparedStatement insertPreparedStatement = operation.getSession().prepare(
					"BEGIN COUNTER BATCH " + " " + "update camp_reach_rate_stat set supportcount=supportcount+1 where campid=? and periodnum=?;" + "APPLY BATCH");

			operation.getSession().execute(insertPreparedStatement.bind(record.getPk().getCharityCampId(), record.getPk().getPeriodNum()));
			done = true;
		} catch (Exception e) {
			done = false;
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public Map<String, Object> setMbrActivityCompleted(UUID memberId, Integer dCampId, UUID locationId) {
		if (memberId == null || dCampId == null || locationId == null) {
			return null;
		}

		/**
		 * - read DailyCamp - insert DailyCampRecord@cassandra - insert MbrDailyCampRecord@cassandra, with createDate =
		 * Year, Month, Date only - update MbrAccBalance@cassandra - insert MbrAccTransaction@cassandra - update
		 * DailyCampStat@cassandra, remainAmount, remainPreparedAmount
		 */
		/**
		 * prepare using data;
		 */
		DailyCamp dailyCamp = dailyCampDao.get(dCampId);
		Member member = memberDao.findById(memberId);
		MbrAccBalance balance = mbrAccBalanceRespository.findOne(memberId);
		DailyCampStat campStat = dailyCampStatRespository.findOne(dCampId);
		if (dailyCamp == null || member == null || balance == null || campStat == null) {
			return null;
		}
		final Double amountPerSupport = dailyCamp.getAmountPerSupport();
		if (amountPerSupport <= 0) {
			return null;
		}
		Date time = null;
		Date createDate = null;
		if (dailyCamp.getCreateTime() == null) {
			time = new Date();
		} else {
			time = dailyCamp.getCreateTime();
		}
		createDate = new Date(DateUtil.getInstance().DateToZeroLongTime(time));
		BatchStatement batch = new BatchStatement();
		/**
		 * insert DailyCampRecord@cassandra
		 */
		PreparedStatement insertDailyCampRecord = operation
				.getSession()
				.prepare(
						"INSERT INTO daily_camp_record (dcampid,createdate,memberid,actiontype,campadvphoto,camptitle,mbraccname,mbrfundreceived,sponsorid,sponsorname) values(?,?,?,?,?,?,?,?,?,?);");
		batch.add(insertDailyCampRecord.bind(dCampId, createDate, memberId, DailyCampActionType.QRCodeScan.getType(), UUIDUtil.create(dailyCamp.getCampAdvPhoto()),
				dailyCamp.getCampTitle(), member.getPk().getNickName(), amountPerSupport, dailyCamp.getSponsorId().getId(), dailyCamp.getSponsorId().getCompanyName()));
		/**
		 * MbrDailyCampRecord@cassandra, with createDate = Year, Month, Date only
		 */
		
		PreparedStatement insertMbrDailyCampRecord = operation.getSession().prepare("INSERT INTO mbr_daily_camp_record(memberid,createdate,locationid,dcampid) VALUES (?,?,?,?);");
		batch.add(insertMbrDailyCampRecord.bind(memberId, createDate, locationId, dCampId));
		/**
		 * update MbrAccBalance@cassandra
		 */
		Double mbrBalance = 0.0;
		if (balance.getMbrFundAccBalance() != null) {
			mbrBalance = balance.getMbrFundAccBalance();
		}
		mbrBalance = mbrBalance + amountPerSupport;
		PreparedStatement updateBalance = operation.getSession().prepare("update  mbr_acc_balance set mbrfundaccbalance=? where memberid=?;");
		updateBalance.setConsistencyLevel(ConsistencyLevel.ALL);
		batch.add(updateBalance.bind(mbrBalance, memberId));
		/**
		 * insert MbrAccTransaction@cassandra
		 */
		// CharityActionRecord actionRecord=null;
		// PK_CharityActionRecord pk=new PK_CharityActionRecord();
		// pk.setMemberId(memberId);
		// pk.set
		// actionRecord=charityActionRecordRespository.findOne(id);
		PreparedStatement insertMbrAccTransaction = operation.getSession().prepare(
				"INSERT INTO mbr_fund_acc_transaction(memberid,type,createtime,accbalancesnapshot,dcampid,"
						+ "campphoto,camptitle,funddecisionid,fundid,fundphoto,fundtitle,nickname,photoid)values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
		batch.add(insertMbrAccTransaction.bind(memberId, MbrAccTransactionType.MoneyIn.getType(), createDate, mbrBalance, dailyCamp.getDcampId(),
				UUIDUtil.create(dailyCamp.getCampAdvPhoto()), dailyCamp.getCampTitle(), null, null, null, null, member.getPk().getNickName(), member.getPhotoId()));
		/**
		 * - update DailyCampStat@cassandra, remainAmount, remainPreparedAmount
		 */
		Double statRemain = 0.0;
		if (campStat.getRemainAmount() != null) {
			statRemain = campStat.getRemainAmount();
		}
		statRemain = statRemain - amountPerSupport;
		if (statRemain < 0) {
			return null;
		}
		PreparedStatement updateDailyCampStat = operation.getSession().prepare("update daily_camp_stat set remainamount=?  where dcampid=?;");
		batch.add(updateDailyCampStat.bind(statRemain, dailyCamp.getDcampId()));

		operation.execute(batch);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("sponsorName", dailyCamp.getSponsorId().getCompanyName());
		result.put("sponsorLogo", dailyCamp.getSponsorId().getVertLogoPhoto());
		result.put("amountPerSupport", amountPerSupport);
		result.put("accBalance", mbrBalance);
		result.put("action", true);
		return result;
	}

}
