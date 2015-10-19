package com.yxtar.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.server.dao.AdvertiserDao;
import com.yxtar.server.dao.impl.Pager;
import com.yxtar.server.dto.Advertiser;
import com.yxtar.server.service.AdvertiserService;
import com.yxtar.server.util.ListResult;

@Service()
public class AdvertiserServiceImpl implements AdvertiserService {
	@Autowired
	private AdvertiserDao advertiserDao;
	private Pager pager;
	@Override
	public ListResult<Advertiser> getList(AdvertiserMap map, int pageIndex, int maxResult) {
		pager=new Pager();
		pager.setLimit(maxResult);
		pager.setPage(pageIndex);
		pager.setOrder("cpersonEmail");
		pager.setSort("desc");
//		Map<String, Object> params=new HashMap<String, Object>();
//		params.put("email", "1q@q.q");
//		params.put("id", 1);
//		pager.setParams(params);
		
		return advertiserDao.getList(pager, Advertiser.class.getSimpleName());
	}


}
