package com.yxtar.server.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/initial")
public class InitAction extends Action {

	@RequestMapping("/checkMaint")
	@ResponseBody
	public Map<String, Object> checkMaint() {
		int codeversion = -999;
		try {
			codeversion = Integer.valueOf(acceptMap.get("codeversion").toString());
			if (codeversion > 0) {
//				success(maintService.findByCodeVersion(codeversion));
			} else {
				faile(ErrorType.ParasIsNull.getName());
			}
		} catch (Exception e) {
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}

	@RequestMapping("/checkUpdate")
	@ResponseBody
	public Map<String, Object> checkUpdate() {
		int codeversion = -999;
		String platform = null;
		try {
			codeversion = Integer.valueOf(acceptMap.get("codeversion").toString());
			platform = acceptMap.get("platform").toString();
			platform = platform.toLowerCase();

			if (codeversion > 0) {
//				VersionUpdate update = new VersionUpdate();
//				update.setVersionID(codeversion);
//				VersionUpdate map = checkVersionUpdateService.findByVersion(update);
//				if (map != null) {
//					if (platform.contains("android")) {
//						resultMap.put("forceUpdate", map.getAndroidUpdate());
//						resultMap.put("updateLink", map.getAndroidLink());
//					} else if (platform.contains("ios")) {
//						resultMap.put("forceUpdate", map.getIosUpdate());
//						resultMap.put("updateLink", map.getIosLink());
//					}
//				}
			} else {
				faile(ErrorType.ParasIsNull.getName());
			}
		} catch (Exception e) {
			faile(ErrorType.ParasIsNull.getName());
		}

		return resultMap;
	}

	@RequestMapping("/updateData")
	@ResponseBody
	public Map<String, Object> updateData() {
		int dataversion = -999;
		String platform = null;
		try {
			dataversion = Integer.valueOf(acceptMap.get("codeversion").toString());
			platform = acceptMap.get("platform").toString();
			platform = platform.toLowerCase();

			if (dataversion > 0) {
//				SyncData syncData = new SyncData();
//				syncData.setPlatform(platform);
//				syncData.setDataVersion(dataversion);
//				SyncData map = syncDataService.findBySyncData(syncData);
//				if (map != null) {
//					resultMap.put("appData", map.getAppData());
//					resultMap.put("systemData", map.getSystemData());
//				}
			} else {
				faile(ErrorType.ParasIsNull.getName());
			}
		} catch (Exception e) {
			faile(ErrorType.ParasIsNull.getName());
		}
		return resultMap;
	}
}
