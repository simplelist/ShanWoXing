package com.yxtar.server.cassandra.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.yxtar.app.shared.TestCassandra;
import com.yxtar.server.util.UUIDUtil;

@Repository()
public class TestCustomDaoImpl implements TestCustomDao {

	@Autowired
	private CassandraOperations operation;

	@Override
	public List<TestCassandra> findTestCassandra() {
		UUID uuid = UUIDUtil.create("d92d4940-08fd-11e5-6130-e3388a085424");
		PreparedStatement ps1 = this.operation.getSession().prepare("insert into testcassandra(id,displayname) values(?,?);");
		BoundStatement bindStatement1 = new BoundStatement(ps1).bind(uuid, "this is a statement");
		ps1.setConsistencyLevel(ConsistencyLevel.QUORUM);
		operation.getSession().execute(bindStatement1);
		List<TestCassandra> result = new ArrayList<TestCassandra>();
		Select select = QueryBuilder.select().all().from("shanwoxing", "testcassandra");
		select.setConsistencyLevel(ConsistencyLevel.QUORUM);
		ResultSet rs = operation.getSession().execute(select);
		for (Row row : rs) {
			TestCassandra indx = new TestCassandra();
			indx.setDisplayName(row.getString("displayname"));
			indx.setId(row.getUUID("id").toString());
			result.add(indx);
		}
		return result;
	}
	// @Override
	// public List<TestCassandra> findTestCassandra() {
	// List<TestCassandra> result = new ArrayList<TestCassandra>();
	// String cql = "select * from testcassandra;";
	// ResultSet rs = operation.query(cql);
	// for (Row row : rs) {
	// TestCassandra indx = new TestCassandra();
	// indx.setDisplayName(row.getString("displayname"));
	// indx.setId(row.getUUID("id").toString());
	// result.add(indx);
	// }
	// return result;
	// }
}
