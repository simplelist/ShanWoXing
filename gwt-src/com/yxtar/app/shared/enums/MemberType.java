package com.yxtar.app.shared.enums;
/**
 * MemberType
 * @author jackshi
 *
 */
public enum MemberType {
	FullyRegister(0), WeChatRegister(1);
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private MemberType(Integer type) {
		this.type = type;
	}

}
