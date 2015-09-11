package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


public class StatisticCCamp extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private String year;
	private String month;
	private String day;

	private Integer ccampCount;

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

	public Integer getCcampCount() {
		return ccampCount;
	}

	public void setCcampCount(Integer ccampCount) {
		this.ccampCount = ccampCount;
	}

}
