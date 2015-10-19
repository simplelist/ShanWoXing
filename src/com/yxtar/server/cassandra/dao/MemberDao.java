package com.yxtar.server.cassandra.dao;

import java.util.List;
import java.util.UUID;

import com.yxtar.server.dto.cassandra.Member;

public interface MemberDao {
	List<Member> findMembers();

	Member findById(UUID id);

	Boolean resetPwd(UUID memberId, String nickName, String new_password);
}
