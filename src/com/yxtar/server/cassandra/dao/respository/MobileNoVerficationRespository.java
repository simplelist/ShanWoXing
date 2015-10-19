package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.MobileNoVerification;

@Repository
public interface MobileNoVerficationRespository extends CrudRepository<MobileNoVerification, String>{
}
