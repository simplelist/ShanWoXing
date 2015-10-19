package com.yxtar.app.shared;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Table(value = "testcassandra")
public class TestCassandra implements IsSerializable {
//	@PrimaryKey
	@PrimaryKeyColumn(type=PrimaryKeyType.PARTITIONED, ordinal = 0)
	private String id;
	@Column(value = "displayname")
	private String displayName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
