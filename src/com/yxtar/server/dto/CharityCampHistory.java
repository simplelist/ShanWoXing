package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;

import java.util.Date;

public class CharityCampHistory extends BaseDto {
	private Integer id;
	private CharityCamp charityCampId;
	private Integer type;
	private Integer percentAge;
	private Integer amount;
	private String paymentRecordId;
	private Date createDate;

	private Boolean htmlMode;
	private String htmlContent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CharityCamp getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(CharityCamp charityCampId) {
		this.charityCampId = charityCampId;
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

	public Boolean getHtmlMode() {
		return htmlMode;
	}

	public void setHtmlMode(Boolean htmlMode) {
		this.htmlMode = htmlMode;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
	}

}
