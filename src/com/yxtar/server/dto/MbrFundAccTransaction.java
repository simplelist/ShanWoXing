package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;

import java.util.Date;
import java.util.UUID;

public class MbrFundAccTransaction extends BaseDto {
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
	private UUID photoId;
	private String type;
	private Integer campid;
	private String campTitle;
	private UUID campPhoto;
	private Integer fundid;
	private String fundTitle;
	private Double accBalanceSnapShot;
	private UUID fundPhoto;
	private Date createTime;
	private UUID fundDecisionId;

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

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
		this.photoId = photoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCampid() {
		return campid;
	}

	public void setCampid(Integer campid) {
		this.campid = campid;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public UUID getCampPhoto() {
		return campPhoto;
	}

	public void setCampPhoto(UUID campPhoto) {
		this.campPhoto = campPhoto;
	}

	public Integer getFundid() {
		return fundid;
	}

	public void setFundid(Integer fundid) {
		this.fundid = fundid;
	}

	public String getFundTitle() {
		return fundTitle;
	}

	public void setFundTitle(String fundTitle) {
		this.fundTitle = fundTitle;
	}

	public Double getAccBalanceSnapShot() {
		return accBalanceSnapShot;
	}

	public void setAccBalanceSnapShot(Double accBalanceSnapShot) {
		this.accBalanceSnapShot = accBalanceSnapShot;
	}

	public UUID getFundPhoto() {
		return fundPhoto;
	}

	public void setFundPhoto(UUID fundPhoto) {
		this.fundPhoto = fundPhoto;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public UUID getFundDecisionId() {
		return fundDecisionId;
	}

	public void setFundDecisionId(UUID fundDecisionId) {
		this.fundDecisionId = fundDecisionId;
	}

}
