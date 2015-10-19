package com.yxtar.server.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.app.shared.enums.PushInfoStatus;
import com.yxtar.server.cassandra.dao.respository.SysPushInfoRespository;
import com.yxtar.server.dao.SystemSettingDao;
import com.yxtar.server.dto.SystemSetting;
import com.yxtar.server.dto.cassandra.PK_SysPushInfo;
import com.yxtar.server.dto.cassandra.SysPushInfo;
import com.yxtar.server.service.SystemSettingService;

@Service()
public class SystemSettingServiceImpl extends BaseServiceImpl implements SystemSettingService {
	@Autowired
	private SystemSettingDao systemSettingDao;

	@Autowired
	private SysPushInfoRespository sysPushInfoRespository;

	@Override
	public SystemSetting checkMaint(int codeversion) {
		return systemSettingDao.checkMaint(codeversion);
	}

	@Override
	public Boolean InsertSysPushInfo(String tokens, int platform) {
		Boolean saveSuccess=false;
		if (validationUtil.DigitIsVoid(platform)) {
			return saveSuccess;
		}
		SysPushInfo pushInfo=new SysPushInfo();
		PK_SysPushInfo pk=new PK_SysPushInfo();
		pushInfo.setCreateTime(new Date());
		pushInfo.setStatus(PushInfoStatus.on.getType());
		pushInfo.setPk(pk);
		pk.setPlatform(platform);
		pk.setTokens(tokens);
		SysPushInfo save=sysPushInfoRespository.save(pushInfo);
		if (save!=null) {
			saveSuccess=true;
		}
		return saveSuccess;
	}

}
