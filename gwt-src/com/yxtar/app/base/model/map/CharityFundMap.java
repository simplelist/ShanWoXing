package com.yxtar.app.base.model.map;

import java.util.Date;



public class CharityFundMap extends BaseMap {
	private Integer id;
	private CharityOrgMap charityOrgId;
	private String title;
	private String mainSmallPhoto;
	private String eventSmallPhoto;
	private String eventBackgroundPhoto;
	private String voteTablePhoto;
	private String introMainPhoto;
	private String introdShort;
	private String introdLong;
	private Integer introdPageNum;
	private String htmlIntrod;
	private Date createDate;
	private Date endDate;
	private Integer status;
	private Double fundTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainSmallPhoto() {
		return mainSmallPhoto;
	}

	public void setMainSmallPhoto(String mainSmallPhoto) {
		this.mainSmallPhoto = mainSmallPhoto;
	}

	public String getEventSmallPhoto() {
		return eventSmallPhoto;
	}

	public void setEventSmallPhoto(String eventSmallPhoto) {
		this.eventSmallPhoto = eventSmallPhoto;
	}

	public String getEventBackgroundPhoto() {
		return eventBackgroundPhoto;
	}

	public void setEventBackgroundPhoto(String eventBackgroundPhoto) {
		this.eventBackgroundPhoto = eventBackgroundPhoto;
	}

	public String getVoteTablePhoto() {
		return voteTablePhoto;
	}

	public void setVoteTablePhoto(String voteTablePhoto) {
		this.voteTablePhoto = voteTablePhoto;
	}

	public String getIntroMainPhoto() {
		return introMainPhoto;
	}

	public void setIntroMainPhoto(String introMainPhoto) {
		this.introMainPhoto = introMainPhoto;
	}

	public String getIntrodShort() {
		return introdShort;
	}

	public void setIntrodShort(String introdShort) {
		this.introdShort = introdShort;
	}

	public String getIntrodLong() {
		return introdLong;
	}

	public void setIntrodLong(String introdLong) {
		this.introdLong = introdLong;
	}

	public Integer getIntrodPageNum() {
		return introdPageNum;
	}

	public void setIntrodPageNum(Integer introdPageNum) {
		this.introdPageNum = introdPageNum;
	}

	public String getHtmlIntrod() {
		return htmlIntrod;
	}

	public void setHtmlIntrod(String htmlIntrod) {
		this.htmlIntrod = htmlIntrod;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getFundTotal() {
		return fundTotal;
	}

	public void setFundTotal(Double fundTotal) {
		this.fundTotal = fundTotal;
	}

	public CharityOrgMap getCharityOrgId() {
		return charityOrgId;
	}

	public void setCharityOrgId(CharityOrgMap charityOrgId) {
		this.charityOrgId = charityOrgId;
	}
}
