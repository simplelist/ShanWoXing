package com.yxtar.server.service;

import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.server.dto.Advertiser;
import com.yxtar.server.util.ListResult;

public interface AdvertiserService {
	ListResult<Advertiser> getList(AdvertiserMap map, int pageIndex, int maxResult);
}
