package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


public class StatisticSponsor extends BaseDto {
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

	private Double sponsorAmount;

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

	public Double getSponsorAmount() {
		return sponsorAmount;
	}

	public void setSponsorAmount(Double sponsorAmount) {
		this.sponsorAmount = sponsorAmount;
	}

}
