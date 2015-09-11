package com.yxtar.app.shared.enums;
/**
 * DailyCampStatusType
 * @author jackshi
 *
 */
public enum DailyCampStatusType {
	preparing(0),
	production(1),
	end(2)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private DailyCampStatusType(Integer type) {
		this.type = type;
	}

}
