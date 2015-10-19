package com.yxtar.server.dto.cassandra;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("charity_action_record")
public class CharityActionRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_CharityActionRecord pk;
	private Integer actionType;
	private String actionContent;

	private Integer charityFundid;

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public String getActionContent() {
		return actionContent;
	}

	public void setActionContent(String actionContent) {
		this.actionContent = actionContent;
	}

	public Integer getCharityFundid() {
		return charityFundid;
	}

	public void setCharityFundid(Integer charityFundid) {
		this.charityFundid = charityFundid;
	}

	public PK_CharityActionRecord getPk() {
		return pk;
	}

	public void setPk(PK_CharityActionRecord pk) {
		this.pk = pk;
	}

}
