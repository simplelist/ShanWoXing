package com.yxtar.app.base.model.map;


public class PayDonateRelationMap extends BaseMap{

	

	private String paymentid;
	private String donationid;
	private String memberId;
	private String mfirstName;
	private String mlastName;

	private Integer amount;
	private Integer paymentType;

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getDonationid() {
		return donationid;
	}

	public void setDonationid(String donationid) {
		this.donationid = donationid;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
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
