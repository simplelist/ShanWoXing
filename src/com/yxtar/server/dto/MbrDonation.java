package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.UUID;

public class MbrDonation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID memberId;
	private UUID donationId;
	private Integer charityFundId;
	private String charityFundTitle;
	private UUID charityFundphoto;

	private Integer amount;
	private Integer paymentType;
	private Date createTime;
	private Date paidTime;
	private Integer status;
	private UUID payRecordId;
	private Integer payRecordAmount;
	private Integer payRecordPayType;

	private Date payRecordCreateTime;
	private Date payRecordPaidTime;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public UUID getDonationId() {
		return donationId;
	}

	public void setDonationId(UUID donationId) {
		this.donationId = donationId;
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

	public UUID getCharityFundphoto() {
		return charityFundphoto;
	}

	public void setCharityFundphoto(UUID charityFundphoto) {
		this.charityFundphoto = charityFundphoto;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPaidTime() {
		return paidTime;
	}

	public void setPaidTime(Date paidTime) {
		this.paidTime = paidTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UUID getPayRecordId() {
		return payRecordId;
	}

	public void setPayRecordId(UUID payRecordId) {
		this.payRecordId = payRecordId;
	}

	public Integer getPayRecordAmount() {
		return payRecordAmount;
	}

	public void setPayRecordAmount(Integer payRecordAmount) {
		this.payRecordAmount = payRecordAmount;
	}

	public Integer getPayRecordPayType() {
		return payRecordPayType;
	}

	public void setPayRecordPayType(Integer payRecordPayType) {
		this.payRecordPayType = payRecordPayType;
	}

	public Date getPayRecordCreateTime() {
		return payRecordCreateTime;
	}

	public void setPayRecordCreateTime(Date payRecordCreateTime) {
		this.payRecordCreateTime = payRecordCreateTime;
	}

	public Date getPayRecordPaidTime() {
		return payRecordPaidTime;
	}

	public void setPayRecordPaidTime(Date payRecordPaidTime) {
		this.payRecordPaidTime = payRecordPaidTime;
	}

}
