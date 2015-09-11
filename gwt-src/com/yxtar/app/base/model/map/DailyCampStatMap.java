package com.yxtar.app.base.model.map;


public class DailyCampStatMap extends BaseMap{


	private String dcampId;
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

	public String getDcampId() {
		return dcampId;
	}

	public void setDcampId(String dcampId) {
		this.dcampId = dcampId;
	}

	

}
