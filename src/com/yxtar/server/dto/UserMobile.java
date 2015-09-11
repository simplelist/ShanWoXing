package com.yxtar.server.dto;

import java.util.UUID;

import com.yxtar.app.base.model.map.BaseMap;

public class UserMobile extends BaseDto {

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private String phoneNum;
	private UUID memberId;
	private String nickName;
	private String gender;
	private UUID photoId;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
		this.photoId = photoId;
	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
