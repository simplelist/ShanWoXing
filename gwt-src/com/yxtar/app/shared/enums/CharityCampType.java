package com.yxtar.app.shared.enums;
/**
 * CharityCampType
 * @author jackshi
 *
 */
public enum CharityCampType {
	oneTimeOnly(0),
	cycle(1)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityCampType(Integer type) {
		this.type = type;
	}

}
