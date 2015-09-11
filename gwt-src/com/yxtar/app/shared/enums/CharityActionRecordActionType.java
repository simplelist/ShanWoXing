package com.yxtar.app.shared.enums;

/**
 * CharityActionRecordActionType
 * 
 * @author jackshi
 */
public enum CharityActionRecordActionType {
	QRCode(0), AdvPhoto(1), MC(2), TextAnswer(3), ;

	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityActionRecordActionType(Integer type) {
		this.type = type;
	}

}
