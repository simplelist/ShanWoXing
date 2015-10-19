package com.yxtar.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityFundDao;
import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.service.CharityFundService;
import com.yxtar.server.util.ListResult;

@Service()
public class CharityFundServiceImpl extends BaseServiceImpl  implements CharityFundService {
	@Autowired
	private CharityFundDao charityFundDao;

	@Override
	public ListResult<CharityFund> getCharityFundByStatus(Integer status, Integer startIndex, Integer numOfRow) {
		if (validationUtil.DigitIsVoid(status,startIndex,numOfRow)) {
			return null;
		}
		ListResult<CharityFund> listResult=charityFundDao.getCharityFundByStatus(status,startIndex,numOfRow);
		return listResult;
	}



}
