package com.yxtar.server.service;

import com.yxtar.server.util.ListResult;
import com.yxtar.server.dao.IPager;
import com.yxtar.server.dto.Admin;

public interface AdminService extends BaseService<Admin, Integer>{
	ListResult<Admin> getAdminList(IPager pager,String dtoName);
}
