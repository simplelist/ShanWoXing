package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.util.CustomDateSerializer;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class MoneyInRecord extends BaseDto{

	private Integer id;
	private Advertiser advertiserId;
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
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
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

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Advertiser getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(Advertiser advertiserId) {
		this.advertiserId = advertiserId;
	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
	}

}
