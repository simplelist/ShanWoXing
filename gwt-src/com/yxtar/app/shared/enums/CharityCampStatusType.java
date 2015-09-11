package com.yxtar.app.shared.enums;
/**
 * CharityCampStatusType
 * @author jackshi
 *
 */
public enum CharityCampStatusType {
	prepare(0),
	production(1),
	end(2),
	success(3),
	fail(4)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityCampStatusType(Integer type) {
		this.type = type;
	}

}
