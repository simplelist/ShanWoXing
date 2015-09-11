package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


public class LocationTag extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}

	private Integer id;
	private String locationTag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocationTag() {
		return locationTag;
	}

	public void setLocationTag(String locationTag) {
		this.locationTag = locationTag;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

}
