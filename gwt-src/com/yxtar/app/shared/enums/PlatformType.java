package com.yxtar.app.shared.enums;
/**
 * AdvertiserStatusType
 * @author jackshi
 *
 */
public enum PlatformType {
//	0 -web
//	1 -ios
//	2- android
	web(0),
	ios(1),
	android(2),
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private PlatformType(Integer type) {
		this.type = type;
	}

}
