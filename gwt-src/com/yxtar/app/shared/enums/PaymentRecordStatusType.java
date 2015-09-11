package com.yxtar.app.shared.enums;
/**
 * PaymentRecordStatusType
 * @author jackshi
 *
 */
public enum PaymentRecordStatusType {
	WaitingForPayment(0),
	Paid(1);
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private PaymentRecordStatusType(Integer type) {
		this.type = type;
	}

}
