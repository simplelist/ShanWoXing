package com.yxtar.app.shared.enums;
/**
 * PlatformLocationStatusType
 * @author jackshi
 *
 */
public enum PlatformLocationStatusType {
	QRCodeScan(0)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private PlatformLocationStatusType(Integer type) {
		this.type = type;
	}

}
