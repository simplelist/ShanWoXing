package com.yxtar.app.shared.enums;
/**
 * DonationStatusType
 * @author jackshi
 *
 */
public enum DonationStatusType {
	Waiting(0), Paid(1),
	Executed(2),Canceled(3)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private DonationStatusType(Integer type) {
		this.type = type;
	}

}
