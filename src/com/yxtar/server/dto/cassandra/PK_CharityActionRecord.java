package com.yxtar.server.dto.cassandra;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PK_CharityActionRecord implements Serializable {

	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private Integer charityCampId;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private Integer periodNum;
	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private UUID memberId;
	@PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
	private Date createTime;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charityCampId == null) ? 0 : charityCampId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((periodNum == null) ? 0 : periodNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK_CharityActionRecord other = (PK_CharityActionRecord) obj;
		if (charityCampId == null) {
			if (other.charityCampId != null)
				return false;
		} else if (!charityCampId.equals(other.charityCampId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (periodNum == null) {
			if (other.periodNum != null)
				return false;
		} else if (!periodNum.equals(other.periodNum))
			return false;
		return true;
	}

	public Integer getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(Integer charityCampId) {
		this.charityCampId = charityCampId;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

}
