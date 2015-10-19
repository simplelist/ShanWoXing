package com.yxtar.server.dto.cassandra;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import com.yxtar.server.util.CustomDateSerializer;

@PrimaryKeyClass
public class PK_DailyCampRecord implements Serializable {
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID dCampid;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private Date createDate;
	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private UUID memberId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dCampid == null) ? 0 : dCampid.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		PK_DailyCampRecord other = (PK_DailyCampRecord) obj;
		if (dCampid == null) {
			if (other.dCampid != null)
				return false;
		} else if (!dCampid.equals(other.dCampid))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

	public UUID getdCampid() {
		return dCampid;
	}

	public void setdCampid(UUID dCampid) {
		this.dCampid = dCampid;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

}
