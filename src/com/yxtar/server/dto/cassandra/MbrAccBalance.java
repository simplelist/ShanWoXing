package com.yxtar.server.dto.cassandra;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("mbr_acc_balance")
public class MbrAccBalance extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}
	@PrimaryKey
	private UUID memberId;
	private Double mbrFundAccBalance;
	private Double donationAmount;
	private Double amountFromCampSupported;
	private Integer numOfCampSupported;

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Double getAmountFromCampSupported() {
		return amountFromCampSupported;
	}

	public void setAmountFromCampSupported(Double amountFromCampSupported) {
		this.amountFromCampSupported = amountFromCampSupported;
	}

	public Integer getNumOfCampSupported() {
		return numOfCampSupported;
	}

	public void setNumOfCampSupported(Integer numOfCampSupported) {
		this.numOfCampSupported = numOfCampSupported;
	}

	public Double getMbrFundAccBalance() {
		return mbrFundAccBalance;
	}

	public void setMbrFundAccBalance(Double mbrFundAccBalance) {
		this.mbrFundAccBalance = mbrFundAccBalance;
	}

}
