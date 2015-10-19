package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.AppDataPreload;

@Repository()
public interface AppDataPreloadDao extends BaseDao<AppDataPreload, Integer> {

	AppDataPreload checkUpdate(int codeversion, int platform);
}
