package com.yxtar.server.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxtar.server.dto.CharityFund;
import com.yxtar.server.service.CharityFundService;
import com.yxtar.server.util.ListResult;

@Controller
@RequestMapping("/charityfund")
public class CharityFundAction extends BaseAction {
	@Autowired
	private CharityFundService charityFundService;

	/**
	 * 301 慈善受助項目列表頁
	 * 
	 * - 301A 獲取受助項目清單接口
	 * 
	 * - 描述
	 * 
	 * - 獲取受助項目清單, 可以status分別拿到己完結或進行中的受助項目
	 * 
	 * - 提交
	 * 
	 * - status - startindex - numOfRow
	 * 
	 * - 返回
	 * 
	 * - charityFundList
	 * 
	 * - id - title - mainSmallPhoto - fundTotal
	 * 
	 * - 備註
	 * 
	 * - read CharityFund@mysql
	 */
	@RequestMapping("/getCharityFundByStatus")
	@ResponseBody
	public Map<String, Object> getCharityFundByStatus() {
		Integer status = -99, startIndex = -99, numOfRow = -99;
		try {
			/**
			 * check the input is OK?
			 * 
			 */
			status = Integer.valueOf(acceptMap.get("status").toString());
			startIndex = Integer.valueOf(acceptMap.get("start_index").toString());
			numOfRow = Integer.valueOf(acceptMap.get("num_of_row").toString());
			if (validationUtil.DigitIsVoid(status, startIndex, numOfRow)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			ListResult<CharityFund> list = charityFundService.getCharityFundByStatus(status, startIndex, numOfRow);
			success(resultInfoMap);
			resultInfoMap.put("charityFundList", resultInfoList);
			if (list.isEmpty()) {
				return resultMap;
			}
			for (CharityFund fund : list.getDataList()) {
				Map<String, Object> fundMap = new HashMap<String, Object>();
				fundMap.put("id", fund.getId());
				fundMap.put("title", fund.getTitle());
				fundMap.put("mainSmallPhoto", fund.getMainSmallPhoto());
				fundMap.put("fundTotal", fund.getFundTotal());
				resultInfoList.add(fundMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}
}
