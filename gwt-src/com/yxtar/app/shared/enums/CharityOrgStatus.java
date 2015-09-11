package com.yxtar.app.shared.enums;
/**
 * CharityOrgStatus
 * @author jackshi
 *
 */
public enum CharityOrgStatus {
	off(0),
	on(1)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityOrgStatus(Integer type) {
		this.type = type;
	}

}
