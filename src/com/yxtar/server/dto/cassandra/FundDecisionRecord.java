package com.yxtar.server.dto.cassandra;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("fund_decision_record")
public class FundDecisionRecord extends BaseDto {
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
	private UUID fundDecisionId;
	private UUID memberId;
	private String mnickName;
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private Integer charityFundId;
	private String charityFundTitle;
	private Integer amount;
	private Date createTime;
	private Integer status;
	@CassandraType(type=Name.TIMEUUID)
	private UUID paymentRecordId;

	public UUID getFundDecisionId() {
		return fundDecisionId;
	}

	public void setFundDecisionId(UUID fundDecisionId) {
		this.fundDecisionId = fundDecisionId;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getMnickName() {
		return mnickName;
	}

	public void setMnickName(String mnickName) {
		this.mnickName = mnickName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

}
