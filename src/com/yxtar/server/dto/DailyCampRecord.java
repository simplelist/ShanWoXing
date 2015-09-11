package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.Date;
import java.util.UUID;

public class DailyCampRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID dCampid;
	private Integer sponsorId;
	private String sponsorName;
	private String campTitle;
	private UUID campAdvPhoto;
	private UUID memberId;
	private String mbrAccName;

	private Integer actionType;
	private Double mbrFundReceived;
	private Date createDate;

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public UUID getCampAdvPhoto() {
		return campAdvPhoto;
	}

	public void setCampAdvPhoto(UUID campAdvPhoto) {
		this.campAdvPhoto = campAdvPhoto;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getMbrAccName() {
		return mbrAccName;
	}

	public void setMbrAccName(String mbrAccName) {
		this.mbrAccName = mbrAccName;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public Double getMbrFundReceived() {
		return mbrFundReceived;
	}

	public void setMbrFundReceived(Double mbrFundReceived) {
		this.mbrFundReceived = mbrFundReceived;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public UUID getdCampid() {
		return dCampid;
	}

	public void setdCampid(UUID dCampid) {
		this.dCampid = dCampid;
	}

}
