package com.yxtar.app.base.activity;

import com.google.gwt.user.client.rpc.ServiceDefTarget;
/**
 * Interface BaseRPCServlets store all the rpc servlet needed
 * @author jimmylo
 *
 */
public interface BaseRPCServlets {
	

	/**
	 * asynSvcLst is used to store all the serviceDefTaget which declared above, for automatically processing rpc servlet initialization
	 *
	 *e.g.
		public ServiceDefTarget[] asynSvcLst = 
			{(ServiceDefTarget) service, (ServiceDefTarget)langSvc, (ServiceDefTarget)widSvc,
				(ServiceDefTarget) categorySvc, (ServiceDefTarget)uploadSvc, (ServiceDefTarget)pageSvc,
				(ServiceDefTarget) productsSvc, (ServiceDefTarget)userSvc,(ServiceDefTarget)textSvc};
	*/
	public ServiceDefTarget[] asynSvcLst = {};
	/**
	 * relativeURLLst store all the url string for automatically processing rpc servlet initialization
	 *e.g.
		public String[] relativeURLLst = 
			{mainRelativeURL, langRelativeURL, widRelativeURL,
				cateRelativeURL, picRelativeURL, pageRelativeURL,
				proRelativeURL, userRelativeURL,textRelativeURL};
	*/
	public String[] relativeURLLst = {};

}
