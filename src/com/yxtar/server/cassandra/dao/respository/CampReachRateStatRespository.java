package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.CampReachRateStat;
import com.yxtar.server.dto.cassandra.PK_CampReachRateStat;

@Repository
public interface CampReachRateStatRespository extends CrudRepository<CampReachRateStat, PK_CampReachRateStat>{
}
