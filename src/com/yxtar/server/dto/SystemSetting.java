package com.yxtar.server.dto;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.util.CustomDateSerializer;

public class SystemSetting extends BaseDto {
	
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}
	private Integer id;
	private Integer platform;
	private Integer supportVer;
	private String updateLink;
	private Integer appLatestDataVersion;

	private Boolean maintFlag;
	private Boolean presetMaintFlag;
	private Date presetMaintStartTime;
	private Date presetMainEndTime;

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

	public Integer getSupportVer() {
		return supportVer;
	}

	public void setSupportVer(Integer supportVer) {
		this.supportVer = supportVer;
	}

	public String getUpdateLink() {
		return updateLink;
	}

	public void setUpdateLink(String updateLink) {
		this.updateLink = updateLink;
	}

	public Integer getAppLatestDataVersion() {
		return appLatestDataVersion;
	}

	public void setAppLatestDataVersion(Integer appLatestDataVersion) {
		this.appLatestDataVersion = appLatestDataVersion;
	}

	public Boolean getMaintFlag() {
		return maintFlag;
	}

	public void setMaintFlag(Boolean maintFlag) {
		this.maintFlag = maintFlag;
	}

	public Boolean getPresetMaintFlag() {
		return presetMaintFlag;
	}

	public void setPresetMaintFlag(Boolean presetMaintFlag) {
		this.presetMaintFlag = presetMaintFlag;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getPresetMaintStartTime() {
		return presetMaintStartTime;
	}

	public void setPresetMaintStartTime(Date presetMaintStartTime) {
		this.presetMaintStartTime = presetMaintStartTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getPresetMainEndTime() {
		return presetMainEndTime;
	}

	public void setPresetMainEndTime(Date presetMainEndTime) {
		this.presetMainEndTime = presetMainEndTime;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}


}
