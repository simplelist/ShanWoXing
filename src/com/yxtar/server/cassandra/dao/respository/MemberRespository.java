package com.yxtar.server.cassandra.dao.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yxtar.server.dto.cassandra.Member;
import com.yxtar.server.dto.cassandra.PK_Member;

@Repository
public interface MemberRespository extends CrudRepository<Member, PK_Member>{
}
