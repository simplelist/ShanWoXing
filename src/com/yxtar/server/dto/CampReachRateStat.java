package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


public class CampReachRateStat extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private Integer carmpId;
	private Integer reachRate;
	private Integer supportCount;

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

}
