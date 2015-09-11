package com.yxtar.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yxtar.server.dao.AdminDao;
import com.yxtar.server.dao.BaseDao;
import com.yxtar.server.dao.IPager;
import com.yxtar.server.dto.Admin;
import com.yxtar.server.service.AdminService;
import com.yxtar.server.util.ListResult;

@Service()
public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService {
	private AdminDao adminDao;

	@Autowired(required = true)
	@Qualifier("adminDao")
	@Override
	public void setBaseDao(BaseDao<Admin, Integer> baseDao) {
		this.baseDao = baseDao;
		adminDao = (AdminDao) baseDao;
	}

	@Override
	public ListResult<Admin> getAdminList(IPager pager,String dtoName) {
		return baseDao.getList(pager,dtoName);
	}


}
