package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.DailyCampStat;

@Repository
public interface DailyCampStatRespository extends CrudRepository<DailyCampStat, Integer>{
}
