package com.yxtar.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.server.dao.AdminDao;
import com.yxtar.server.dao.IPager;
import com.yxtar.server.dao.impl.Pager;
import com.yxtar.server.dto.Admin;
import com.yxtar.server.service.AdminService;
import com.yxtar.server.util.ListResult;

@Service()
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	private IPager pager;

	@Override
	public ListResult<Admin> getList(AdminMap map, int pageIndex, int maxResult) {
		pager = new Pager();
		pager.setLimit(maxResult);
		pager.setPage(pageIndex);
		pager.setOrder("email");
		pager.setSort("desc");
		Map<String, Object> params = new HashMap<String, Object>();
		// params.put("email", "1q@q.q");
		// params.put("id", 1);
		pager.setParams(params);
		return adminDao.getList(pager, Admin.class.getSimpleName());
	}

}
