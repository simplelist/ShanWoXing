package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.yxtar.server.dto.cassandra.CharityActionRecord;
import com.yxtar.server.dto.cassandra.PK_CharityActionRecord;

@Component
public interface CharityActionRecordRespository extends CrudRepository<CharityActionRecord, PK_CharityActionRecord>{
}
