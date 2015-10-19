package com.yxtar.server.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.client.AdminRemoteService;
import com.yxtar.server.dto.Admin;
import com.yxtar.server.service.AdminService;
import com.yxtar.server.util.ListResult;

@Component("AdminServlet")
public class AdminServlet extends RemoteServiceServlet implements AdminRemoteService {

	@Autowired
	private AdminService adminService;
	@Override
	public ListResultMap<AdminMap> getList(AdminMap map, int pageIndex, int maxResult) {
		ListResultMap<AdminMap> adminMaps = new ListResultMap<AdminMap>();
		ListResult<Admin> list = adminService.getList(map,pageIndex,maxResult);
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
