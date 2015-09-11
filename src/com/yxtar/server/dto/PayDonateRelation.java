package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.UUID;

public class PayDonateRelation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID paymentid;
	private UUID donationid;
	private UUID memberId;
	private String mfirstName;
	private String mlastName;

	private Integer amount;
	private Integer paymentType;

	public UUID getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(UUID paymentid) {
		this.paymentid = paymentid;
	}

	public UUID getDonationid() {
		return donationid;
	}

	public void setDonationid(UUID donationid) {
		this.donationid = donationid;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getMfirstName() {
		return mfirstName;
	}

	public void setMfirstName(String mfirstName) {
		this.mfirstName = mfirstName;
	}

	public String getMlastName() {
		return mlastName;
	}

	public void setMlastName(String mlastName) {
		this.mlastName = mlastName;
	}

}
