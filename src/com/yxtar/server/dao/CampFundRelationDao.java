package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.CampFundRelation;
import com.yxtar.server.util.ListResult;

@Repository()
public interface CampFundRelationDao extends BaseDao<CampFundRelation, Integer> {

	ListResult<CampFundRelation> getCharityFundByCampID(Integer charityCampId);

}
