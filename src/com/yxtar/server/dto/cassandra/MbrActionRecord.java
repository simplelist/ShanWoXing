package com.yxtar.server.dto.cassandra;

import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;
import com.yxtar.server.util.CustomDateSerializer;

@Table("mbr_action_record")
public class MbrActionRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_MbrActionRecord pk;
	private String campTitle;
	@CassandraType(type = Name.TIMEUUID)
	private UUID campMainphoto;

	private String campIntrodShort;
	private Boolean periodCamp;
	private Date createTime;

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public UUID getCampMainphoto() {
		return campMainphoto;
	}

	public void setCampMainphoto(UUID campMainphoto) {
		this.campMainphoto = campMainphoto;
	}

	public String getCampIntrodShort() {
		return campIntrodShort;
	}

	public void setCampIntrodShort(String campIntrodShort) {
		this.campIntrodShort = campIntrodShort;
	}

	public Boolean getPeriodCamp() {
		return periodCamp;
	}

	public void setPeriodCamp(Boolean periodCamp) {
		this.periodCamp = periodCamp;
	}

	public PK_MbrActionRecord getPk() {
		return pk;
	}

	public void setPk(PK_MbrActionRecord pk) {
		this.pk = pk;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
