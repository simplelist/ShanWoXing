package com.yxtar.app.shared.enums;
/**
 * AdvertiserStatusType
 * @author jackshi
 *
 */
public enum DailyCampFailReason {
//	0001 - location already used today
	LocationAlreadyUsed("0001");
	
	
	private String type;

	public String getType() {
		return type;
	}

	private DailyCampFailReason(String type) {
		this.type = type;
	}

}
