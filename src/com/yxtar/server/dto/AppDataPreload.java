package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;
public class AppDataPreload extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}

	private Integer id;
	private Integer platform;
	private Integer version;
	private Integer type;
	private String actionList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getActionList() {
		return actionList;
	}

	public void setActionList(String actionList) {
		this.actionList = actionList;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

}
