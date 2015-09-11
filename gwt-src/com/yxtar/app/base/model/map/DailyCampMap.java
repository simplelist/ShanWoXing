package com.yxtar.app.base.model.map;

import java.util.Date;

public class DailyCampMap  extends BaseMap{


	private String dcampId;
	private Integer priority;
	private Integer sponsorId;
	private String sponsorName;
	private String sponsorPhoto;
	private String campTitle;
	private String campAdvPhoto;

	private String province;
	private String city;
	private String district;
	private String street;
	private Double amountPerSupport;
	private Date createTime;
	private Integer status;

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getSponsorPhoto() {
		return sponsorPhoto;
	}

	public void setSponsorPhoto(String sponsorPhoto) {
		this.sponsorPhoto = sponsorPhoto;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public String getCampAdvPhoto() {
		return campAdvPhoto;
	}

	public void setCampAdvPhoto(String campAdvPhoto) {
		this.campAdvPhoto = campAdvPhoto;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Double getAmountPerSupport() {
		return amountPerSupport;
	}

	public void setAmountPerSupport(Double amountPerSupport) {
		this.amountPerSupport = amountPerSupport;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getDcampId() {
		return dcampId;
	}

	public void setDcampId(String dcampId) {
		this.dcampId = dcampId;
	}

}
