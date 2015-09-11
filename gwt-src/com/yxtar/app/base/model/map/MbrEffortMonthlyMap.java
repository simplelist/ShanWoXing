package com.yxtar.app.base.model.map;


public class MbrEffortMonthlyMap extends BaseMap{

	

	private String memberId;
	private String nickName;
	private String memberPhotoId;
	private Integer year;
	private Integer month;
	private Double effort;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMemberPhotoId() {
		return memberPhotoId;
	}

	public void setMemberPhotoId(String memberPhotoId) {
		this.memberPhotoId = memberPhotoId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getEffort() {
		return effort;
	}

	public void setEffort(Double effort) {
		this.effort = effort;
	}

}
