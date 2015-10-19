package com.yxtar.server.service;

import java.util.UUID;

import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.Member;
import com.yxtar.server.dto.cassandra.MobileNoVerification;
import com.yxtar.server.util.ListResult;


public interface MemberService{
	
	ListResult<Member> getList();

	Member findByPhone(String phone);

	Boolean resetPwd(UUID memberId, String nickName, String new_password);

	Member registerMember(Member member);

	MobileNoVerification saveMobileNoVerification(String phone);

	MobileNoVerification findMNVerByPhone(String phone);

	MbrActionRecord findMbrActionRecordByPK(Integer charityCampId, UUID memberId, Integer periodNum);

	Boolean loginInsertMbrPushInfo(UUID memberId, String tokens, Integer platform);
}
