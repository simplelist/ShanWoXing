package com.yxtar.server.dto.cassandra;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("user_mobile")
public class UserMobile extends BaseDto {

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private PK_UserMobile pk;
	@Column(value = "nickname")
	private String nickName;
	private UUID memberId;
	private String gender;
	@Column(value = "photo")
	@CassandraType(type = Name.TIMEUUID)
	private UUID photoId;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
		this.photoId = photoId;
	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public PK_UserMobile getPk() {
		return pk;
	}

	public void setPk(PK_UserMobile pk) {
		this.pk = pk;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

}
