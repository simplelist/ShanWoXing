package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.UUID;

public class MbrAcitonRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID memberId;
	private Integer charityCampId;

	private String campTitle;
	private UUID campMainphoto;

	private String campIntrodShort;
	private Boolean periodCamp;
	private Integer periodNum;
	private Date createTime;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
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

	public UUID getCampMainphoto() {
		return campMainphoto;
	}

	public void setCampMainphoto(UUID campMainphoto) {
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
