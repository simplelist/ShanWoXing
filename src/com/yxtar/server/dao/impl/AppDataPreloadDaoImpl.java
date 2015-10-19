package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.AppDataPreloadDao;
import com.yxtar.server.dto.AppDataPreload;

@Service("appDataPreloadDao")
public class AppDataPreloadDaoImpl extends BaseDaoImpl<AppDataPreload, Integer> implements AppDataPreloadDao {

	@Override
	public AppDataPreload checkUpdate(int codeversion, int platform) {
		initParameters(AppDataPreload.class.getSimpleName());
		hql.append(" and  version=? and platform=? ");
		query=getSession().createQuery(hql.toString());
		paramsMap.put(0, codeversion);
		paramsMap.put(1, platform);
		setQueryParameters(query, paramsMap);
		return (AppDataPreload) query.uniqueResult();
	}
}
