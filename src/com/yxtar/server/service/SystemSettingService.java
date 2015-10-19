package com.yxtar.server.service;

import com.yxtar.server.dto.SystemSetting;


public interface SystemSettingService {

	SystemSetting checkMaint(int codeversion);

	Boolean InsertSysPushInfo(String tokens, int platform);
}
