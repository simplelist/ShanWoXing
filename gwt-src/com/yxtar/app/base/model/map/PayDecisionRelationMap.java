package com.yxtar.app.base.model.map;


public class PayDecisionRelationMap extends BaseMap {
	private String paymentid;
	private String fundDecisionId;
	private String memberId;
	private String mnickName;
	private Integer amount;
	private Integer paymentType;

	public String getMnickName() {
		return mnickName;
	}

	public void setMnickName(String mnickName) {
		this.mnickName = mnickName;
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

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getFundDecisionId() {
		return fundDecisionId;
	}

	public void setFundDecisionId(String fundDecisionId) {
		this.fundDecisionId = fundDecisionId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
