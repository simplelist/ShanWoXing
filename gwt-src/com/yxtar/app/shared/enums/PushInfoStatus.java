package com.yxtar.app.shared.enums;

/**
 * SponsorStatusType
 * 
 * @author jackshi
 *
 */
public enum PushInfoStatus {
	off(0), on(1);

	private Integer type;

	public Integer getType() {
		return type;
	}

	private PushInfoStatus(Integer type) {
		this.type = type;
	}

}
