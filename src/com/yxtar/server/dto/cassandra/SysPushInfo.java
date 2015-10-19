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

@Table("sys_push_info")
public class SysPushInfo extends BaseDto {

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_SysPushInfo pk;
	private Integer status;
	@CassandraType(type = Name.TIMESTAMP)
	private Date createTime;

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

	public PK_SysPushInfo getPk() {
		return pk;
	}

	public void setPk(PK_SysPushInfo pk) {
		this.pk = pk;
	}

}
