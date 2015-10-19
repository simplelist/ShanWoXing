package com.yxtar.server.cassandra.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.yxtar.server.cassandra.dao.UserMobileDao;
import com.yxtar.server.dto.cassandra.UserMobile;

@Repository()
public class UserMobileDaoImpl implements UserMobileDao {

	@Autowired
	private CassandraOperations operation;

	@Override
	public UserMobile findByPhone(String phone) {
		if (phone == null) {
			return null;
		}
		String cql = "select * from user_mobile where phonenum='" + phone + "'";
		Iterable<UserMobile> rs = operation.select(cql, UserMobile.class);

		UserMobile mobile = null;
		if (rs != null) {
			for (UserMobile userMobile : rs) {
				if (userMobile != null) {
					mobile = userMobile;
					break;
				}
			}
		}
		return mobile;
	}
}
