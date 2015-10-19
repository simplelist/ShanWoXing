package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.yxtar.server.dto.cassandra.PK_SysPushInfo;
import com.yxtar.server.dto.cassandra.SysPushInfo;

@Component
public interface SysPushInfoRespository extends CrudRepository<SysPushInfo, PK_SysPushInfo>{
}
