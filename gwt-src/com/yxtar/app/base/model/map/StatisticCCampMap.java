package com.yxtar.app.base.model.map;

public class StatisticCCampMap extends BaseMap{

	

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
