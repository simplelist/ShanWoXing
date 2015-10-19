package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.CharityCampHistory;
import com.yxtar.server.util.ListResult;

@Repository()
public interface CharityCampHistoryDao extends BaseDao<CharityCampHistory, Integer> {

	ListResult<CharityCampHistory> getList(Integer charityCampId, Integer startIndex, Integer numOfRow);
}
