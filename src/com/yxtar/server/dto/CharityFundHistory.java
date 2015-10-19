package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.util.CustomDateSerializer;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class CharityFundHistory extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}

	private Integer id;
	private CharityFund charityFundId;
	private Integer type;
	private Integer amount;
	private String content;
	private String paymentRecordId;
	private Date createDate;

	private Boolean htmlContentMode;
	private Boolean htmlIntroMode;
	private String htmlContent;
	private String htmlIntro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getPaymentRecordId() {
		return paymentRecordId;
	}

	public void setPaymentRecordId(String paymentRecordId) {
		this.paymentRecordId = paymentRecordId;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public CharityFund getCharityFundId() {
		return charityFundId;
	}

	public void setCharityFundId(CharityFund charityFundId) {
		this.charityFundId = charityFundId;
	}

	public Boolean getHtmlContentMode() {
		return htmlContentMode;
	}

	public void setHtmlContentMode(Boolean htmlContentMode) {
		this.htmlContentMode = htmlContentMode;
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

}
