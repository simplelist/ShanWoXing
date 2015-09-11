package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;

import java.util.UUID;

public class MbrEffortMonthly extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID memberId;
	private String nickName;
	private UUID memberPhotoId;
	private Integer year;
	private Integer month;
	private Double effort;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public UUID getMemberPhotoId() {
		return memberPhotoId;
	}

	public void setMemberPhotoId(UUID memberPhotoId) {
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
