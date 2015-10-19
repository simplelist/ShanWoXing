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

	private String content;
	private Boolean htmlIntroMode;
	private String htmlIntro;
	private Boolean htmlContentMode;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getHtmlIntroMode() {
		return htmlIntroMode;
	}

	public void setHtmlIntroMode(Boolean htmlIntroMode) {
		this.htmlIntroMode = htmlIntroMode;
	}

	public String getHtmlIntro() {
		return htmlIntro;
	}

	public void setHtmlIntro(String htmlIntro) {
		this.htmlIntro = htmlIntro;
	}

	public Boolean getHtmlContentMode() {
		return htmlContentMode;
	}

	public void setHtmlContentMode(Boolean htmlContentMode) {
		this.htmlContentMode = htmlContentMode;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

}
