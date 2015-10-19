package com.yxtar.server.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxtar.app.shared.enums.LoginFailReason;
import com.yxtar.app.shared.enums.MobileNumberCheckReason;
import com.yxtar.server.dto.cassandra.Member;
import com.yxtar.server.dto.cassandra.MobileNoVerification;
import com.yxtar.server.dto.cassandra.PK_Member;
import com.yxtar.server.service.MemberService;
import com.yxtar.server.util.DateUtil;
import com.yxtar.server.util.SendSMSUtil;
import com.yxtar.server.util.UUIDUtil;

@Controller
@RequestMapping("/member")
public class MemberAction extends BaseAction {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/getByAll")
	@ResponseBody
	public Map<String, Object> getByAll() {
		try {
			success(memberService.getList());
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/sendSMS")
	@ResponseBody
	public Map<String, Object> sendSMS() {
		String phone = null;
		try {
			phone = acceptMap.get("phone").toString();
			if (validationUtil.StrisNull(phone)) {
				faile(ErrorType.ParasIsNull.getName());
			}
			Member member = memberService.findByPhone(phone);
			if (member != null) {
				faile(MobileNumberCheckReason.MobileNumberExist.getType());
				return resultMap;
			}
			MobileNoVerification mnv = memberService.saveMobileNoVerification(phone);
			if (mnv == null) {
				faile(MobileNumberCheckReason.SMSCodeRequestedTooFrequently.getType());
				return resultMap;
			}
			String vCode = null;
			vCode = mnv.getVerificationCode();
			SendSMSUtil.sendSMS(phone, "1", vCode, "2");
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("requestResult", true);
			res.put("phoneNum", mnv.getPhoneNum());
			success(res);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/validationSMS")
	@ResponseBody
	public Map<String, Object> validationSMS() {
		String phone = null;
		String code = null;
		try {
			phone = acceptMap.get("phone_num").toString();
			code = acceptMap.get("sms_code").toString();
			if (validationUtil.StrisNull(phone) || validationUtil.StrisNull(code)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			MobileNoVerification mNoVer = memberService.findMNVerByPhone(phone);
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("phoneNum", phone);
			res.put("action", false);
			if (mNoVer != null && (mNoVer.getPhoneNum().equals(phone) || mNoVer.getPhoneNum() == phone)) {
				res.put("action", mNoVer.getVerificationCode().equals(code) || mNoVer.getVerificationCode() == code);
			}
			success(res);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/registerMember")
	@ResponseBody
	public Map<String, Object> registerMember() {
		String phone = null;
		String account_name = null;
		Date birthday = null;
		String gender = null;
		String pw = null;
		Member member = null;
		
		String tokens=null;
		Integer platform=-999;
		try {
			phone = acceptMap.get("phone").toString();
			account_name = acceptMap.get("account_name").toString();
			birthday = DateUtil.getInstance().parseDate(acceptMap.get("birthday").toString(), "yyyy-MM-dd HH:mm:ss");
			gender = acceptMap.get("gender").toString();
			pw = acceptMap.get("pw").toString();
			
			tokens=acceptMap.get("notification_token").toString();
			platform=Integer.valueOf(acceptMap.get("platform").toString());
			if (validationUtil.StrisNull(phone) || validationUtil.StrisNull(account_name) || validationUtil.StrisNull(pw)||validationUtil.DigitIsVoid(platform)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			member = new Member();
			PK_Member pk_Member=new PK_Member();
			pk_Member.setMemberId(UUIDUtil.create());
			pk_Member.setNickName(account_name);;
			member.setPk(pk_Member);;
			member.setGender(gender);
			member.setBirthday(birthday);
			member.setPassword(pw);
			member.setPhoneNum(phone);
			member.setLastLoginTime(new Date());
			member.setType("0");
			Member result = memberService.registerMember(member);
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("register_success", false);
			if (result != null) {
				res.put("register_success", true);
				res.put("member_id", result.getPk().getMemberId());
				
				/**
				 * save mbrPushInfo
				 */
				memberService.loginInsertMbrPushInfo(member.getPk().getMemberId(),tokens,platform);
			}
			success(res);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login() {
		String phone = null;
		String pwStr = null;
		String time = null;
		String tokens=null;
		Integer platform=-999;
		try {
			phone = acceptMap.get("phone").toString();
			pwStr = acceptMap.get("pw").toString();
			time = acceptMap.get("time").toString();
			
			tokens=acceptMap.get("notification_token").toString();
			platform=Integer.valueOf(acceptMap.get("platform").toString());
			if (validationUtil.StrisNull(phone) || validationUtil.StrisNull(pwStr) || validationUtil.StrisNull(time)||validationUtil.DigitIsVoid(platform)) {
				faile(ErrorType.FormatError.getName());
				return resultMap;
			}
			// find member by phoneNum
			Member member = memberService.findByPhone(phone);
			if (member == null || member.getPhoneNum() == null) {
				faile(LoginFailReason.MobileNumberNotExist.getType());
				return resultMap;
			}
			if (member.getPhoneNum() != phone && !member.getPhoneNum().equals(phone)) {
				faile(LoginFailReason.MobileNumberNotExist.getType());
				return resultMap;
			}
			String ppww = member.getPassword();
			if (validationUtil.StrisNull(ppww)) {
				faile(LoginFailReason.IncorrectPassword.getType());
				return resultMap;
			}
			// ZIP(Member.password+""+time(from client)),compare with pwStr from client
			ppww = parseStrToMd5L32(ppww + time);
			if (ppww.equals(pwStr) || ppww == pwStr) {
				Map<String, Object> res = new HashMap<String, Object>();
				Map<String, String> mem = new HashMap<String, String>();
				mem.put("id", member.getPk().getMemberId().toString());
				mem.put("nickname", member.getPk().getNickName());
				mem.put("photoId", member.getPhotoId().toString());
				res.put("login_success", true);
				res.put("member_info", mem);
				/**
				 * save mbrPushInfo
				 */
				memberService.loginInsertMbrPushInfo(member.getPk().getMemberId(),tokens,platform);
				success(res);
			} else {
				faile(LoginFailReason.IncorrectPassword.getType());
			}
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/resetPwd")
	@ResponseBody
	public Map<String, Object> resetPwd() {
		String phone = null;
		String encrypted_code = null;
		String new_password = null;
		String time = null;
		try {
			phone = acceptMap.get("phone").toString();
			encrypted_code = acceptMap.get("encrypted_code").toString();
			new_password = acceptMap.get("new_password").toString();
			time = acceptMap.get("time").toString();
			if (validationUtil.StrisNull(phone) || validationUtil.StrisNull(encrypted_code) || validationUtil.StrisNull(time) || validationUtil.StrisNull(new_password)) {
				faile(ErrorType.FormatError.getName());
				return resultMap;
			}
			// find member by phoneNum
			Member member = memberService.findByPhone(phone);
			if (member == null || member.getPhoneNum() == null) {
				faile(LoginFailReason.MobileNumberNotExist.getType());
				return resultMap;
			}
			if (member.getPhoneNum() != phone && !member.getPhoneNum().equals(phone)) {
				faile(LoginFailReason.MobileNumberNotExist.getType());
				return resultMap;
			}
			String ppww = member.getPassword();
			if (validationUtil.StrisNull(ppww)) {
				faile(LoginFailReason.IncorrectPassword.getType());
				return resultMap;
			}
			// ZIP(Member.password+""+time(from client)),compare with pwStr from client
			ppww = parseStrToMd5L32(ppww + time);
			if (ppww.equals(encrypted_code) || ppww == encrypted_code) {
				boolean done = memberService.resetPwd(member.getPk().getMemberId(), member.getPk().getNickName(), new_password);
				Map<String, Object> res = new HashMap<String, Object>();
				res.put("update", done);
				if (!done) {
					res.put("reason", LoginFailReason.IncorrectPassword.getType());
				}
				success(res);
			} else {
				faile(LoginFailReason.IncorrectPassword.getType());
			}
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	private static String parseStrToMd5L32(String str) {
		String reStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(str.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for (byte b : bytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					stringBuffer.append(0);
				}
				stringBuffer.append(Integer.toHexString(bt));
			}
			reStr = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return reStr;
	}

	public static void main(String[] args) {
		System.err.println(parseStrToMd5L32("0b4e7a0e5fe84ad35fb5f95b9ceeac792015-01-01 00:00:00"));
	}
}
