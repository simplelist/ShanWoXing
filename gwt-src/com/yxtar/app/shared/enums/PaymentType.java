package com.yxtar.app.shared.enums;
/**
 * PaymentType
 * @author jackshi
 *
 */
public enum PaymentType {
	Alipay(0);
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private PaymentType(Integer type) {
		this.type = type;
	}

}
