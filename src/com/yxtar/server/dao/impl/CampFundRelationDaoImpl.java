package com.yxtar.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CampFundRelationDao;
import com.yxtar.server.dto.CampFundRelation;
import com.yxtar.server.util.ListResult;

@Service("campFundRelationDao")
public class CampFundRelationDaoImpl extends BaseDaoImpl<CampFundRelation, Integer> implements CampFundRelationDao {

	@Override
	public ListResult<CampFundRelation> getCharityFundByCampID(Integer charityCampId) {
		initParameters(CampFundRelation.class.getSimpleName());
		if (validationUtil.DigitIsVoid(charityCampId)) {
			return null;
		}
		hql.append(" and camp_id = "+charityCampId);
		query = getSession().createQuery(hql.toString());
		List<CampFundRelation> result = query.list();
		if (result != null && result.size() > 0) {
			listResult.setCount(result.size());
			listResult.setDataList(result);
		}
		return listResult;
	}
}
