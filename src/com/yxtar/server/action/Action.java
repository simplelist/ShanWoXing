package com.yxtar.server.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.yxtar.app.base.utility.ValidationUtil;
import com.yxtar.server.util.ActionUtils;

/**
 * 
 * @author jackshi
 *
 */
public class Action {
	protected Map<String, Object> resultMap = new HashMap<String, Object>();
	protected Map<String, Object> acceptMap = new HashMap<String, Object>();
	protected HttpServletRequest request;
	protected ValidationUtil validationUtil = ValidationUtil.getInstance();

	@ModelAttribute
	private void beforeAtMethod(HttpServletRequest request) {
		initialAction(request);
		try {
			setStreamToMap();
		} catch (IOException e) {
			e.printStackTrace();
			faile(ErrorType.ParasIsNull.getName());
		}
	}
	
	
	protected void initialAction(HttpServletRequest request) {
		resultMap.clear();
		acceptMap.clear();
		/*
		 * set the HttpServletRequest from subClass;
		 */
		this.request = request;
	}

	protected void faile(String name) {
		resultMap.put("success", false);
		resultMap.put("reason", name);
	}

	protected void success(Object object) {
		resultMap.put("success", true);
		resultMap.put("result", object);
	}

	/**
	 * transform the HttpServletRequest.inputStream to (Map<String, Object> acceptMap)
	 * 
	 * @throws IOException
	 */
	protected void setStreamToMap() throws IOException {
		if (request != null) {
			acceptMap = ActionUtils.getInstance().toMap(request.getInputStream());
		}
	}

}
