package com.yxtar.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityCampDao;
import com.yxtar.server.dao.IPager;
import com.yxtar.server.dto.CharityCamp;
import com.yxtar.server.util.ListResult;

@Service("charityCampDao")
public class CharityCampDaoImpl extends BaseDaoImpl<CharityCamp, Integer> implements CharityCampDao {

	@Override
	public ListResult<CharityCamp> getUncompletedCharity(IPager pager) {
		initParameters(CharityCamp.class.getSimpleName());
		String word = null, province = null, city = null, area = null;
		try {
			if (pager.getParams().containsKey("province")) {
				province = pager.getParams().get("province").toString();
			}
			if (pager.getParams().containsKey("city")) {
				city = pager.getParams().get("city").toString();
			}
			if (pager.getParams().containsKey("area")) {
				area = pager.getParams().get("area").toString();
			}
			if (pager.getParams().containsKey("word")) {
				word = pager.getParams().get("word").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (validationUtil.StrNotNull(word)) {
			hql.append(" and ( title like '%" + word + "%' or introdLong like '%" + word + "%' or introdShort like '%" + word + "%' or htmlIntrod like '%" + word + "%') ");
		}
		if (validationUtil.StrNotNull(province)) {
			hql.append(" and province like '%" + province + "%' ");
		}
		if (validationUtil.StrNotNull(city)) {
			hql.append(" and city like '%" + city + "%' ");
		}
		if (validationUtil.StrNotNull(area)) {
			hql.append(" and district like '%" + area + "%' ");
		}
		hql.append(" and status in (0,1)");
		query = getSession().createQuery(hql.toString());
		if (pager.getStart() != null) {
			query.setFirstResult(pager.getStart());
		}
		if (pager.getLimit() != null) {
			query.setMaxResults(pager.getLimit());
		}
		List<CharityCamp> result = query.list();
		if (result != null && result.size() > 0) {
			listResult.setCount(result.size());
			listResult.setDataList(result);
		}
		return listResult;
	}
}
