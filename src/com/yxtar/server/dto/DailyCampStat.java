package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.UUID;

public class DailyCampStat extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID dcampId;
	private Integer supportRate;
	private Integer donationAmount;
	private Double remainAmound;
	private Double remainPreparedAmount;

	public Integer getSupportRate() {
		return supportRate;
	}

	public void setSupportRate(Integer supportRate) {
		this.supportRate = supportRate;
	}

	public Integer getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Integer donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Double getRemainAmound() {
		return remainAmound;
	}

	public void setRemainAmound(Double remainAmound) {
		this.remainAmound = remainAmound;
	}

	public Double getRemainPreparedAmount() {
		return remainPreparedAmount;
	}

	public void setRemainPreparedAmount(Double remainPreparedAmount) {
		this.remainPreparedAmount = remainPreparedAmount;
	}

	public UUID getDcampId() {
		return dcampId;
	}

	public void setDcampId(UUID dcampId) {
		this.dcampId = dcampId;
	}

	

}
