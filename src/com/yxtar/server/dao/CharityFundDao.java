package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.util.ListResult;

@Repository()
public interface CharityFundDao extends BaseDao<CharityFund, Integer> {

	ListResult<CharityFund> getList(Integer charityCampId);

	ListResult<CharityFund> getCharityFundByStatus(Integer status, Integer startIndex, Integer numOfRow);
}
