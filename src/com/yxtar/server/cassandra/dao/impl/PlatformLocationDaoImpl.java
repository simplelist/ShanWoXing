package com.yxtar.server.cassandra.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Update;
import com.yxtar.server.cassandra.dao.PlatformLocationDao;
import com.yxtar.server.dto.cassandra.PlatformLocation;

@Repository()
public class PlatformLocationDaoImpl implements PlatformLocationDao {

	@Autowired
	private CassandraOperations operation;

	@Override
	public PlatformLocation updateRate(PlatformLocation location) {
		if (location == null) {
			return null;
		}
		Update update = QueryBuilder.update("platform_location");
		update.setConsistencyLevel(ConsistencyLevel.ONE);
		update.with(QueryBuilder.set("reachrate", location.getReachRate()));
		update.where(QueryBuilder.eq("locationid", location.getLocationId()));
		update.where(QueryBuilder.eq("province", location.getProvince()));
		update.where(QueryBuilder.eq("street", location.getStreet()));
		update.where(QueryBuilder.eq("city", location.getCity()));
		update.where(QueryBuilder.eq("district", location.getDistrict()));
		ResultSet results = operation.getSession().execute(update);
		for (Row row : results) {
			location.setReachRate(row.getInt("reachrate"));
			break;
		}
		return location;
	}
}
