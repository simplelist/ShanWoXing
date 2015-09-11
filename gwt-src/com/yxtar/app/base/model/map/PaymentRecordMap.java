package com.yxtar.app.base.model.map;

import java.util.Date;

public class PaymentRecordMap extends BaseMap{

	

	private String id;
	private Integer charityFundId;
	private String charityFundPhoto;
	private String charityFundTitle;

	private Integer amount;
	private Integer paymentType;
	private Date createTime;
	private Date paidTime;
	private Integer status;

	private String paymentRecordphotoId;
	private Integer donationSourceType;

	private Integer charityCampId;
	private String charityCampTitle;
	private String charityCampPhoto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCharityFundId() {
		return charityFundId;
	}

	public void setCharityFundId(Integer charityFundId) {
		this.charityFundId = charityFundId;
	}

	public String getCharityFundPhoto() {
		return charityFundPhoto;
	}

	public void setCharityFundPhoto(String charityFundPhoto) {
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

	public String getPaymentRecordphotoId() {
		return paymentRecordphotoId;
	}

	public void setPaymentRecordphotoId(String paymentRecordphotoId) {
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

	public String getCharityCampPhoto() {
		return charityCampPhoto;
	}

	public void setCharityCampPhoto(String charityCampPhoto) {
		this.charityCampPhoto = charityCampPhoto;
	}

}
