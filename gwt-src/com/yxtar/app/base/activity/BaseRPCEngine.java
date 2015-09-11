package com.yxtar.app.base.activity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.yxtar.app.base.environment.Environment;

/**
 * BaseRPCEngine automatically proceeded all the rpc servlet initialization
 * currently it is inherited by BaseSystemEngine and BaseWidgetActivity 
 * @author jimmylo
 *
 */
public class BaseRPCEngine implements BaseRPCServlets {

	public BaseRPCEngine(){
		for(int i = 0; i < this.relativeURLLst.length; i++){
			processEntryPoint(this.asynSvcLst[i], this.relativeURLLst[i]);
		}
	}

	/**
	 * setup rpc endpoint url for RPC calling to J2EE servlet
	 * @param endpoint ServiceDefTarget, service object
	 * @param servletPath servlet path without url prefix of the hosted page 
	 */
	protected void processEntryPoint(ServiceDefTarget endpoint, String servletPath){
		String hostedBaseURL = getHostPageBaseURL(GWT.getHostPageBaseURL());
		String modelRelativeURL = hostedBaseURL + servletPath;
		endpoint.setServiceEntryPoint(modelRelativeURL);
	}

	/**
	 * get the main url for rpc call path
	 * @param refHostPageBaseURL url prefix of the hosted page 
	 */
	private String getHostPageBaseURL(String refHostPageBaseURL){
		
		String returnStr = "";
		//filter for development use
		if(refHostPageBaseURL.contains(Environment.contextPath)){
			returnStr = Environment.contextPath;
		}
		return returnStr;
	}
}
