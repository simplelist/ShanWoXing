package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.AdminDao;
import com.yxtar.server.dto.Admin;

@Service()
public class AdminDaoImpl extends BaseDaoImpl<Admin, Integer> implements AdminDao {
}
