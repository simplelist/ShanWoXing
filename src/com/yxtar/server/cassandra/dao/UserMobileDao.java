package com.yxtar.server.cassandra.dao;

import com.yxtar.server.dto.cassandra.UserMobile;

public interface UserMobileDao {
	UserMobile findByPhone(String phone);
}
