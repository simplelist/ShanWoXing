package com.yxtar.server.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.app.shared.TestCassandra;
import com.yxtar.server.cassandra.dao.TestCustomDao;
import com.yxtar.server.cassandra.dao.TestRespository;
import com.yxtar.server.service.TestCassandraService;

@Service
public class TestCassandraServiceImpl implements TestCassandraService {

	@Autowired
	private TestRespository testRespository;
	
	@Autowired
	private TestCustomDao testCustomDao;
	
	
	@Override
	public Boolean save(TestCassandra test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(TestCassandra idlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(List<TestCassandra> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestCassandra findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestCassandra> findAll() {
		return (List<TestCassandra>) testCustomDao.findTestCassandra();
//		return (List<TestCassandra>) testRespository.findAll();
	}

}
