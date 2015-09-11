package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.Admin;
import com.yxtar.server.util.ListResult;

@Repository()
public interface AdminDao extends BaseDao<Admin, Integer> {
//	ListResult<Admin> getAdminList(IPager pager);
}
