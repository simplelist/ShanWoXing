package com.yxtar.app.base.model.map;


public class PhotoMap extends BaseMap{

	

	private String photoId;
	private String storePath;
	private String size;
	private Integer status;
	private String type;
	private String createdChannel;
	private String createAcc;

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getStorePath() {
		return storePath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedChannel() {
		return createdChannel;
	}

	public void setCreatedChannel(String createdChannel) {
		this.createdChannel = createdChannel;
	}

	public String getCreateAcc() {
		return createAcc;
	}

	public void setCreateAcc(String createAcc) {
		this.createAcc = createAcc;
	}
}
