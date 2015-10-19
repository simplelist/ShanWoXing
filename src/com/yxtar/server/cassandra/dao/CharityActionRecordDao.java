package com.yxtar.server.cassandra.dao;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.yxtar.server.dto.cassandra.CharityActionRecord;
import com.yxtar.server.dto.cassandra.MbrActionRecord;


public interface CharityActionRecordDao {

	Boolean choiceVote(Integer charityCampId, Integer fundId, UUID memberId, Integer periodNum, Date createTime);

	Boolean setCharityCompleted(MbrActionRecord record, CharityActionRecord charityAction);

	Map<String, Object> setMbrActivityCompleted(UUID memberId, Integer dCampId, UUID locationId);
}
