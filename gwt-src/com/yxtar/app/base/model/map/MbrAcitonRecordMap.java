package com.yxtar.app.base.model.map;

import java.util.Date;

public class MbrAcitonRecordMap extends BaseMap{

	

	private String memberId;
	private Integer charityCampId;

	private String campTitle;
	private String campMainphoto;

	private String campIntrodShort;
	private Boolean periodCamp;
	private Integer periodNum;
	private Date createTime;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(Integer charityCampId) {
		this.charityCampId = charityCampId;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public String getCampMainphoto() {
		return campMainphoto;
	}

	public void setCampMainphoto(String campMainphoto) {
		this.campMainphoto = campMainphoto;
	}

	public String getCampIntrodShort() {
		return campIntrodShort;
	}

	public void setCampIntrodShort(String campIntrodShort) {
		this.campIntrodShort = campIntrodShort;
	}

	public Boolean getPeriodCamp() {
		return periodCamp;
	}

	public void setPeriodCamp(Boolean periodCamp) {
		this.periodCamp = periodCamp;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
