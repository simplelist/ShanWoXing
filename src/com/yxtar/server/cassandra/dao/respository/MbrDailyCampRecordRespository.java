package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.MbrDailyCampRecord;
import com.yxtar.server.dto.cassandra.PK_MbrDailyCampRecord;

@Repository
public interface MbrDailyCampRecordRespository extends CrudRepository<MbrDailyCampRecord, PK_MbrDailyCampRecord>{
}
