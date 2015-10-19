package com.yxtar.server.cassandra.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;
import com.yxtar.server.cassandra.dao.MemberDao;
import com.yxtar.server.dto.cassandra.Member;

@Repository()
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private CassandraOperations operation;

	@Override
	public List<Member> findMembers() {
		Select select = QueryBuilder.select().all().from("shanwoxing", "member");
		select.setConsistencyLevel(ConsistencyLevel.QUORUM);
		return operation.select(select, Member.class);
	}

	@Override
	public Member findById(UUID id) {
		Select select = QueryBuilder.select().all().from("shanwoxing", "member");
		Iterable<Member> rs = operation.select(select, Member.class);
		Member member = null;
		if (rs != null) {
			for (Member m : rs) {
				if (m != null) {
					member = m;
					break;
				}
			}
		}
		return member;
	}

	@Override
	public Boolean resetPwd(UUID memberId,String nickName, String new_password) {
		Boolean done=false;
		try {
			Update update=QueryBuilder.update("member");
			update.setConsistencyLevel(ConsistencyLevel.ONE);
			update.with(QueryBuilder.set("password", new_password));
			update.where(QueryBuilder.eq("memberid", memberId));
			update.where(QueryBuilder.eq("nickName", nickName));
			operation.execute(update);
			done=true;
		} catch (Exception e) {
			done=false;
			e.printStackTrace();
		}
		return done;
	}
}
