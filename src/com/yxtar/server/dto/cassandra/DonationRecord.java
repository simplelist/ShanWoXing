package com.yxtar.server.dto.cassandra;

import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;
import com.yxtar.server.util.CustomDateSerializer;

@Table("donation_record")
public class DonationRecord extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}
	
	@CassandraType(type=Name.TIMEUUID)
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private UUID donationId;
	private UUID memberId;
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private Integer charityFundId;
	private String nickName;
	private String charityFundTitle;

	private Integer amount;
	private Integer paymentType;
	private Date createTime;
	private Date paidTime;
	private Integer status;
	@CassandraType(type=Name.TIMEUUID)
	private UUID paymentRecordId;

	public UUID getDonationId() {
		return donationId;
	}

	public void setDonationId(UUID donationId) {
		this.donationId = donationId;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public Integer getCharityFundId() {
		return charityFundId;
	}

	public void setCharityFundId(Integer charityFundId) {
		this.charityFundId = charityFundId;
	}

	public String getCharityFundTitle() {
		return charityFundTitle;
	}

	public void setCharityFundTitle(String charityFundTitle) {
		this.charityFundTitle = charityFundTitle;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getPaidTime() {
		return paidTime;
	}

	public void setPaidTime(Date paidTime) {
		this.paidTime = paidTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UUID getPaymentRecordId() {
		return paymentRecordId;
	}

	public void setPaymentRecordId(UUID paymentRecordId) {
		this.paymentRecordId = paymentRecordId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
