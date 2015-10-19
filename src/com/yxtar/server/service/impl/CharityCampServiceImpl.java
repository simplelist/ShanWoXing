package com.yxtar.server.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.app.shared.enums.DailyCampStatusType;
import com.yxtar.server.cassandra.dao.CharityActionRecordDao;
import com.yxtar.server.cassandra.dao.PlatformLocationDao;
import com.yxtar.server.cassandra.dao.respository.CampFundVoteStatRespository;
import com.yxtar.server.cassandra.dao.respository.CampReachRateStatRespository;
import com.yxtar.server.cassandra.dao.respository.CharityActionRecordRespository;
import com.yxtar.server.cassandra.dao.respository.DailyCampStatRespository;
import com.yxtar.server.cassandra.dao.respository.MbrActionRecordRespository;
import com.yxtar.server.cassandra.dao.respository.MbrDailyCampRecordRespository;
import com.yxtar.server.cassandra.dao.respository.PaymentRecordRespository;
import com.yxtar.server.cassandra.dao.respository.PlatformLocationRespository;
import com.yxtar.server.dao.CampFundRelationDao;
import com.yxtar.server.dao.CampSponsorRelationDao;
import com.yxtar.server.dao.CharityCampDao;
import com.yxtar.server.dao.CharityCampHistoryDao;
import com.yxtar.server.dao.CharityFundDao;
import com.yxtar.server.dao.DailyCampDao;
import com.yxtar.server.dao.IPager;
import com.yxtar.server.dto.CampFundRelation;
import com.yxtar.server.dto.CampSponsorRelation;
import com.yxtar.server.dto.CharityCamp;
import com.yxtar.server.dto.CharityCampHistory;
import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.dto.DailyCamp;
import com.yxtar.server.dto.Sponsor;
import com.yxtar.server.dto.cassandra.CampFundVoteStat;
import com.yxtar.server.dto.cassandra.CampReachRateStat;
import com.yxtar.server.dto.cassandra.CharityActionRecord;
import com.yxtar.server.dto.cassandra.DailyCampStat;
import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.MbrDailyCampRecord;
import com.yxtar.server.dto.cassandra.PK_CampReachRateStat;
import com.yxtar.server.dto.cassandra.PK_CharityActionRecord;
import com.yxtar.server.dto.cassandra.PK_MbrActionRecord;
import com.yxtar.server.dto.cassandra.PK_MbrDailyCampRecord;
import com.yxtar.server.dto.cassandra.PaymentRecord;
import com.yxtar.server.dto.cassandra.PlatformLocation;
import com.yxtar.server.exception.RecordAlreadyUsedException;
import com.yxtar.server.service.CharityCampService;
import com.yxtar.server.util.ListResult;
import com.yxtar.server.util.UUIDUtil;

@Service()
public class CharityCampServiceImpl extends BaseServiceImpl implements CharityCampService {
	@Autowired
	private CharityCampDao charityCampDao;
	@Autowired
	private MbrDailyCampRecordRespository mbrDailyCampRecordRespository;
	@Autowired
	private PlatformLocationRespository platformLocationRespository;
	@Autowired
	private PlatformLocationDao platformLocationDao;
	@Autowired
	private DailyCampDao dailyCampDao;
	@Autowired
	private DailyCampStatRespository dailyCampStatRespository;
	@Autowired
	private CampReachRateStatRespository campReachRateStatRespository;
	@Autowired
	private CampSponsorRelationDao campSponsorRelationDao;
	@Autowired
	private CharityCampHistoryDao charityCampHistoryDao;
	@Autowired
	private CampFundRelationDao campFundRelationDao;
	@Autowired
	private CharityActionRecordDao charityActionRecordDao;
	@Autowired
	private CharityActionRecordRespository charityActionRecordRespository;
	@Autowired
	private CampFundVoteStatRespository campFundVoteStatRespository;
	@Autowired
	private CharityFundDao charityFundDao;
	@Autowired
	private PaymentRecordRespository paymentRecordRespository;
	@Autowired
	private MbrActionRecordRespository mbrActionRecordRespository;
	
	
	
	
	
	@Override
	public ListResult<CharityCamp> getUncompletedCharity(IPager pager) {
		ListResult<CharityCamp> result = charityCampDao.getUncompletedCharity(pager);
		return result;
	}

	@Override
	public DailyCamp getCharityByLocationID(UUID memberId, UUID locationId) throws RecordAlreadyUsedException {
		if (memberId == null || locationId == null) {
			return null;
		}
		PK_MbrDailyCampRecord pk = new PK_MbrDailyCampRecord();
		pk.setMemberId(memberId);
		pk.setCreateDate(new Date(dateUtil.DateToZeroLongTime(new Date())));
		pk.setLocationId(locationId);
		MbrDailyCampRecord record = null;
		/**
		 * get record by primaryKey if record is null:today this user dosn't join this locationId DailyCamp;
		 */
		record = mbrDailyCampRecordRespository.findOne(pk);
		if (record != null) {
			throw new RecordAlreadyUsedException(this);
		}
		PlatformLocation location = null;
		location = platformLocationRespository.findOne(locationId);
		if (location == null) {
			return null;
		}
		/**
		 * update PlatformLocation@cassandra - reachRate
		 */
		int count = location.getReachRate();
		count = count + 1;
		location.setReachRate(count);
		location = platformLocationDao.updateRate(location);
		if (count != location.getReachRate()) {
			return null;
		}
		/**
		 * read dailyCampLocation@cassandra ◦ search with “province", “city", “district", "street" ◦ search
		 * with “province", “city", “district", “all" ◦ search with “province", “city", “all", “all" ◦ search
		 * with “province", “all", “all", “all" ◦ search with “all", “all", “all", “all" then chose one from this list
		 * random
		 */
		DailyCamp dailyCamp = null;
		if (location.getDcampLst() != null && location.getDcampLst().size() > 0) {
			Random random = new Random();
			List<DailyCampStat> statList = (List<DailyCampStat>) dailyCampStatRespository.findAll(location.getDcampLst());
			if (statList != null && statList.size() > 0) {
				DailyCampStat stat = null;
				for (int i = 0, len = statList.size(); i < len; i++) {
					/**
					 * random int (0,len); get random stat from statList;
					 */
					int index = random.nextInt(len);
					stat = statList.get(index);
					if (stat == null) {
						/**
						 * remove this element from statList; 总长度减一 --len; 索引减一 --i;
						 */
						statList.remove(i);
						--len;
						--i;
						continue;
					}
					dailyCamp = dailyCampDao.get(stat.getDcampId());
					if (dailyCamp == null || dailyCamp.getStatus() == DailyCampStatusType.end.getType()) {
						/**
						 * if this dailyCamp status is end
						 */
						statList.remove(i);
						--len;
						--i;
						continue;
					}
					if (stat.getRemainPreparedAmount() - dailyCamp.getAmountPerSupport() >= 0) {
						/**
						 * if (准备金-每次支付的钱数>=0)才有效 else 继续循环
						 */
						break;
					}
				}
				if (dailyCamp != null) {
					/**
					 * update the RemainPreparedAmount RemainPreparedAmount=old-per;
					 */
					stat.setRemainPreparedAmount(stat.getRemainPreparedAmount() - dailyCamp.getAmountPerSupport());
					dailyCampStatRespository.save(stat);
				}
			}
		}

		return dailyCamp;
	}

	@Override
	public CharityCamp getCharityByDCampID(Integer campId) {
		if (validationUtil.DigitIsVoid(campId)) {
			return null;
		}
		CharityCamp camp = null;
		camp = charityCampDao.get(campId);
		return camp;
	}

	@Override
	public CampReachRateStat getProgressByCharityID(Integer charityCampId, Integer periodNum) {
		if (validationUtil.DigitIsVoid(charityCampId,periodNum) ) {
			return null;
		}
		PK_CampReachRateStat pk = new PK_CampReachRateStat();
		pk.setCampId(charityCampId);
		pk.setPeriodNum(periodNum);
		return campReachRateStatRespository.findOne(pk);
	}

	@Override
	public ListResult<Sponsor> getSponsorListByCharityID(Integer charityCampId) {
		if (validationUtil.DigitIsVoid(charityCampId)) {
			return null;
		}
		ListResult<CampSponsorRelation> relation = campSponsorRelationDao.getSponsorListByCharityID(charityCampId);
		if (relation == null || relation.getCount() <= 0 || relation.getDataList() == null) {
			return null;
		}
		ListResult<Sponsor> ids = new ListResult<Sponsor>();
		for (CampSponsorRelation cRelation : relation.getDataList()) {
			ids.getDataList().add(cRelation.getSponsor());
			ids.setCount(ids.getCount() + 1);
		}
		return ids;
	}

	@Override
	public ListResult<CharityCampHistory> getEventByCampID(Integer charityCampId, Integer startIndex, Integer numOfRow) {
		if (validationUtil.DigitIsVoid(charityCampId,startIndex,numOfRow) ) {
			return null;
		}
		return charityCampHistoryDao.getList(charityCampId, startIndex, numOfRow);
	}

	@Override
	public ListResult<CharityFund> getCharityFundByCampID(Integer charityCampId) {
		if (validationUtil.DigitIsVoid(charityCampId)) {
			return null;
		}
		ListResult<CampFundRelation> relation = campFundRelationDao.getCharityFundByCampID(charityCampId);
		if (relation == null || relation.getCount() <= 0 || relation.getDataList() == null) {
			return null;
		}
		ListResult<CharityFund> funds=new ListResult<CharityFund>();
		for (CampFundRelation fund : relation.getDataList()) {
			funds.getDataList().add(fund.getFundId());
			funds.setCount(funds.getCount() + 1);
		}
		return funds;
	}

	@Override
	public Boolean choiceVote(Integer charityCampId, Integer fundId, UUID memberId, Integer periodNum,Date createTime) {
		Boolean saveDone=false;
		saveDone=charityActionRecordDao.choiceVote(charityCampId,fundId,memberId,periodNum,createTime);
		return saveDone;
	}

	@Override
	public ListResult<CampFundVoteStat> getVoteDataList(Integer charityCampId, Integer periodNum) {
		if (validationUtil.DigitIsVoid(charityCampId,periodNum)) {
			return null;
		}
		List<CampFundVoteStat> stats=campFundVoteStatRespository.findByIdNum(charityCampId,periodNum);
		if (stats==null||stats.size()<=0) {
			return null;
		}
		ListResult<CampFundVoteStat> statResult=new ListResult<CampFundVoteStat>();
		statResult.setCount(stats.size());
		statResult.setDataList(stats);
		return statResult;
	}

	@Override
	public CharityFund getCharityFundByID(Integer fundId) {
		if (validationUtil.DigitIsVoid(fundId)) {
			return null;
		}
		return charityFundDao.get(fundId);
	}

	@Override
	public PaymentRecord getPaymentEventByID(UUID recordId) {
		if (recordId==null) {
			return null;
		}
		PaymentRecord record=paymentRecordRespository.findById(recordId);
		return record;
	}

	@Override
	public MbrActionRecord setCharityCompleted(UUID memberId, Integer campId, Integer actionType, String content) {
		if (memberId==null||validationUtil.StrisNull(content)||validationUtil.DigitIsVoid(campId,actionType)) {
			return null;
		}
		/**
		 * get CharityCamp by campId;
		 */
		CharityCamp camp=charityCampDao.get(campId);
		if (camp==null) {
			return null;
		}
		/**
		 * box the MbrActionRecord from input Data&CharityCamp;and save
		 */
		MbrActionRecord record=new MbrActionRecord();
		PK_MbrActionRecord pk=new PK_MbrActionRecord();
		record.setPk(pk);
		pk.setCharityCampId(campId);
		pk.setMemberId(memberId);
		pk.setPeriodNum(camp.getPeriodNum());
		record.setCreateTime(new Date());
		record.setCampIntrodShort(camp.getIntrodShort());
		record.setCampMainphoto(UUIDUtil.create(camp.getIntroMainPhoto()));
		record.setCampTitle(camp.getTitle());
		record.setPeriodCamp(camp.getCampType()==1);
		/**
		 * box the CharityActionRecord from input Data&CharityCamp;and save
		 */
		CharityActionRecord charityAction=new CharityActionRecord();
		PK_CharityActionRecord pk_CharityActionRecord=new PK_CharityActionRecord();
		pk_CharityActionRecord.setCharityCampId(campId);
		pk_CharityActionRecord.setCreateTime(record.getCreateTime());
		pk_CharityActionRecord.setMemberId(memberId);
		pk_CharityActionRecord.setPeriodNum(camp.getPeriodNum());
		charityAction.setPk(pk_CharityActionRecord);
		charityAction.setActionContent(content);
		charityAction.setActionType(actionType);
		charityAction.setCharityFundid(null);
		Boolean saveSuccess=charityActionRecordDao.setCharityCompleted(record,charityAction);
		if (saveSuccess) {
			return record;
		}else {
			return null;
		}
	}

	@Override
	public Map<String, Object> setMbrActivityCompleted(UUID memberId, Integer dCampId, UUID locationId) {
		if (memberId==null||dCampId==null||locationId==null) {
			return null;
		}
		Map<String, Object> result=null;
		result=charityActionRecordDao.setMbrActivityCompleted(memberId,dCampId,locationId);
		return result;
	}
}
