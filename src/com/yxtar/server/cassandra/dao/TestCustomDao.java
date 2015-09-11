package com.yxtar.server.cassandra.dao;

import java.util.List;

import com.yxtar.app.shared.TestCassandra;

public interface TestCustomDao {
	List<TestCassandra> findTestCassandra();
}
