package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityOrgDao;
import com.yxtar.server.dto.CharityOrg;

@Service("charityOrgDao")
public class CharityOrgDaoImpl extends BaseDaoImpl<CharityOrg, Integer> implements CharityOrgDao {
}
