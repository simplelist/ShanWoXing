package com.yxtar.app.base.model.map;

import java.util.Date;

public class MbrFundAccTransactionMap extends BaseMap{

	

	private String memberId;
	private String nickName;
	private String photoId;
	private String type;
	private Integer campid;
	private String campTitle;
	private String campPhoto;
	private Integer fundid;
	private String fundTitle;
	private Double accBalanceSnapShot;
	private String fundPhoto;
	private String fundDecisionId;
	private Date createTime;

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

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
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

	public String getCampPhoto() {
		return campPhoto;
	}

	public void setCampPhoto(String campPhoto) {
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

	public String getFundPhoto() {
		return fundPhoto;
	}

	public void setFundPhoto(String fundPhoto) {
		this.fundPhoto = fundPhoto;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFundDecisionId() {
		return fundDecisionId;
	}

	public void setFundDecisionId(String fundDecisionId) {
		this.fundDecisionId = fundDecisionId;
	}

}
