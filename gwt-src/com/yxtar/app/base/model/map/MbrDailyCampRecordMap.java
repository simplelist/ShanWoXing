package com.yxtar.app.base.model.map;

import java.util.Date;

public class MbrDailyCampRecordMap extends BaseMap{

	

	private String locationId;
	private String dcampId;
	private String memberId;
	private Date createDate;

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDcampId() {
		return dcampId;
	}

	public void setDcampId(String dcampId) {
		this.dcampId = dcampId;
	}

}
