package com.yxtar.app.shared.enums;
/**
 * DailyCampActionType
 * @author jackshi
 *
 */
public enum DailyCampActionType {
	QRCodeScan(0)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private DailyCampActionType(Integer type) {
		this.type = type;
	}

}
