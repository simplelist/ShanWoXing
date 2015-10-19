package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.Sponsor;

@Repository()
public interface SponsorDao extends BaseDao<Sponsor, Integer> {
}
