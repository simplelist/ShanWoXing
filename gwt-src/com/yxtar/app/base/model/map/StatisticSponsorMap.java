package com.yxtar.app.base.model.map;

public class StatisticSponsorMap extends BaseMap{

	

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
