package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.Set;

public class CharityFund extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	private Integer id;
	private CharityOrg charityOrgId;
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
	private Set<CharityCamp> charityCamps;
	private Set<CharityFundHistory> charityFundHistories;
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

	public Set<CharityCamp> getCharityCamps() {
		return charityCamps;
	}

	public void setCharityCamps(Set<CharityCamp> charityCamps) {
		this.charityCamps = charityCamps;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Set<CharityFundHistory> getCharityFundHistories() {
		return charityFundHistories;
	}

	public void setCharityFundHistories(Set<CharityFundHistory> charityFundHistories) {
		this.charityFundHistories = charityFundHistories;
	}

	public CharityOrg getCharityOrgId() {
		return charityOrgId;
	}

	public void setCharityOrgId(CharityOrg charityOrgId) {
		this.charityOrgId = charityOrgId;
	}

}
