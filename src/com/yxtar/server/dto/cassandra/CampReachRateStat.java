package com.yxtar.server.dto.cassandra;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("camp_reach_rate_stat")
public class CampReachRateStat extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_CampReachRateStat pk;
	@CassandraType(type = Name.COUNTER)
	private Long reachRate;
	@CassandraType(type = Name.COUNTER)
	private Long supportCount;

	public PK_CampReachRateStat getPk() {
		return pk;
	}

	public void setPk(PK_CampReachRateStat pk) {
		this.pk = pk;
	}

	public Long getReachRate() {
		return reachRate;
	}

	public void setReachRate(Long reachRate) {
		this.reachRate = reachRate;
	}

	public Long getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(Long supportCount) {
		this.supportCount = supportCount;
	}

}
