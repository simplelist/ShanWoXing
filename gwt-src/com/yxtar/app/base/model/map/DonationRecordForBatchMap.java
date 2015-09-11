package com.yxtar.app.base.model.map;

import java.util.Date;

public class DonationRecordForBatchMap extends BaseMap {
	private String donationId;
	private Date createTime;

	public String getDonationId() {
		return donationId;
	}

	public void setDonationId(String donationId) {
		this.donationId = donationId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
