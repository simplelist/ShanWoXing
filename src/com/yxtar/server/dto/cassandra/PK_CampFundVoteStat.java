package com.yxtar.server.dto.cassandra;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PK_CampFundVoteStat implements Serializable {

	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private Integer fundId;
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private Integer campId;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private Integer periodNum;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campId == null) ? 0 : campId.hashCode());
		result = prime * result + ((fundId == null) ? 0 : fundId.hashCode());
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
		PK_CampFundVoteStat other = (PK_CampFundVoteStat) obj;
		if (campId == null) {
			if (other.campId != null)
				return false;
		} else if (!campId.equals(other.campId))
			return false;
		if (fundId == null) {
			if (other.fundId != null)
				return false;
		} else if (!fundId.equals(other.fundId))
			return false;
		if (periodNum == null) {
			if (other.periodNum != null)
				return false;
		} else if (!periodNum.equals(other.periodNum))
			return false;
		return true;
	}

	public Integer getFundId() {
		return fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}

	public Integer getCampId() {
		return campId;
	}

	public void setCampId(Integer campId) {
		this.campId = campId;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

}
