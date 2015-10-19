package com.yxtar.server.dao;

import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.CharityCamp;
import com.yxtar.server.util.ListResult;

@Repository()
public interface CharityCampDao extends BaseDao<CharityCamp, Integer> {

	ListResult<CharityCamp> getUncompletedCharity(IPager pager);
}
