package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.UUID;

public class MbrDailyCampRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID locationId;
	private UUID dcampId;
	private UUID memberId;
	private Date createDate;

	public UUID getLocationId() {
		return locationId;
	}

	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}


	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UUID getDcampId() {
		return dcampId;
	}

	public void setDcampId(UUID dcampId) {
		this.dcampId = dcampId;
	}

}
