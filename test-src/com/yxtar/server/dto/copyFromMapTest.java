package com.yxtar.server.dto;

import java.util.Date;

import org.junit.Test;

import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.app.base.model.map.CharityFundMap;
import com.yxtar.app.base.model.map.CharityOrgMap;
import com.yxtar.server.util.UUIDUtil;

public class copyFromMapTest {

	@Test
	public void copy() {
		AdvertiserMap map = new AdvertiserMap();
		Advertiser base = new Advertiser();

		map.setAccBalance(678.32D);
		base.copyFromMap(map);
		System.err.println(base.getAccBalance());
//
		CharityOrg baseOrg = new CharityOrg();
		CharityOrgMap mapOrg = new CharityOrgMap();

		mapOrg.setId(234);
		baseOrg.copyFromMap(mapOrg);
		System.err.println(baseOrg.getId());
//		
		
		CharityFund fund=new CharityFund();
		CharityFundMap fundMap=new CharityFundMap();
		fundMap.setCharityOrgId(mapOrg);
		mapOrg.setId(1111);
		fundMap.setCreateDate(new Date());
		fundMap.setEventSmallPhoto(UUIDUtil.create()+"");
		fund.copyFromMap(fundMap);
		System.err.println(fundMap.getCreateDate());
		System.err.println(fundMap.getCharityOrgId().getId());
		System.err.println(fundMap.getEventSmallPhoto());
	}
}
