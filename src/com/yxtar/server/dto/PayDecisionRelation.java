package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;

import java.util.Date;
import java.util.UUID;

public class PayDecisionRelation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID paymentid;
	private UUID fundDecisionId;
	private UUID memberId;
	private String mnickName;
	private Integer amount;
	private Integer paymentType;

	public UUID getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(UUID paymentid) {
		this.paymentid = paymentid;
	}

	public UUID getFundDecisionId() {
		return fundDecisionId;
	}

	public void setFundDecisionId(UUID fundDecisionId) {
		this.fundDecisionId = fundDecisionId;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

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

}
