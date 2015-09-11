package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


public class CharityCampReport extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}

	private Integer id;
	private CharityCamp charityCampId;
	private Integer sponsorId;
	private Integer campReachRate;
	private Integer actionFinishRate;
	private String actionAnswerDistribution;

	private Integer periodNum;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CharityCamp getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(CharityCamp charityCampId) {
		this.charityCampId = charityCampId;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Integer getCampReachRate() {
		return campReachRate;
	}

	public void setCampReachRate(Integer campReachRate) {
		this.campReachRate = campReachRate;
	}

	public Integer getActionFinishRate() {
		return actionFinishRate;
	}

	public void setActionFinishRate(Integer actionFinishRate) {
		this.actionFinishRate = actionFinishRate;
	}

	public String getActionAnswerDistribution() {
		return actionAnswerDistribution;
	}

	public void setActionAnswerDistribution(String actionAnswerDistribution) {
		this.actionAnswerDistribution = actionAnswerDistribution;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

}
