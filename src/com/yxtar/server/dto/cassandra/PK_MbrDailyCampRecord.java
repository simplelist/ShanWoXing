package com.yxtar.server.dto.cassandra;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PK_MbrDailyCampRecord implements Serializable {
	@PrimaryKeyColumn(name="memberid",ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID memberId;
	@PrimaryKeyColumn(name="createdate",ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private Date createDate;
	@PrimaryKeyColumn(name="locationid",ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private UUID locationId;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
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
		PK_MbrDailyCampRecord other = (PK_MbrDailyCampRecord) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UUID getLocationId() {
		return locationId;
	}

	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}
}
