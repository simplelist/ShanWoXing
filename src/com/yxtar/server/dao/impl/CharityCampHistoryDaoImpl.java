package com.yxtar.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityCampHistoryDao;
import com.yxtar.server.dto.CharityCampHistory;
import com.yxtar.server.util.ListResult;

@Service("charityCampHistoryDao")
public class CharityCampHistoryDaoImpl extends BaseDaoImpl<CharityCampHistory, Integer> implements CharityCampHistoryDao {

	@Override
	public ListResult<CharityCampHistory> getList(Integer charityCampId, Integer startIndex, Integer numOfRow) {
		initParameters(CharityCampHistory.class.getSimpleName());
		hql=new StringBuilder("from CharityCampHistory where 0=0 and charityCampId="+charityCampId);
		query=getSession().createQuery("select count(distinct charityCampId) "+hql.toString());
		Integer count=-999;
		count=((Long) query.uniqueResult()).intValue();
		listResult.setCount(count);
		if (count>=0) {
			query=getSession().createQuery(hql.toString());
			if (startIndex!=null) {
				query.setFirstResult(startIndex);
			}
			if (numOfRow!=null) {
				query.setMaxResults(numOfRow);
			}
			List<CharityCampHistory> histories=query.list();
			listResult.setDataList(histories);
		}
		return listResult;
	}
}
