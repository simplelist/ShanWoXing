package com.yxtar.server.service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.yxtar.server.dao.IPager;
import com.yxtar.server.dto.CharityCamp;
import com.yxtar.server.dto.CharityCampHistory;
import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.dto.DailyCamp;
import com.yxtar.server.dto.Sponsor;
import com.yxtar.server.dto.cassandra.CampFundVoteStat;
import com.yxtar.server.dto.cassandra.CampReachRateStat;
import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.PaymentRecord;
import com.yxtar.server.exception.RecordAlreadyUsedException;
import com.yxtar.server.util.ListResult;


public interface CharityCampService{


	ListResult<CharityCamp> getUncompletedCharity(IPager pager);

	DailyCamp getCharityByLocationID(UUID memberId, UUID locationId) throws RecordAlreadyUsedException;

	CharityCamp getCharityByDCampID(Integer campId);

	CampReachRateStat getProgressByCharityID(Integer charityCampId, Integer periodNum);

	ListResult<Sponsor> getSponsorListByCharityID(Integer charityCampId);

	ListResult<CharityCampHistory> getEventByCampID(Integer charityCampId, Integer startIndex, Integer numOfRow);

	ListResult<CharityFund> getCharityFundByCampID(Integer charityCampId);

	Boolean choiceVote(Integer charityCampId, Integer fundId, UUID memberId,Integer periodNum, Date createTime);

	ListResult<CampFundVoteStat> getVoteDataList(Integer charityCampId, Integer periodNum);

	CharityFund getCharityFundByID(Integer fundId);

	PaymentRecord getPaymentEventByID(UUID recordId);

	MbrActionRecord setCharityCompleted(UUID memberId,  Integer campId, Integer actionType, String content);

	Map<String, Object> setMbrActivityCompleted(UUID memberId, Integer dCampId, UUID locationId);
}
