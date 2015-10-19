package com.yxtar.server.dto;

import java.util.Date;

import org.springframework.data.cassandra.mapping.PrimaryKey;

import com.yxtar.app.base.model.map.BaseMap;

public class DailyCamp extends BaseDto {

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private Integer dcampId;
	private Integer priority;
	private Sponsor sponsorId;
	private String campTitle;
	private String campAdvPhoto;

	private String province;
	private String city;
	private String district;
	private String street;
	private Double amountPerSupport;
	private Date createTime;
	private Integer status;

	public Integer getDcampId() {
		return dcampId;
	}

	public void setDcampId(Integer dcampId) {
		this.dcampId = dcampId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	public Sponsor getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Sponsor sponsorId) {
		this.sponsorId = sponsorId;
	}

}
