package com.yxtar.app.base.model.map;

public class MbrAccBalanceMap extends BaseMap {

	private String memberId;
	private Double mbrFundAccBalance;
	private Double donationAmount;
	private Double amountFromCampSupported;
	private Integer numOfCampSupported;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Double getAmountFromCampSupported() {
		return amountFromCampSupported;
	}

	public void setAmountFromCampSupported(Double amountFromCampSupported) {
		this.amountFromCampSupported = amountFromCampSupported;
	}

	public Integer getNumOfCampSupported() {
		return numOfCampSupported;
	}

	public void setNumOfCampSupported(Integer numOfCampSupported) {
		this.numOfCampSupported = numOfCampSupported;
	}

	public Double getMbrFundAccBalance() {
		return mbrFundAccBalance;
	}

	public void setMbrFundAccBalance(Double mbrFundAccBalance) {
		this.mbrFundAccBalance = mbrFundAccBalance;
	}

}
