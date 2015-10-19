package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.PK_MbrActionRecord;

@Repository
public interface MbrActionRecordRespository extends CrudRepository<MbrActionRecord, PK_MbrActionRecord>{
}
