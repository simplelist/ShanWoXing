package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.yxtar.server.dto.cassandra.MbrPushInfo;
import com.yxtar.server.dto.cassandra.PK_MbrPushInfo;

@Component
public interface MbrPushInfoRespository extends CrudRepository<MbrPushInfo, PK_MbrPushInfo>{
}
