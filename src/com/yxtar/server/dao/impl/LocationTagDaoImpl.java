package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.LocationTagDao;
import com.yxtar.server.dto.LocationTag;

@Service("locationTagDao")
public class LocationTagDaoImpl extends BaseDaoImpl<LocationTag, Integer> implements LocationTagDao {
	
}
