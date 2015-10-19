package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.SponsorDao;
import com.yxtar.server.dto.Sponsor;

@Service("sponsorDao")
public class SponsorDaoImpl extends BaseDaoImpl<Sponsor, Integer> implements SponsorDao {
}
