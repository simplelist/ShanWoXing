package com.yxtar.server.servlet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.client.AdminRemoteService;
import com.yxtar.server.dao.impl.Pager;
import com.yxtar.server.dto.Admin;
import com.yxtar.server.service.AdminService;
import com.yxtar.server.util.ListResult;

@Component("AdminServlet")
public class AdminServlet extends RemoteServiceServlet implements AdminRemoteService {

	@Autowired
	private AdminService adminService;
	private Pager pager;
	@Override
	public ListResultMap<AdminMap> getAdminList() {
		pager=new Pager();
		pager.setLimit(2);
		pager.setPage(1);
		pager.setOrder("email");
		pager.setSort("desc");
		Map<String, Object> params=new HashMap<String, Object>();
//		params.put("email", "1q@q.q");
//		params.put("id", 1);
		pager.setParams(params);
		ListResultMap<AdminMap> adminMaps = new ListResultMap<AdminMap>();

		ListResult<Admin> list = adminService.getAdminList(pager,Admin.class.getSimpleName());
		if (list != null && list.getCount()>0) {
			adminMaps.setCount(list.getCount());
			for (Admin a : list.getDataList()) {
				if (a!=null) {
					adminMaps.getDataList().add((AdminMap) a.generateMap());
				}
			}
		}
		return adminMaps;
	}

}
