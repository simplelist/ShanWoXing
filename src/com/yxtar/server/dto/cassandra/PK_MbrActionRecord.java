package com.yxtar.server.dto.cassandra;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PK_MbrActionRecord implements Serializable {
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID memberId;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private Integer charityCampId;
	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.PARTITIONED)
	private Integer periodNum;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charityCampId == null) ? 0 : charityCampId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		PK_MbrActionRecord other = (PK_MbrActionRecord) obj;
		if (charityCampId == null) {
			if (other.charityCampId != null)
				return false;
		} else if (!charityCampId.equals(other.charityCampId))
			return false;
		if (periodNum == null) {
			if (other.periodNum != null)
				return false;
		} else if (!periodNum.equals(other.periodNum))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public Integer getCharityCampId() {
		return charityCampId;
	}

	public void setCharityCampId(Integer charityCampId) {
		this.charityCampId = charityCampId;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}
}
