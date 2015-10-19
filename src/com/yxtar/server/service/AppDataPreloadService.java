package com.yxtar.server.service;

import com.yxtar.server.dto.AppDataPreload;


public interface AppDataPreloadService {

	AppDataPreload checkUpdate(int codeversion, int platform);
}
