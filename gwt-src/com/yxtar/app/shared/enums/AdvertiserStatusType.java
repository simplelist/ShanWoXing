package com.yxtar.app.shared.enums;
/**
 * AdvertiserStatusType
 * @author jackshi
 *
 */
public enum AdvertiserStatusType {
	off(0),
	on(1)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private AdvertiserStatusType(Integer type) {
		this.type = type;
	}

}
