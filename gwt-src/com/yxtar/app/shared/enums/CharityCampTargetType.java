package com.yxtar.app.shared.enums;
/**
 * CharityCampTargetType
 * @author jackshi
 *
 */
public enum CharityCampTargetType {
	singleTarget(0),
	mutipleTargets(1),
	maxBoundary(2)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private CharityCampTargetType(Integer type) {
		this.type = type;
	}

}
