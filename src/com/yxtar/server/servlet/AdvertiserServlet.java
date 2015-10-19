package com.yxtar.server.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.client.AdvertiserRemoteService;
import com.yxtar.server.dto.Advertiser;
import com.yxtar.server.service.AdvertiserService;
import com.yxtar.server.util.ListResult;

@Component("AdvertiserServlet")
public class AdvertiserServlet extends RemoteServiceServlet implements AdvertiserRemoteService {

	@Autowired
	private AdvertiserService advertiserService;
	
	@Override
	public ListResultMap<AdvertiserMap> getList(AdvertiserMap map, int pageIndex, int maxResult) {
		ListResultMap<AdvertiserMap> resultMap = new ListResultMap<AdvertiserMap>();

		ListResult<Advertiser> list = advertiserService.getList(map,pageIndex,maxResult);
		if (list != null && list.getCount()>0) {
			resultMap.setCount(list.getCount());
			for (Advertiser a : list.getDataList()) {
				if (a!=null) {
					resultMap.getDataList().add((AdvertiserMap) a.generateMap());
				}
			}
		}
		return resultMap;
	}

}
