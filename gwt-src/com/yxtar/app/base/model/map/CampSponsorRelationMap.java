package com.yxtar.app.base.model.map;

public class CampSponsorRelationMap extends BaseMap{
	private Integer id;
	private CharityCampMap charityCampMap;
	private SponsorMap sponsorMap;
	private Double donationAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public CharityCampMap getCharityCampMap() {
		return charityCampMap;
	}

	public void setCharityCampMap(CharityCampMap charityCampMap) {
		this.charityCampMap = charityCampMap;
	}

	public SponsorMap getSponsorMap() {
		return sponsorMap;
	}

	public void setSponsorMap(SponsorMap sponsorMap) {
		this.sponsorMap = sponsorMap;
	}

}
