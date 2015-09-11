package com.yxtar.app.base.model.map;

import java.util.Date;

public class FundDecisionRecordMap extends BaseMap {
	private String fundDecisionId;
	private String memberId;
	private String mnickName;
	private Integer charityFundId;
	private String charityFundTitle;
	private Integer amount;
	private Date createTime;
	private Integer status;
	private String paymentRecordId;

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

	public String getMnickName() {
		return mnickName;
	}

	public void setMnickName(String mnickName) {
		this.mnickName = mnickName;
	}

	public Integer getCharityFundId() {
		return charityFundId;
	}

	public void setCharityFundId(Integer charityFundId) {
		this.charityFundId = charityFundId;
	}

	public String getCharityFundTitle() {
		return charityFundTitle;
	}

	public void setCharityFundTitle(String charityFundTitle) {
		this.charityFundTitle = charityFundTitle;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPaymentRecordId() {
		return paymentRecordId;
	}

	public void setPaymentRecordId(String paymentRecordId) {
		this.paymentRecordId = paymentRecordId;
	}



}
