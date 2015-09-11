package com.yxtar.app.base.model.map;

import java.util.Date;



public class CharityCampHistoryMap extends BaseMap {
	private Integer id;
	private CharityCampMap charityCampId;
	private Integer type;
	private Integer percentAge;
	private Integer amount;
	private String paymentRecordId;
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPercentAge() {
		return percentAge;
	}

	public void setPercentAge(Integer percentAge) {
		this.percentAge = percentAge;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPaymentRecordId() {
		return paymentRecordId;
	}

	public void setPaymentRecordId(String paymentRecordId) {
		this.paymentRecordId = paymentRecordId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public CharityCampMap getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(CharityCampMap charityCampId) {
		this.charityCampId = charityCampId;
	}

}
