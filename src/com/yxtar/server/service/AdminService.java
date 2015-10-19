package com.yxtar.server.service;

import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.server.dto.Admin;
import com.yxtar.server.util.ListResult;


public interface AdminService{

	ListResult<Admin> getList(AdminMap map, int pageIndex, int maxResult);
}
