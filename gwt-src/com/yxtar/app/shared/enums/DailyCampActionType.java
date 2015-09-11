package com.yxtar.app.shared.enums;
/**
 * DailyCampActionType
 * @author jackshi
 *
 */
public enum DailyCampActionType {
	off(0),
	on(1)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private DailyCampActionType(Integer type) {
		this.type = type;
	}

}
