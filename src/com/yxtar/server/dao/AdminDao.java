package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.Admin;

@Repository()
public interface AdminDao extends BaseDao<Admin, Integer> {
}
