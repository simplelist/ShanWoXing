package com.yxtar.server.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yxtar.app.base.utility.ValidationUtil;
import com.yxtar.server.util.ActionUtils;

/**
 * 
 * @author jackshi
 *
 */
public class BaseAction {
	protected Map<String, Object> resultMap = null;
	protected Map<String, Object> acceptMap = null;
	protected Map<String, Object> resultInfoMap = null;
	protected List<Map<String, Object>> resultInfoList = null;
	protected HttpServletRequest request;
	protected ValidationUtil validationUtil = ValidationUtil.getInstance();
	static Logger log = LogManager.getLogger();
	@ModelAttribute
	private void beforeAtMethod(HttpServletRequest request) {
		initialAction(request);
		log.info("request from address:"+request.getRequestURL());
		try {
			setStreamToMap();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(ErrorType.ParasIsNull.getName());
			faile(ErrorType.ParasIsNull.getName());
		}
	}
	
	
	protected void initialAction(HttpServletRequest request) {
		resultMap = new HashMap<String, Object>();
		acceptMap = new HashMap<String, Object>();
		resultInfoMap = new HashMap<String, Object>();
		resultInfoList=new ArrayList<Map<String, Object>>();
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
			if (request.getInputStream()!=null||validationUtil.StrNotNull(request.getInputStream().toString())) {
				acceptMap = ActionUtils.getInstance().toMap(request.getInputStream());
			}
		}
	}

}
