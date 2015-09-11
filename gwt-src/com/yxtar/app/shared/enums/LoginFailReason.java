package com.yxtar.app.shared.enums;
/**
 * AdvertiserStatusType
 * @author jackshi
 *
 */
public enum LoginFailReason {
	// 0001 - incorrect password
	// 0002 - mobile number not exist
	// 0003 - Invalid member account
	IncorrectPassword("0001"),
	MobileNumberNotExist("0002"),
	InvalidMemberAccount("0003")
	;
	
	private String type;

	public String getType() {
		return type;
	}

	private LoginFailReason(String type) {
		this.type = type;
	}

}
