package com.yxtar.app.base.environment;

import com.yxtar.app.base.utility.ValidationUtil;

public class Environment {
	public static final String contextPath = "/ShanWoXingAdmin";
	public static String urlParam = "/springGwtServices";
	
	
	private static ValidationUtil validationUtil;

	public static ValidationUtil getValidationUtil() {
		if (validationUtil == null) {
			validationUtil = ValidationUtil.getInstance();
		}
		return validationUtil;
	}
}
