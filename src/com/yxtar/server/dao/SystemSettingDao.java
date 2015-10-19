package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.SystemSetting;

@Repository()
public interface SystemSettingDao extends BaseDao<SystemSetting, Integer> {
	SystemSetting checkMaint(int codeversion);
}
