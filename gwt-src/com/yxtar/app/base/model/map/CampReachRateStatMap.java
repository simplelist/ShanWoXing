package com.yxtar.app.base.model.map;

public class CampReachRateStatMap extends BaseMap {

	private Integer carmpId;
	private Integer reachRate;
	private Integer supportCount;
	private Integer periodNum;

	public Integer getCarmpId() {
		return carmpId;
	}

	public void setCarmpId(Integer carmpid) {
		this.carmpId = carmpid;
	}

	public Integer getReachRate() {
		return reachRate;
	}

	public void setReachRate(Integer reachRate) {
		this.reachRate = reachRate;
	}

	public Integer getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(Integer supportCount) {
		this.supportCount = supportCount;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

}
