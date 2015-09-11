package com.yxtar.app.base.model.map;


public class CampFundVoteStatMap extends BaseMap{

	private Integer fundId;
	private Integer carmpId;
	private Integer numOfVote;
	private Integer periodNum;
	
	public Integer getNumOfVote() {
		return numOfVote;
	}
	public void setNumOfVote(Integer numOfVote) {
		this.numOfVote = numOfVote;
	}
	public Integer getPeriodNum() {
		return periodNum;
	}
	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}
	public Integer getFundId() {
		return fundId;
	}
	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}
	public Integer getCarmpId() {
		return carmpId;
	}
	public void setCarmpId(Integer carmpId) {
		this.carmpId = carmpId;
	}

}
