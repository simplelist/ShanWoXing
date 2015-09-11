package com.yxtar.app.shared.enums;
/**
 * CharityFundHistoryType
 * @author jackshi
 *
 */
public enum CharityFundHistoryType {
	FundCreated(0),
	CampSupproted(1),
	DonationEvent(2)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityFundHistoryType(Integer type) {
		this.type = type;
	}

}
