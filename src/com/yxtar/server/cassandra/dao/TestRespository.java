package com.yxtar.server.cassandra.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.app.shared.TestCassandra;

@Repository
public interface TestRespository extends CrudRepository<TestCassandra, UUID>{
}
