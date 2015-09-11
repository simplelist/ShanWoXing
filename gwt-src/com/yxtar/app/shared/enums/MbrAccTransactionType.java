package com.yxtar.app.shared.enums;
/**
 * MbrAccTransactionType
 * @author jackshi
 */
public enum MbrAccTransactionType {
	MoneyIn(0), MoneyOut(1);
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private MbrAccTransactionType(Integer type) {
		this.type = type;
	}

}
