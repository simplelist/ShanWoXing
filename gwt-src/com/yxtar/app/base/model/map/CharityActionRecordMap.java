package com.yxtar.app.base.model.map;

import java.util.Date;

public class CharityActionRecordMap extends BaseMap {

	private Integer charityCampId;
	private String memberId;
	private Integer actionType;
	private String actionContent;
	private Date createTime;
	private Integer charityFundid;
	private Integer periodNum;

	public Integer getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(Integer charityCampId) {
		this.charityCampId = charityCampId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public String getActionContent() {
		return actionContent;
	}

	public void setActionContent(String actionContent) {
		this.actionContent = actionContent;
	}

	public Integer getCharityFundid() {
		return charityFundid;
	}

	public void setCharityFundid(Integer charityFundid) {
		this.charityFundid = charityFundid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

}
