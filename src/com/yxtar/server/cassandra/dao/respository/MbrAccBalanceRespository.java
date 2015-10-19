package com.yxtar.server.cassandra.dao.respository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.MbrAccBalance;

@Repository
public interface MbrAccBalanceRespository extends CrudRepository<MbrAccBalance, UUID>{
}
