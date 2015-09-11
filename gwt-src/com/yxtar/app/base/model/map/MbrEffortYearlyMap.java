package com.yxtar.app.base.model.map;

public class MbrEffortYearlyMap extends BaseMap {

	private String memberId;
	private String nickName;
	private String memberPhotoId;
	private Integer year;
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

	public Double getEffort() {
		return effort;
	}

	public void setEffort(Double effort) {
		this.effort = effort;
	}

}
