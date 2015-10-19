package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.yxtar.server.dto.cassandra.PK_UserMobile;
import com.yxtar.server.dto.cassandra.UserMobile;

@Component
public interface UserMobileRespository extends CrudRepository<UserMobile, PK_UserMobile>{
}
