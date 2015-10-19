package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.SystemSettingDao;
import com.yxtar.server.dto.SystemSetting;

@Service("systemSettingDao")
public class SystemSettingDaoImpl extends BaseDaoImpl<SystemSetting, Integer> implements SystemSettingDao {

	@Override
	public SystemSetting checkMaint(int codeversion) {
		initParameters(SystemSetting.class.getSimpleName());
		hql.append(" and  supportVer=?");
		query=getSession().createQuery(hql.toString());
		paramsMap.put(0, codeversion);
		setQueryParameters(query, paramsMap);
		return (SystemSetting) query.uniqueResult();
	}
}
