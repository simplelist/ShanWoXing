package com.yxtar.server.dto.cassandra;

import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("pay_decision_relation")
public class PayDecisionRelation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@CassandraType(type = Name.TIMEUUID)
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID paymentid;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	@CassandraType(type = Name.TIMEUUID)
	private UUID fundDecisionId;
	private UUID memberId;
	private String mnickName;
	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private Integer amount;
	private Integer paymentType;

	public UUID getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(UUID paymentid) {
		this.paymentid = paymentid;
	}

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

}
