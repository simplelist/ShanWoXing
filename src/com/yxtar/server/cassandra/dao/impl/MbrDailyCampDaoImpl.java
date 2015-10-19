package com.yxtar.server.cassandra.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.yxtar.server.cassandra.dao.MbrDailyCampRecordDao;

@Repository()
public class MbrDailyCampDaoImpl implements MbrDailyCampRecordDao {

	@Autowired
	private CassandraOperations operation;
}
