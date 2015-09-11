package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


public class CampSponsorRelation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}

	private Integer id;
	private CharityCamp charityCamp;
	private Sponsor sponsor;
	private Double donationAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CharityCamp getCharityCamp() {
		return charityCamp;
	}

	public void setCharityCamp(CharityCamp charityCamp) {
		this.charityCamp = charityCamp;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

}
