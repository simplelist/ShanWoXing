package com.yxtar.server.dto;

import java.util.Date;

import org.junit.Test;

import com.yxtar.app.base.model.map.MbrFundAccTransactionMap;
import com.yxtar.server.util.UUIDUtil;

public class ReffTest {
	@Test
	public void test1() {
//		Advertiser base = new Advertiser();
//		base.setAccBalance(234D);
//		base.setCompanyHtmlIntrod("this is ");
//		base.setStatus(2);
//		AdvertiserMap map=(AdvertiserMap) base.generateMap();
//		System.err.println(map.getAccBalance());
//		System.err.println(map.getCompanyHtmlIntrod());
//		System.err.println(map.getStatus());
//		
//		CharityCamp camp=new CharityCamp();
//		camp.setActionAdvPhoto("fvwuebgry-ergnei");
//		CharityCampMap campMap=(CharityCampMap) camp.generateMap();
//		System.err.println(campMap.getActionAdvPhoto());
//		
		
		
		MbrFundAccTransaction mbrAccTransaction=new MbrFundAccTransaction();
		mbrAccTransaction.setCreateTime(new Date());
		mbrAccTransaction.setPhotoId(UUIDUtil.create());
		MbrFundAccTransactionMap mbrMap=(MbrFundAccTransactionMap) mbrAccTransaction.generateMap();
		System.err.println(mbrMap.getCreateTime());
		System.err.println(mbrMap.getPhotoId());
	}
}
