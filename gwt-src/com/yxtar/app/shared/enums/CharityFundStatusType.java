package com.yxtar.app.shared.enums;
/**
 * CharityFundStatusType
 * @author jackshi
 *
 */
public enum CharityFundStatusType {
	off(0),
	on(1)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityFundStatusType(Integer type) {
		this.type = type;
	}

}
