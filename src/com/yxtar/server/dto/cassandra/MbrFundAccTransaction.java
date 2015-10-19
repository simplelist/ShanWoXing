package com.yxtar.server.dto.cassandra;

import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;
import com.yxtar.server.util.CustomDateSerializer;

@Table("mbr_fund_acc_transaction")
public class MbrFundAccTransaction extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID memberId;
	@Column(value = "nickname")
	private String nickName;
	private UUID photoId;
	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String type;
	private Integer dcampid;
	private String campTitle;
	private UUID campPhoto;
	private Integer fundid;
	private String fundTitle;
	private Double accBalanceSnapShot;
	@CassandraType(type = Name.TIMEUUID)
	private UUID fundPhoto;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private Date createTime;
	private UUID fundDecisionId;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
		this.photoId = photoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCampTitle() {
		return campTitle;
	}

	public void setCampTitle(String campTitle) {
		this.campTitle = campTitle;
	}

	public UUID getCampPhoto() {
		return campPhoto;
	}

	public void setCampPhoto(UUID campPhoto) {
		this.campPhoto = campPhoto;
	}

	public Integer getFundid() {
		return fundid;
	}

	public void setFundid(Integer fundid) {
		this.fundid = fundid;
	}

	public String getFundTitle() {
		return fundTitle;
	}

	public void setFundTitle(String fundTitle) {
		this.fundTitle = fundTitle;
	}

	public Double getAccBalanceSnapShot() {
		return accBalanceSnapShot;
	}

	public void setAccBalanceSnapShot(Double accBalanceSnapShot) {
		this.accBalanceSnapShot = accBalanceSnapShot;
	}

	public UUID getFundPhoto() {
		return fundPhoto;
	}

	public void setFundPhoto(UUID fundPhoto) {
		this.fundPhoto = fundPhoto;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public UUID getFundDecisionId() {
		return fundDecisionId;
	}

	public void setFundDecisionId(UUID fundDecisionId) {
		this.fundDecisionId = fundDecisionId;
	}

	public Integer getDcampid() {
		return dcampid;
	}

	public void setDcampid(Integer dcampid) {
		this.dcampid = dcampid;
	}

}
