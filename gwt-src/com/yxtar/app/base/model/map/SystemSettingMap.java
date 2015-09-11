package com.yxtar.app.base.model.map;

import java.util.Date;



public class SystemSettingMap extends BaseMap {
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

	public Date getPresetMaintStartTime() {
		return presetMaintStartTime;
	}

	public void setPresetMaintStartTime(Date presetMaintStartTime) {
		this.presetMaintStartTime = presetMaintStartTime;
	}

	public Date getPresetMainEndTime() {
		return presetMainEndTime;
	}

	public void setPresetMainEndTime(Date presetMainEndTime) {
		this.presetMainEndTime = presetMainEndTime;
	}

}
