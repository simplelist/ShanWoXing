package com.yxtar.server.service;

import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.util.ListResult;


public interface CharityFundService {

	ListResult<CharityFund> getCharityFundByStatus(Integer status, Integer startIndex, Integer numOfRow);
}
