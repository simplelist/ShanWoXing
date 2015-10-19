package com.yxtar.server.dto.cassandra;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("daily_camp_stat")
public class DailyCampStat extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	@PrimaryKey
	private Integer dcampId;
	private Integer supportRate;
	private Integer donationAmount;
	private Double remainAmount;
	private Double remainPreparedAmount;

	public Integer getSupportRate() {
		return supportRate;
	}

	public void setSupportRate(Integer supportRate) {
		this.supportRate = supportRate;
	}

	public Integer getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Integer donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Double getRemainPreparedAmount() {
		return remainPreparedAmount;
	}

	public void setRemainPreparedAmount(Double remainPreparedAmount) {
		this.remainPreparedAmount = remainPreparedAmount;
	}

	public Integer getDcampId() {
		return dcampId;
	}

	public void setDcampId(Integer dcampId) {
		this.dcampId = dcampId;
	}

	public Double getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(Double remainAmount) {
		this.remainAmount = remainAmount;
	}

}
