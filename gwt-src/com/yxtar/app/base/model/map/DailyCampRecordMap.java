package com.yxtar.app.base.model.map;

import java.util.Date;

public class DailyCampRecordMap extends BaseMap{

	private String dCampid;
	private Integer sponsorId;
	private String sponsorName;
	private String campTitle;
	private String campAdvPhoto;
	private String memberId;
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

	public String getCampAdvPhoto() {
		return campAdvPhoto;
	}

	public void setCampAdvPhoto(String campAdvPhoto) {
		this.campAdvPhoto = campAdvPhoto;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
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

	public String getdCampid() {
		return dCampid;
	}

	public void setdCampid(String dCampid) {
		this.dCampid = dCampid;
	}

}
