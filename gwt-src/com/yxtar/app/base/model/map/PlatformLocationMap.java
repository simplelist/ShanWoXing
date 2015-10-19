package com.yxtar.app.base.model.map;

import java.util.Date;
import java.util.List;

public class PlatformLocationMap extends BaseMap {

	private String locationId;
	private String province;
	private String city;
	private String district;
	private String street;

	private String locationName;
	private String detailAddr;

	private List<String> tag;
	private List<Integer> dcampLst;
	private Date createTime;
	private Integer reachRate;
	private Integer status;

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getReachRate() {
		return reachRate;
	}

	public void setReachRate(Integer reachRate) {
		this.reachRate = reachRate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public List<Integer> getDcampLst() {
		return dcampLst;
	}

	public void setDcampLst(List<Integer> dcampLst) {
		this.dcampLst = dcampLst;
	}

}
