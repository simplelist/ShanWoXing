package com.yxtar.server.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxtar.server.dao.IPager;
import com.yxtar.server.dao.impl.Pager;
import com.yxtar.server.dto.CampSponsorRelation;
import com.yxtar.server.dto.CharityCamp;
import com.yxtar.server.dto.CharityCampHistory;
import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.dto.DailyCamp;
import com.yxtar.server.dto.Sponsor;
import com.yxtar.server.dto.cassandra.CampFundVoteStat;
import com.yxtar.server.dto.cassandra.CampReachRateStat;
import com.yxtar.server.dto.cassandra.MbrActionRecord;
import com.yxtar.server.dto.cassandra.PaymentRecord;
import com.yxtar.server.exception.RecordAlreadyUsedException;
import com.yxtar.server.service.CharityCampService;
import com.yxtar.server.service.MemberService;
import com.yxtar.server.util.DateUtil;
import com.yxtar.server.util.ListResult;
import com.yxtar.server.util.UUIDUtil;

@Controller
@RequestMapping("/charity")
public class CharityAction extends BaseAction {

	@Autowired
	private CharityCampService charityCampService;
	@Autowired
	private MemberService memberService;

	/**
	 * - 101A 搜索所有活動接口 - 描述 - 獲取把所有非完結慈善活動清單
	 * 
	 * - 提交 - 關鍵字（如有） - startIndex - numOfRow
	 * 
	 * - 返回 - CharityCampList
	 * 
	 * - CharityCampId - CharityCampTitle - CharityCampPhoto - CharityCampAmount
	 * 
	 * - 備註 - read CharityCamp@mysql
	 * 
	 * @return
	 */
	@RequestMapping("/getUncompletedCharity")
	@ResponseBody
	public Map<String, Object> getUncompletedCharity() {
		String word = null;
		String start_index = null;
		int num_of_row = -99;
		int page = -99;
		try {
			/**
			 * check input data is OK?
			 */
			word = acceptMap.get("word").toString();
			start_index = acceptMap.get("start_index").toString();
			num_of_row = Integer.valueOf(acceptMap.get("num_of_row").toString());
			page = Integer.valueOf(start_index);
			/**
			 * getUncompletedCharity by parameters
			 */
			ListResult<CharityCamp> list = new ListResult<CharityCamp>();
			IPager pager = new Pager();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("word", word);
			pager.setParams(params);
			pager.setLimit(num_of_row);
			pager.setPage(page);
			list = charityCampService.getUncompletedCharity(pager);
			/**
			 * box the result and return
			 */
			resultInfoMap.put("CharityCampList", resultInfoList);
			success(resultInfoMap);
			if (list.isEmpty()) {
				return resultMap;
			}
			for (CharityCamp camp : list.getDataList()) {
				Map<String, Object> campInfoMap = new HashMap<String, Object>();
				campInfoMap.put("CharityCampId", camp.getId());
				campInfoMap.put("CharityCampTitle", camp.getTitle());
				campInfoMap.put("CharityCampPhoto", camp.getIntroMainPhoto());
				campInfoMap.put("CharityCampAmount", camp.getAmountPerSupport());
				resultInfoList.add(campInfoMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 101B 搜索附近活動接口 - 描述 - 獲取把所有非完結慈善活動清單
	 * 
	 * - 提交 - 關鍵字（如有） - startIndex - numOfRow - 省 - 市 - 區
	 * 
	 * - 返回 - CharityCampList
	 * 
	 * - CharityCampId - CharityCampTitle - CharityCampPhoto - CharityCampAmount
	 * 
	 * - 備註 - read CharityCamp@mysql
	 * 
	 * @return
	 */
	@RequestMapping("/getUncompletedCharityNear")
	@ResponseBody
	public Map<String, Object> getUncompletedCharityNear() {
		String province = null, city = null, area = null, start_index = null, word = null;
		int num_of_row = -99;
		int page = -99;
		try {
			/**
			 * check input data is OK?
			 */
			province = acceptMap.get("province").toString();
			city = acceptMap.get("city").toString();
			area = acceptMap.get("area").toString();
			word = acceptMap.get("word").toString();
			start_index = acceptMap.get("start_index").toString();
			num_of_row = Integer.valueOf(acceptMap.get("num_of_row").toString());
			page = Integer.valueOf(start_index);

			/**
			 * getUncompletedCharity by parameters
			 */
			ListResult<CharityCamp> list = new ListResult<CharityCamp>();
			IPager pager = new Pager();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("word", word);
			params.put("province", province);
			params.put("city", city);
			params.put("area", area);
			pager.setParams(params);
			pager.setLimit(num_of_row);
			pager.setPage(page);
			list = charityCampService.getUncompletedCharity(pager);
			/**
			 * box the result and return
			 */
			resultInfoMap.put("CharityCampList", resultInfoList);
			success(resultInfoMap);
			if (list.isEmpty()) {
				return resultMap;
			}
			for (CharityCamp camp : list.getDataList()) {
				Map<String, Object> campInfoMap = new HashMap<String, Object>();
				campInfoMap.put("CharityCampId", camp.getId());
				campInfoMap.put("CharityCampTitle", camp.getTitle());
				campInfoMap.put("CharityCampPhoto", camp.getIntroMainPhoto());
				campInfoMap.put("CharityCampAmount", camp.getAmountPerSupport());
				resultInfoList.add(campInfoMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * 1. 會員用App Scan QR code後， 2. 如是個人活動QR Code, 用戶會從QR Code中獲得locationId向後台請求獲得個人活動（ dailycamp）內容
	 * 
	 * 
	 * • read MbrDailyCampRecord@cassandra, check if reached this location already or not • read
	 * PlatformLocation@cassandra, get province, city, district, street • update PlatformLocation@cassandra - reachRate
	 * • read dailyCampLocation@cassandra ◦ search with “province", “city", “district", "street" ◦ search
	 * with “province", “city", “district", “all" ◦ search with “province", “city", “all", “all" ◦ search
	 * with “province", “all", “all", “all" ◦ search with “all", “all", “all", “all" • read DailyCampStat@cassandra,
	 * find remainPreparedAmount > 0 • update DailyCampStat@cassandra , remainPreparedAmount - amountPerSupport
	 * 
	 * @return
	 */
	@RequestMapping("/getCharityByLocationID")
	@ResponseBody
	public Map<String, Object> getCharityByLocationID() {
		UUID memberId = null, locationId = null;
		try {
			/**
			 * check input data is OK?
			 */
			String mid = null;
			String lid = null;
			mid = acceptMap.get("member_id").toString();
			lid = acceptMap.get("location_id").toString();
			if (validationUtil.StrisNull(mid) || validationUtil.StrisNull(lid)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			memberId = UUIDUtil.create(mid);
			locationId = UUIDUtil.create(lid);
			if (memberId == null || locationId == null) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			try {
				/**
				 * getCharityByLocationID by memberId, locationId
				 */
				DailyCamp camp = charityCampService.getCharityByLocationID(memberId, locationId);

				Map<String, Object> campMap = new HashMap<String, Object>();
				/**
				 * box the result and return
				 */
				resultInfoMap.put("DailyCampInfo", campMap);
				success(resultInfoMap);
				if (camp != null) {
					campMap.put("dCampId", camp.getDcampId());
					campMap.put("campTitle", camp.getCampTitle());
					campMap.put("campAdvPhoto", camp.getCampAdvPhoto());
					campMap.put("sponsorName", camp.getSponsorId().getCompanyName());
					campMap.put("sponsorLogo", camp.getSponsorId().getSquareLogoPhoto());
				}
			} catch (RecordAlreadyUsedException e) {
				faile("DailyCampFailReason-" + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 101D 獲得慈善活動支持動作信息接口 - 描述
	 * 
	 * - 會員用App Scan QR code後，
	 * 
	 * - 如是慈善活動QR Code, 用戶App會從QR Code中獲得campId向後台請求獲得慈善活動（ camp）簡單內容
	 * 
	 * - 提交 - campId
	 * 
	 * - 返回 - campInfo - dCampId - status - campTitle - actionType - actionAdvPhoto - actionQuestion - actionAnswer
	 * 
	 * - 備註 - read CharityCamp@mysql
	 * 
	 * @return
	 */
	@RequestMapping("/getCharityByDCampID")
	@ResponseBody
	public Map<String, Object> getCharityByCampID() {
		Integer dCampId = -99;
		try {
			/**
			 * check input data is OK?
			 */
			dCampId = Integer.valueOf(acceptMap.get("camp_id").toString());
			if (validationUtil.DigitIsVoid(dCampId)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			CharityCamp camp = charityCampService.getCharityByDCampID(dCampId);
			Map<String, Object> campMap = new HashMap<String, Object>();
			/**
			 * box the result and return
			 */
			resultInfoMap.put("campInfo", campMap);
			success(resultInfoMap);
			if (camp != null) {
				campMap.put("dCampId", camp.getId());
				campMap.put("status", camp.getStatus());
				campMap.put("campTitle", camp.getTitle());
				campMap.put("actionType", camp.getActionType());
				campMap.put("actionAdvPhoto", camp.getActionAdvPhoto());
				campMap.put("actionQuestion", camp.getActionQuestion());
				campMap.put("actionAnswer", camp.getActionAnswer());
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 102A 獲取活動信息接口 - 描述
	 * 
	 * - 獲取慈善活動詳細信息
	 * 
	 * - 查看用戶有否支持過該活動
	 * 
	 * - 提交 - CharityCampid - memberId
	 * 
	 * - 返回
	 * 
	 * - 返回Mysql中CharityCamp表格中的數據 - supportedFlag boolean
	 * 
	 * - 備註 - read CharityCamp@mysql - use CharityCamp data from mysql and read MbrActionRecord表中的數據
	 * 
	 */
	@RequestMapping("/getCharityByID")
	@ResponseBody
	public Map<String, Object> getCharityByID() {
		Integer charityCampId = -99;
		UUID memberId = null;
		try {
			/**
			 * check input data is OK?
			 */
			String mid = null;
			charityCampId = Integer.valueOf(acceptMap.get("charity_camp_id").toString());
			mid = acceptMap.get("member_id").toString();
			if (validationUtil.DigitIsVoid(charityCampId)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			if (mid == null || validationUtil.StrisNull(mid)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			memberId = UUIDUtil.create(mid);
			/**
			 * getCharityByDCampID by charityCampId
			 */
			CharityCamp camp = charityCampService.getCharityByDCampID(charityCampId);
			if (camp == null) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			Map<String, Object> campMap = new HashMap<String, Object>();
			campMap.put("id", camp.getId());

			campMap.put("status", camp.getStatus());
			campMap.put("title", camp.getTitle());

			campMap.put("smallHorPhoto", camp.getSmallHorPhoto());
			campMap.put("smallVertPhoto", camp.getSmallVertPhoto());
			campMap.put("introMainPhoto", camp.getIntroMainPhoto());
			campMap.put("eventUsagePhoto", camp.getEventUsagePhoto());
			campMap.put("introdlong", camp.getIntrodLong());
			campMap.put("introdshort", camp.getIntrodShort());
			campMap.put("campType", camp.getCampType());
			campMap.put("cyclenumber", camp.getCycleNumber());
			campMap.put("cyclenoofdate", camp.getCycleNoofdate());
			campMap.put("startdate", camp.getStartDate());
			campMap.put("enddate", camp.getEndDate());
			campMap.put("province", camp.getProvince());
			campMap.put("city", camp.getCity());
			campMap.put("district", camp.getDistrict());
			campMap.put("actionType", camp.getActionType());
			campMap.put("actionadvphoto", camp.getActionAdvPhoto());
			campMap.put("actionquestion", camp.getActionQuestion());
			campMap.put("isPublic", camp.getIsPublic());
			campMap.put("targetType", camp.getTargetType());
			campMap.put("numOfTarget", camp.getNumOfTarget());
			campMap.put("numPeopleTOne", camp.getNumPeopleTOne());
			campMap.put("numPeopleTTwo", camp.getNumPeopleTTwo());
			campMap.put("numPeopleTThree", camp.getNumPeopleTThree());
			campMap.put("donationTOne", camp.getDonationTOne());
			campMap.put("donationTTwo", camp.getDonationTTwo());
			campMap.put("donationTThree", camp.getDonationTThree());
			campMap.put("amountPerSupport", camp.getAmountPerSupport());
			campMap.put("maxDonationAmount", camp.getMaxDonationAmount());
			campMap.put("longitude", camp.getLongitude());
			campMap.put("latitude", camp.getLatitude());
			campMap.put("periodNum", camp.getPeriodNum());
			campMap.put("actionanswer", camp.getActionAnswer());
			/**
			 * findMbrActionRecordByPK by primaryKey(charityCampId, memberId, periodNum())
			 */
			MbrActionRecord mbrActionRecord = memberService.findMbrActionRecordByPK(charityCampId, memberId, camp.getPeriodNum());
			Integer adId = camp.getAdvertisers().getId();
			campMap.put("advertisers", adId);
			Set<CampSponsorRelation> sponsor = camp.getCampSponsorRelations();

			for (CampSponsorRelation campSponsorRelation : sponsor) {
				Map<String, Object> sponMap = new HashMap<String, Object>();
				sponMap.put("id", campSponsorRelation.getSponsor().getId());
				sponMap.put("logo", campSponsorRelation.getSponsor().getHoriLogoPhoto());
				resultInfoList.add(sponMap);
			}
			/**
			 * box the result and return
			 */
			campMap.put("sponsorList", resultInfoList);
			resultInfoMap.put("supportedFlag", mbrActionRecord != null);
			resultInfoMap.put("charityCamp", campMap);
			success(resultInfoMap);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 102B 獲取活動進度接口
	 * 
	 * - 描述
	 * 
	 * - 獲取活動進度
	 * 
	 * - 提交 - CharityCampid
	 * 
	 * - 返回 - reachRate
	 * 
	 * - 查看次數 - supportCount
	 * 
	 * - 會員支持次數
	 * 
	 * - 備註
	 * 
	 * - 返回Cassandra中CampReachRateStat表格中的數據
	 */

	@RequestMapping("/getProgressByCharityID")
	@ResponseBody
	public Map<String, Object> getProgressByCharityID() {
		Integer charityCampId = -99;
		Integer periodNum = -99;
		try {
			/**
			 * check input data is OK?
			 */
			charityCampId = Integer.valueOf(acceptMap.get("charity_camp_id").toString());
			periodNum = Integer.valueOf(acceptMap.get("period_num").toString());
			if (validationUtil.DigitIsVoid(charityCampId,periodNum) ) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			CampReachRateStat stat = charityCampService.getProgressByCharityID(charityCampId, periodNum);
			/**
			 * box the result and return
			 */
			success(resultInfoMap);
			if (stat == null) {
				return resultMap;
			}
			resultInfoMap.put("reachRate", stat.getReachRate());
			resultInfoMap.put("supportCount", stat.getSupportCount());
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * 
	 - 102E 獲取活動贊助商接口 - 描述
	 * 
	 * - 獲取贊助商列表
	 * 
	 * - 提交 - CharityCampid
	 * 
	 * - 返回 - SponsorList - sponsorId - sponsorName - horiLogoPhoto
	 * 
	 * - 備註
	 * 
	 * - 返回Mysql中Sponsor表格中的數據
	 */

	@RequestMapping("/getSponsorListByCharityID")
	@ResponseBody
	public Map<String, Object> getSponsorListByCharityID() {
		Integer charityCampId = -99;
		try {
			/**
			 * check input data is OK?
			 */
			charityCampId = Integer.valueOf(acceptMap.get("charity_camp_id").toString());
			if (validationUtil.DigitIsVoid(charityCampId)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			ListResult<Sponsor> sponsorList = charityCampService.getSponsorListByCharityID(charityCampId);
			/**
			 * box the result and return
			 */
			resultInfoMap.put("sponsorList", resultInfoList);
			success(resultInfoMap);
			if (sponsorList.isEmpty()) {
				return resultMap;
			}
			for (Sponsor sponsor : sponsorList.getDataList()) {
				Map<String, Object> sponsorMap = new HashMap<String, Object>();
				sponsorMap.put("sponsorId", sponsor.getId());
				sponsorMap.put("sponsorName", sponsor.getCompanyName());
				sponsorMap.put("horiLogoPhoto", sponsor.getHoriLogoPhoto());
				resultInfoList.add(sponsorMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 105A 獲取慈善活動事件清單接口
	 * 
	 * - 描述
	 * 
	 * - 獲取該慈善活動的相關事件，以在時間線顯示
	 * 
	 * - 提交 - campId - startindex - numOfRow
	 * 
	 * - 返回 - CampEventList - CharityCampHistory
	 * 
	 * - 備註 - read CharityCampHistory@mysql中的數據
	 * 
	 * @return
	 */
	@RequestMapping("/getEventByCampID")
	@ResponseBody
	public Map<String, Object> getEventByCampID() {
		Integer charityCampId = -99;
		Integer startIndex = null;
		Integer numOfRow = -99;
		try {
			/**
			 * check input data is OK?
			 */
			charityCampId = Integer.valueOf(acceptMap.get("camp_id").toString());
			numOfRow = Integer.valueOf(acceptMap.get("num_of_row").toString());
			startIndex = Integer.valueOf(acceptMap.get("start_index").toString());
			if (validationUtil.DigitIsVoid(charityCampId,numOfRow)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			ListResult<CharityCampHistory> history = charityCampService.getEventByCampID(charityCampId, startIndex, numOfRow);
			List<CharityCampHistory> list = new ArrayList<CharityCampHistory>();
			/**
			 * box the result and return
			 */
			resultInfoMap.put("CampEventList", list);
			success(resultInfoMap);
			if (history.isEmpty()) {
				return resultMap;
			}
			for (CharityCampHistory his : history.getDataList()) {
				his.setCharityCampId(null);
				list.add(his);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 106 慈善受助項目投票頁 - 106A 獲取活動投票受助項目清單接口
	 * 
	 * - 描述
	 * 
	 * - 獲取活動投票受助項目清單, 以在會員執行支持動作後，投票使用
	 * 
	 * - 提交 - campId
	 * 
	 * - 返回 - CampFundChoiceList - id - title - voteTablePhoto - introShort
	 * 
	 * - 備註 - read CharityFund＠mysql
	 * 
	 */
	@RequestMapping("/getCampFundChoiceListByCampID")
	@ResponseBody
	public Map<String, Object> getCampFundChoiceListByCampID() {
		Integer charityCampId = -99;
		try {
			/**
			 * check input data is OK?
			 */
			charityCampId = Integer.valueOf(acceptMap.get("camp_id").toString());
			if (validationUtil.DigitIsVoid(charityCampId)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			ListResult<CharityFund> fundListResult = charityCampService.getCharityFundByCampID(charityCampId);
			/**
			 * box the result and return
			 */
			resultInfoMap.put("CampFundChoiceList", resultInfoList);
			success(resultInfoMap);
			if (fundListResult.isEmpty()) {
				return resultMap;
			}
			for (CharityFund fund : fundListResult.getDataList()) {
				Map<String, Object> fundMap = new HashMap<String, Object>();
				fundMap.put("id", fund.getId());
				fundMap.put("title", fund.getTitle());
				fundMap.put("voteTablePhoto", fund.getVoteTablePhoto());
				fundMap.put("introShort", fund.getIntrodShort());
				resultInfoList.add(fundMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/***
	 * - 106B 投選受助項目接口
	 * 
	 * - 描述
	 * 
	 * - 向後台提交選票，投選受助項目
	 * 
	 * - 提交 - campId - memberId - fundId - createTime - CharityActionRecord中的值, 應由110A 結果獲取
	 * 
	 * - 返回 - boolean 成功／失敗
	 * 
	 * - 備註 - update CharityActionRecord, CampFundVoteStat@cassandra,
	 * 
	 * @return
	 */
	@RequestMapping("/choiceVote")
	@ResponseBody
	public Map<String, Object> choiceVote() {
		Integer charityCampId = -99, fundId = -99, periodNum = -99;
		UUID memberId = null;
		Date createTime = null;
		try {
			/**
			 * check the input is OK?
			 * 
			 */
			charityCampId = Integer.valueOf(acceptMap.get("camp_id").toString());
			fundId = Integer.valueOf(acceptMap.get("fund_id").toString());
			memberId = UUIDUtil.create(acceptMap.get("member_id").toString());
			periodNum = Integer.valueOf(acceptMap.get("period_num").toString());
			createTime = DateUtil.getInstance().parseDate(acceptMap.get("create_time").toString(), "yyyy-MM-dd hh:mm:ss");
			if (validationUtil.DigitIsVoid(charityCampId,fundId)  || memberId == null || createTime == null) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			/**
			 * box the result and return
			 */
			Boolean update = false;
			update = charityCampService.choiceVote(charityCampId, fundId, memberId, periodNum, createTime);
			resultInfoMap.put("update", update);
			success(resultInfoMap);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * 107 慈善受助項目投票完成頁
	 * 
	 * - 107A 獲取活動投票結果接口
	 * 
	 * - 描述
	 * 
	 * - 獲取活動投票結果
	 * 
	 * - 提交
	 * 
	 * - campId - periodNum
	 * 
	 * - 返回
	 * 
	 * - voteDataList
	 * 
	 * - fundId - fundTitle - numOfVote
	 * 
	 * - 備註
	 * 
	 * - read CampFundVoteStat@cassandra
	 * 
	 */
	@RequestMapping("/getVoteDataList")
	@ResponseBody
	public Map<String, Object> getVoteDataList() {
		Integer charityCampId = -99, periodNum = -99;
		try {
			/**
			 * check the input is OK?
			 */
			charityCampId = Integer.valueOf(acceptMap.get("camp_id").toString());
			periodNum = Integer.valueOf(acceptMap.get("period_num").toString());
			if (validationUtil.DigitIsVoid(charityCampId,periodNum)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			/***
			 * getVoteDataList by primaryKey(charityCampId, periodNum)
			 */
			ListResult<CampFundVoteStat> voteList = charityCampService.getVoteDataList(charityCampId, periodNum);
			/**
			 * get charityFund by charityCampId,put them to hashMap<Integer,String> :fundId,fundTitle ; get fundTitle by
			 * fundId;
			 */
			ListResult<CharityFund> fundListResult = charityCampService.getCharityFundByCampID(charityCampId);
			Map<Integer, String> fundHashMap = new HashMap<Integer, String>();
			if (!fundListResult.isEmpty()) {
				for (CharityFund fund : fundListResult.getDataList()) {
					fundHashMap.put(fund.getId(), fund.getTitle());
				}
			}
			/*
			 * box the to list and return
			 */
			resultInfoMap.put("voteDataList", resultInfoList);
			success(resultInfoMap);
			/**
			 * if the voteList is OK then box them
			 */
			if (voteList.isEmpty()) {
				return resultMap;
			}
			for (CampFundVoteStat vote : voteList.getDataList()) {
				Map<String, Object> voteMap = new HashMap<String, Object>();
				voteMap.put("fundId", vote.getPk().getFundId());
				/**
				 * get fundTitle by fundId;
				 */
				voteMap.put("fundTitle", fundHashMap.get(vote.getPk().getFundId()));
				voteMap.put("numOfVote", vote.getNumOfVote());
				resultInfoList.add(voteMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * 108 慈善受助項目投票頁（故事明細版）
	 * 
	 * - 108A 獲取受助項目明細
	 * 
	 * - 描述
	 * 
	 * - 獲取受助項目詳細故事內容
	 * 
	 * - 提交
	 * 
	 * - fundId
	 * 
	 * - 返回
	 * 
	 * - introPageNum - htmlIntroList
	 * 
	 * - 備註
	 * 
	 * - read CharityFund@mysql
	 * 
	 * - 投票 － 重用106B
	 * 
	 * @return
	 */
	@RequestMapping("/getFundByID")
	@ResponseBody
	public Map<String, Object> getFundByID() {
		Integer fundId = -99;
		try {
			/**
			 * check the input is OK?
			 * 
			 */
			fundId = Integer.valueOf(acceptMap.get("fund_id").toString());
			if (validationUtil.DigitIsVoid(fundId)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			/**
			 * box the result and return
			 */
			CharityFund fund = null;
			fund = charityCampService.getCharityFundByID(fundId);
			success(resultInfoMap);
			if (fund == null) {
				return resultMap;
			}
			resultInfoMap.put("introPageNum", fund.getIntrodPageNum());
			resultInfoMap.put("htmlIntroList", fund.getHtmlIntrod());
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 事件頁4_捐款事件
	 * 
	 * - 109A 獲取捐款事件明細接口
	 * 
	 * - 描述
	 * 
	 * - 獲取交付單內容
	 * 
	 * - 提交
	 * 
	 * - paymentRecordId
	 * 
	 * - 返回
	 * 
	 * - charityFundId - charityFundTitle - amount - paidTime - paymentRecordPhotoId
	 * 
	 * - 備註
	 * 
	 * - read PaymentRecord@cassandra
	 * 
	 * @return
	 */
	@RequestMapping("/getPaymentEventByID")
	@ResponseBody
	public Map<String, Object> getPaymentEventByID() {
		UUID recordId = null;
		try {
			/**
			 * check the input is OK?
			 * 
			 */
			String id = null;
			id = acceptMap.get("payment_record_id").toString();
			if (validationUtil.StrisNull(id)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			/**
			 * box the result and return
			 */
			recordId = UUIDUtil.create(id);
			PaymentRecord record = null;
			record = charityCampService.getPaymentEventByID(recordId);
			success(resultInfoMap);
			if (record == null) {
				return resultMap;
			}
			resultInfoMap.put("charityFundId", record.getCharityCampId());
			resultInfoMap.put("charityFundTitle", record.getCharityFundTitle());
			resultInfoMap.put("amount", record.getAmount());
			resultInfoMap.put("paidTime", record.getPaidTime());
			resultInfoMap.put("paymentRecoverdPhotoId", record.getPaymentRecordphotoId());
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * - 110A 活動動作完成提交接口
	 * 
	 * - 描述
	 * 
	 * - 會員完成活動動作後，向後台提交數據以紀錄
	 * 
	 * - 提交
	 * 
	 * - memberId - campId - actionType - actionContent
	 * 
	 * - 返回
	 * 
	 * - boolean 成功／後敗 - createTime
	 * 
	 * - 投票時使用的參數值
	 * 
	 * - 備註
	 * 
	 * - 需寫兩張表MbrActionRecord和CharityActionRecord
	 * 
	 * - 兩表中createTime要一樣 - update CampReachRateStat@cassandra - update MbrAccBalance@cassandra
	 * 
	 * @return
	 */
	@RequestMapping("/setCharityCompleted")
	@ResponseBody
	public Map<String, Object> setCharityCompleted() {
		UUID memberId = null;
		Integer campId = -999, actionType = -999;
		String content = null;
		try {
			/**
			 * check the input is OK?
			 * 
			 */
			String id = null;
			id = acceptMap.get("member_id").toString();
			campId = Integer.valueOf(acceptMap.get("camp_id").toString());
			actionType = Integer.valueOf(acceptMap.get("action_type").toString());
			content = acceptMap.get("action_content").toString();
			if (validationUtil.StrisNull(id) || validationUtil.StrisNull(content) || validationUtil.DigitIsVoid(campId,actionType)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			/**
			 * box the result and return
			 */
			memberId = UUIDUtil.create(id);
			MbrActionRecord mbrRecord = null;
			mbrRecord = charityCampService.setCharityCompleted(memberId, campId, actionType, content);
			success(resultInfoMap);
			if (mbrRecord == null) {
				resultInfoMap.put("update", false);
				return resultMap;
			}
			resultInfoMap.put("update", true);
			resultInfoMap.put("createTime", mbrRecord.getCreateTime());
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	/**
	 * 112 個人活動完成頁
	 * 
	 * - 112A 個人活動完成提交接口
	 * 
	 * - 描述
	 * 
	 * - 個人活動動作完成後，向後台提交數據以紀錄及獲取善款
	 * 
	 * - 提交
	 * 
	 * - memberId - dCampId - locationId
	 * 
	 * - 返回
	 * 
	 * - boolean 成功／後敗 - sponsorName - sponsorLogo - amountPerSupport - accBalance
	 * 
	 * - 備註
	 * 
	 * - read DailyCamp - insert DailyCampRecord@cassandra - insert MbrDailyCampRecord@cassandra, with createDate =
	 * Year, Month, Date only - update MbrAccBalance@cassandra - insert MbrAccTransaction@cassandra - update
	 * DailyCampStat@cassandra, remainAmount, remainPreparedAmount
	 */
	
	@RequestMapping("/setMbrActivityCompleted")
	@ResponseBody
	public Map<String, Object> setMbrActivityCompleted() {
		UUID memberId = null,locationId=null;
		Integer dCampId=-99;
		try {
			/**
			 * check the input is OK?
			 * 
			 */
			String mId = null,locaId=null;
			mId=acceptMap.get("member_id").toString();
			dCampId=Integer.valueOf(acceptMap.get("d_camp_id").toString());
			locaId=acceptMap.get("location_id").toString();
			if (validationUtil.StrisNull(mId) || validationUtil.StrisNull(locaId) ||validationUtil.DigitIsVoid(dCampId)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			/**
			 * box the result and return
			 */
			memberId = UUIDUtil.create(mId);
			locationId = UUIDUtil.create(locaId);
			Map<String, Object> saveResult =charityCampService.setMbrActivityCompleted(memberId, dCampId,locationId);
			success(saveResult);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}
}
