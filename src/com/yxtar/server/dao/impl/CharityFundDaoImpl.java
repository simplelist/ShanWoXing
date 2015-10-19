package com.yxtar.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityFundDao;
import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.util.ListResult;

@Service("charityFundDao")
public class CharityFundDaoImpl extends BaseDaoImpl<CharityFund, Integer> implements CharityFundDao {

	@Override
	public ListResult<CharityFund> getList(Integer charityCampId) {
		initParameters(CharityFund.class.getSimpleName());
		if (validationUtil.DigitIsVoid(charityCampId)) {
			return null;
		}
		hql=new StringBuilder("select c from CharityFund c where c.charityCamps.id= "+charityCampId);
		query = getSession().createQuery(hql.toString());
		List<CharityFund> result =new ArrayList<CharityFund>(); 
		result=query.list();
		if (result != null && result.size() > 0) {
			listResult.setCount(result.size());
			listResult.setDataList(result);
		}
		return listResult;
	}

	@Override
	public ListResult<CharityFund> getCharityFundByStatus(Integer status, Integer startIndex, Integer numOfRow) {
		
		initParameters(CharityFund.class.getSimpleName());
		hql=new StringBuilder("select c from CharityFund c where 0=0 ");
		if (!validationUtil.DigitIsVoid(status)) {
			hql.append(" and c.status= "+status);
		}
		
		query = getSession().createQuery(hql.toString());
		List<CharityFund> result =new ArrayList<CharityFund>(); 
		if (!validationUtil.DigitIsVoid(status,numOfRow)) {
			query.setFirstResult((startIndex-1)*numOfRow);
			query.setMaxResults(numOfRow);
		}
		result=query.list();
		if (result != null && result.size() > 0) {
			listResult.setCount(result.size());
			listResult.setDataList(result);
		}
		return listResult;
	}
}
