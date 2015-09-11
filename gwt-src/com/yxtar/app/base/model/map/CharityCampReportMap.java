package com.yxtar.app.base.model.map;

public class CharityCampReportMap extends BaseMap {
	private Integer id;
	private CharityCampMap charityCampId;
	private Integer sponsorId;
	private Integer campReachRate;
	private Integer actionFinishRate;
	private String actionAnswerDistribution;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public CharityCampMap getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(CharityCampMap charityCampId) {
		this.charityCampId = charityCampId;
	}

}
