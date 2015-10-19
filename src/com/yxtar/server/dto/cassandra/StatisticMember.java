package com.yxtar.server.dto.cassandra;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("statistic_member")
public class StatisticMember extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String year;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String month;
	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.PARTITIONED)
	private String day;

	private Integer memberCount;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

}
