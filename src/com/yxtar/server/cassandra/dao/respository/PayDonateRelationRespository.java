package com.yxtar.server.cassandra.dao.respository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.PayDonateRelation;

@Repository
public interface PayDonateRelationRespository extends CrudRepository<PayDonateRelation, UUID>{
}
