package com.yxtar.app.shared.enums;
/**
 * AdvertiserStatusType
 * @author jackshi
 *
 */
public enum PaymentRecordDonationSourceType {
//	0 - From Charity Camp 贊助商
//	1 - From Member Donation 會員捐款
//	2 - From Member Fund Decision 會員決定
	CharityCamp(0),
	MemberDonation(1),
	MemberFundDecision(2),
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private PaymentRecordDonationSourceType(Integer type) {
		this.type = type;
	}

}
