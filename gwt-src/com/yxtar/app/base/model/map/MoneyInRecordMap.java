package com.yxtar.app.base.model.map;

import java.util.Date;



public class MoneyInRecordMap extends BaseMap {
	private Integer id;
	private AdvertiserMap advertiserId;
	private Double amount;
	private Integer paymentType;
	private Date createTime;
	private Date paidTime;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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

	public AdvertiserMap getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(AdvertiserMap advertiserId) {
		this.advertiserId = advertiserId;
	}
}
