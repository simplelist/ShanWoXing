package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.CampSponsorRelation;
import com.yxtar.server.util.ListResult;

@Repository()
public interface CampSponsorRelationDao extends BaseDao<CampSponsorRelation, Integer> {

	ListResult<CampSponsorRelation> getSponsorListByCharityID(Integer charityCampId);
}
