package com.yxtar.server.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxtar.server.dto.AppDataPreload;
import com.yxtar.server.dto.SystemSetting;
import com.yxtar.server.service.AppDataPreloadService;
import com.yxtar.server.service.SystemSettingService;

@Controller
@RequestMapping("/initial")
public class InitAction extends BaseAction {

	@Autowired
	private SystemSettingService systemSettingService;

	@Autowired
	private AppDataPreloadService appDataPreloadService;

	@RequestMapping("/checkMaint")
	@ResponseBody
	public Map<String, Object> checkMaint() {
		int codeversion = -999;
		try {
			codeversion = Integer.valueOf(acceptMap.get("codeversion").toString());
			if (codeversion > 0) {
				SystemSetting setting = systemSettingService.checkMaint(codeversion);
				if (setting != null) {
					Map<String, Object> res = new HashMap<String, Object>();
					res.put("maintFlag", setting.getMaintFlag());
					res.put("presetMaintFlag", setting.getPresetMaintFlag());
					res.put("serverMaintFrom", setting.getPresetMaintStartTime());
					res.put("serverMaintTo", setting.getPresetMainEndTime());
					success(res);
				}
			} else {
				faile(ErrorType.ParasIsNull.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/checkUpdate")
	@ResponseBody
	public Map<String, Object> checkUpdate() {
		int codeversion = -999;
		int platform = -999;
		try {
			codeversion = Integer.valueOf(acceptMap.get("codeversion").toString());
			platform = Integer.valueOf(acceptMap.get("platform").toString());

			if (codeversion > 0 && platform >= 0) {
				SystemSetting setting = systemSettingService.checkMaint(codeversion);
				if (setting != null) {
					if (setting.getPlatform() != null && setting.getPlatform() == platform) {
						Map<String, Object> res = new HashMap<String, Object>();
						res.put("forceUpdate", setting.getAppLatestDataVersion() > codeversion);
						res.put("updateLink", setting.getUpdateLink());
						success(res);
					}
				}
			} else {
				faile(ErrorType.ParasIsNull.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}

		return resultMap;
	}

	@RequestMapping("/dataUpdate")
	@ResponseBody
	public Map<String, Object> dataUpdate() {
		int codeversion = -999;
		int platform = -999;
		try {
			codeversion = Integer.valueOf(acceptMap.get("codeversion").toString());
			platform = Integer.valueOf(acceptMap.get("platform").toString());

			if (codeversion > 0 && platform >= 0) {
				AppDataPreload preload = appDataPreloadService.checkUpdate(codeversion, platform);
				Map<String, Object> res = new HashMap<String, Object>();
				res.put("update", false);
				if (preload != null) {
					res.put("update", true);
					res.put("updateAction", preload.getActionList());
				}
				success(res);
			} else {
				faile(ErrorType.ParasIsNull.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/commitTokens")
	@ResponseBody
	public Map<String, Object> commitTokens() {
		String tokens = null;
		int platform = -999;
		try {
			tokens = acceptMap.get("notification_token").toString();
			platform = Integer.valueOf(acceptMap.get("platform").toString());
			if (validationUtil.DigitIsVoid(platform)) {
				faile(ErrorType.ParasIsNull.getName());
				return resultMap;
			}
			Boolean saveSysPushInfo = systemSettingService.InsertSysPushInfo(tokens, platform);
			resultInfoMap.put("success", saveSysPushInfo);
			success(resultInfoMap);
		} catch (Exception e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}
}
