package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.UUID;

public class DailyCamp extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID dcampId;
	private Integer priority;
	private Integer sponsorId;
	private String sponsorName;
	private UUID sponsorPhoto;
	private String campTitle;
	private UUID campAdvPhoto;

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

	public UUID getSponsorPhoto() {
		return sponsorPhoto;
	}

	public void setSponsorPhoto(UUID sponsorPhoto) {
		this.sponsorPhoto = sponsorPhoto;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public UUID getCampAdvPhoto() {
		return campAdvPhoto;
	}

	public void setCampAdvPhoto(UUID campAdvPhoto) {
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

	public UUID getDcampId() {
		return dcampId;
	}

	public void setDcampId(UUID dcampId) {
		this.dcampId = dcampId;
	}

}
