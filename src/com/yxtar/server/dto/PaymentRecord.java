package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.UUID;

public class PaymentRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID id;
	private Integer charityFundId;
	private UUID charityFundPhoto;
	private String charityFundTitle;

	private Integer amount;
	private Integer paymentType;
	private Date createTime;
	private Date paidTime;
	private Integer status;

	private UUID paymentRecordphotoId;
	private Integer donationSourceType;

	private Integer charityCampId;
	private String charityCampTitle;
	private UUID charityCampPhoto;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getCharityFundId() {
		return charityFundId;
	}

	public void setCharityFundId(Integer charityFundId) {
		this.charityFundId = charityFundId;
	}

	public UUID getCharityFundPhoto() {
		return charityFundPhoto;
	}

	public void setCharityFundPhoto(UUID charityFundPhoto) {
		this.charityFundPhoto = charityFundPhoto;
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

	public UUID getPaymentRecordphotoId() {
		return paymentRecordphotoId;
	}

	public void setPaymentRecordphotoId(UUID paymentRecordphotoId) {
		this.paymentRecordphotoId = paymentRecordphotoId;
	}

	public Integer getDonationSourceType() {
		return donationSourceType;
	}

	public void setDonationSourceType(Integer donationSourceType) {
		this.donationSourceType = donationSourceType;
	}

	public Integer getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(Integer charityCampId) {
		this.charityCampId = charityCampId;
	}

	public String getCharityCampTitle() {
		return charityCampTitle;
	}

	public void setCharityCampTitle(String charityCampTitle) {
		this.charityCampTitle = charityCampTitle;
	}

	public UUID getCharityCampPhoto() {
		return charityCampPhoto;
	}

	public void setCharityCampPhoto(UUID charityCampPhoto) {
		this.charityCampPhoto = charityCampPhoto;
	}

}
