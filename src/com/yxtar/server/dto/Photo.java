package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;


import java.util.UUID;

public class Photo extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	private UUID photoId;
	private String storePath;
	private String size;
	private Integer status;
	private String type;
	private String createdChannel;
	private UUID createAcc;

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
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

	public UUID getCreateAcc() {
		return createAcc;
	}

	public void setCreateAcc(UUID createAcc) {
		this.createAcc = createAcc;
	}
}
