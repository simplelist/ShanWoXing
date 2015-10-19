package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;

public class CampFundRelation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	private Integer id;
	private CharityCamp campId;
	private CharityFund fundId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	public CharityCamp getCampId() {
		return campId;
	}

	public void setCampId(CharityCamp campId) {
		this.campId = campId;
	}

	public CharityFund getFundId() {
		return fundId;
	}

	public void setFundId(CharityFund fundId) {
		this.fundId = fundId;
	}

}
