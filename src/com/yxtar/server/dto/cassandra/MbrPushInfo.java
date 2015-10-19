package com.yxtar.server.dto.cassandra;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;
import com.yxtar.server.util.CustomDateSerializer;

@Table("mbr_push_info")
public class MbrPushInfo extends BaseDto {

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_MbrPushInfo pk;
	private Integer status;
	@CassandraType(type = Name.TIMESTAMP)
	private Date createTime;

	public PK_MbrPushInfo getPk() {
		return pk;
	}

	public void setPk(PK_MbrPushInfo pk) {
		this.pk = pk;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
