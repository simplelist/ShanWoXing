package com.yxtar.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CampSponsorRelationDao;
import com.yxtar.server.dto.CampSponsorRelation;
import com.yxtar.server.util.ListResult;

@Service("campSponsorRelationDao")
public class CampSponsorRelationDaoImpl extends BaseDaoImpl<CampSponsorRelation, Integer> implements CampSponsorRelationDao {

	@Override
	public ListResult<CampSponsorRelation> getSponsorListByCharityID(Integer charityCampId) {
		initParameters(CampSponsorRelation.class.getSimpleName());
		if (charityCampId!=null&&charityCampId>0) {
			hql.append(" and camp_id= "+charityCampId);
		}
		query = getSession().createQuery(hql.toString());
		List<CampSponsorRelation> result = query.list();
		if (result != null && result.size() > 0) {
			listResult.setCount(result.size());
			listResult.setDataList(result);
		}
		return listResult;
	}
}
