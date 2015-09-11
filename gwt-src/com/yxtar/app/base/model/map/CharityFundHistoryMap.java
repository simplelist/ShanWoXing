package com.yxtar.app.base.model.map;

import java.util.Date;



public class CharityFundHistoryMap extends BaseMap {
	private Integer id;
	private CharityFundHistoryMap charityFundId;
	private Integer type;
	private Integer amount;
	private String content;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public CharityFundHistoryMap getCharityFundId() {
		return charityFundId;
	}

	public void setCharityFundId(CharityFundHistoryMap charityFundId) {
		this.charityFundId = charityFundId;
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

}
