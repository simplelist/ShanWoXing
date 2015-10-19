package com.yxtar.server.dto.cassandra;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("mbr_daily_camp_record")
public class MbrDailyCampRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_MbrDailyCampRecord pk;
	private UUID dcampId;
	public UUID getDcampId() {
		return dcampId;
	}

	public void setDcampId(UUID dcampId) {
		this.dcampId = dcampId;
	}

	public PK_MbrDailyCampRecord getPk() {
		return pk;
	}

	public void setPk(PK_MbrDailyCampRecord pk) {
		this.pk = pk;
	}

}
