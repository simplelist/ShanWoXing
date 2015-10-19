package com.yxtar.server.dto.cassandra;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("daily_camp_record")
public class DailyCampRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_DailyCampRecord pk;
	private Integer sponsorId;
	private String sponsorName;
	private String campTitle;
	@CassandraType(type = Name.TIMEUUID)
	private UUID campAdvPhoto;

	private String mbrAccName;

	private Integer actionType;
	private Double mbrFundReceived;

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public UUID getCampAdvPhoto() {
		return campAdvPhoto;
	}

	public void setCampAdvPhoto(UUID campAdvPhoto) {
		this.campAdvPhoto = campAdvPhoto;
	}

	public String getMbrAccName() {
		return mbrAccName;
	}

	public void setMbrAccName(String mbrAccName) {
		this.mbrAccName = mbrAccName;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public Double getMbrFundReceived() {
		return mbrFundReceived;
	}

	public void setMbrFundReceived(Double mbrFundReceived) {
		this.mbrFundReceived = mbrFundReceived;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

}
