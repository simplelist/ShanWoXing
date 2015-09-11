package com.yxtar.app.shared.enums;
/**
 * AdvertiserStatusType
 * @author jackshi
 *
 */
public enum FundDecisionStatus {
//	1 - Waiting 待執行
//	2 - Executed 已執行
	Waiting(1),
	Executed(2)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private FundDecisionStatus(Integer type) {
		this.type = type;
	}

}
