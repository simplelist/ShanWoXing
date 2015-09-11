package com.yxtar.app.shared.enums;

/**
 * SponsorStatusType
 * 
 * @author jackshi
 *
 */
public enum SponsorStatusType {
	off(0), on(1);

	private Integer type;

	public Integer getType() {
		return type;
	}

	private SponsorStatusType(Integer type) {
		this.type = type;
	}

}
