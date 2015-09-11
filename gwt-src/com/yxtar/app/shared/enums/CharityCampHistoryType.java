package com.yxtar.app.shared.enums;
/**
 * CharityCampHistoryType
 * @author jackshi
 *
 */
public enum CharityCampHistoryType {
	campCreated(0),
	campStatusReport(1),
	campSuccess(2),
	campFail(3),
	DonationEvent(4)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityCampHistoryType(Integer type) {
		this.type = type;
	}

}
