package com.yxtar.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.server.dao.AppDataPreloadDao;
import com.yxtar.server.dto.AppDataPreload;
import com.yxtar.server.service.AppDataPreloadService;

@Service()
public class AppDataPreloadServiceImpl   implements AppDataPreloadService {
	@Autowired
	private AppDataPreloadDao appDataPreloadDao;

	@Override
	public AppDataPreload checkUpdate(int codeversion, int platform) {
		return appDataPreloadDao.checkUpdate(codeversion,platform);
	}



}
