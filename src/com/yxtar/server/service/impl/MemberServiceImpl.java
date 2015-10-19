package com.yxtar.server.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxtar.app.shared.enums.PushInfoStatus;
import com.yxtar.server.cassandra.dao.MemberDao;
import com.yxtar.server.cassandra.dao.UserMobileDao;
import com.yxtar.server.cassandra.dao.respository.MbrActionRecordRespository;
import com.yxtar.server.cassandra.dao.respository.MbrPushInfoRespository;
import com.yxtar.server.cassandra.dao.respository.MemberRespository;
import com.yxtar.server.cassandra.dao.respository.MobileNoVerficationRespository;
import com.yxtar.server.cassandra.dao.respository.TestRespository;
import com.yxtar.server.cassandra.dao.respository.UserMobileRespository;
import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.MbrPushInfo;
import com.yxtar.server.dto.cassandra.Member;
import com.yxtar.server.dto.cassandra.MobileNoVerification;
import com.yxtar.server.dto.cassandra.PK_MbrActionRecord;
import com.yxtar.server.dto.cassandra.PK_MbrPushInfo;
import com.yxtar.server.dto.cassandra.PK_Member;
import com.yxtar.server.dto.cassandra.PK_UserMobile;
import com.yxtar.server.dto.cassandra.UserMobile;
import com.yxtar.server.service.MemberService;
import com.yxtar.server.util.Iterable2ListResult;
import com.yxtar.server.util.ListResult;
import com.yxtar.server.util.UUIDUtil;

@Service
public class MemberServiceImpl extends BaseServiceImpl implements MemberService {

	@Autowired
	private MemberRespository memberRespository;
	@Autowired
	private UserMobileRespository userMobileRespository;
	@Autowired
	private UserMobileDao userMobileDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MobileNoVerficationRespository mobileNoVerficationRespository;
	@Autowired
	private TestRespository testRespository;
	@Autowired
	private MbrActionRecordRespository mbrActionRecordRespository;
	
	@Autowired
	private MbrPushInfoRespository mbrPushInfoRespository;
	
	
	
	private Iterable2ListResult util = Iterable2ListResult.getInstance();

	@Override
	public ListResult<Member> getList() {
		List<Member> list = memberDao.findMembers();
		return util.caseToResult(memberRespository.findAll());
	}

	@Override
	public Member findByPhone(String phone) {

		UUID id = null;
		if (validationUtil.StrisNull(phone) || !validationUtil.isPhone(phone)) {
			return null;
		}
		// get the UserMobile.memberId by the phone
		UserMobile userMobile = null;
		PK_UserMobile pk_UserMobile=new PK_UserMobile();
		pk_UserMobile.setPhoneNum(phone);
		userMobile=userMobileRespository.findOne(pk_UserMobile);
		if (userMobile == null) {
			return null;
		}
		// get member by id
		id = userMobile.getMemberId();
		if (id == null) {
			return null;
		}
		Member member = null;
		PK_Member pk=new PK_Member();
		pk.setMemberId(id);
		pk.setNickName(userMobile.getNickName());
		member=memberRespository.findOne(pk);
		return member;
	}

	@Override
	public Boolean resetPwd(UUID memberId, String nickName, String new_password) {
		return memberDao.resetPwd(memberId, nickName, new_password);
	}

	@Override
	public Member registerMember(Member member) {
		Member result=memberRespository.save(member);
		return result;
	}

	@Override
	public MobileNoVerification saveMobileNoVerification(String phone) {
		MobileNoVerification temp=new MobileNoVerification();
		temp.setCreateTime(new Date());
		temp.setPhoneNum(phone);
		temp.setVerificationCode(UUIDUtil.create().toString().substring(0,4));
		MobileNoVerification result=mobileNoVerficationRespository.save(temp);
		return result;
	}

	@Override
	public MobileNoVerification findMNVerByPhone(String phone) {
		return mobileNoVerficationRespository.findOne(phone);
	}

	@Override
	public MbrActionRecord findMbrActionRecordByPK(Integer charityCampId, UUID memberId, Integer periodNum) {
		if (charityCampId==null||validationUtil.StrisNull(memberId+"")||validationUtil.DigitIsVoid(periodNum)) {
			return null;
		}
		PK_MbrActionRecord pk = new PK_MbrActionRecord();
		pk.setCharityCampId(charityCampId);
		pk.setMemberId(memberId);
		pk.setPeriodNum(periodNum);
		return mbrActionRecordRespository.findOne(pk);
	}

	@Override
	public Boolean loginInsertMbrPushInfo(UUID memberId, String tokens, Integer platform) {
		Boolean saveSuccess=false;
		if (memberId==null||validationUtil.DigitIsVoid(platform)) {
			return saveSuccess;
		}
		MbrPushInfo info=new MbrPushInfo();
		PK_MbrPushInfo pk=new PK_MbrPushInfo();
		pk.setMemberId(memberId);
		pk.setPlatform(platform);
		pk.setTokens(tokens);
		info.setCreateTime(new Date());
		info.setStatus(PushInfoStatus.on.getType());
		info.setPk(pk);
		MbrPushInfo save=mbrPushInfoRespository.save(info);
		if (save!=null) {
			saveSuccess=true;
		}
		return saveSuccess;
	}

}
