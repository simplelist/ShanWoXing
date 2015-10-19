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

@Table("mbr_donation")
public class MbrDonation extends BaseDto {
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
	@CassandraType(type=Name.TIMEUUID)
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private UUID donationId;
	private Integer charityFundId;
	private String charityFundTitle;
	@CassandraType(type=Name.TIMEUUID)
	private UUID charityFundphoto;

	private Integer amount;
	private Integer paymentType;
	private Date createTime;
	private Date paidTime;
	private Integer status;
	@CassandraType(type=Name.TIMEUUID)
	private UUID payRecordId;
	private Integer payRecordAmount;
	private Integer payRecordPayType;

	private Date payRecordCreateTime;
	private Date payRecordPaidTime;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public UUID getDonationId() {
		return donationId;
	}

	public void setDonationId(UUID donationId) {
		this.donationId = donationId;
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

	public UUID getCharityFundphoto() {
		return charityFundphoto;
	}

	public void setCharityFundphoto(UUID charityFundphoto) {
		this.charityFundphoto = charityFundphoto;
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

	public UUID getPayRecordId() {
		return payRecordId;
	}

	public void setPayRecordId(UUID payRecordId) {
		this.payRecordId = payRecordId;
	}

	public Integer getPayRecordAmount() {
		return payRecordAmount;
	}

	public void setPayRecordAmount(Integer payRecordAmount) {
		this.payRecordAmount = payRecordAmount;
	}

	public Integer getPayRecordPayType() {
		return payRecordPayType;
	}

	public void setPayRecordPayType(Integer payRecordPayType) {
		this.payRecordPayType = payRecordPayType;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getPayRecordCreateTime() {
		return payRecordCreateTime;
	}

	public void setPayRecordCreateTime(Date payRecordCreateTime) {
		this.payRecordCreateTime = payRecordCreateTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getPayRecordPaidTime() {
		return payRecordPaidTime;
	}

	public void setPayRecordPaidTime(Date payRecordPaidTime) {
		this.payRecordPaidTime = payRecordPaidTime;
	}

}
