package com.yxtar.app.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.yxtar.app.base.environment.Environment;

public interface ClientRpcs {

	public AdminTestServiceAsync testSvc = GWT.create(AdminTestService.class);
	public String testRelativeURL = Environment.urlParam + "/TestServlet";

	public AdminRemoteServiceAsync adminSvc = GWT.create(AdminRemoteService.class);
	public String adminRelativeURL = Environment.urlParam + "/AdminServlet";

	public AdvertiserRemoteServiceAsync advertiserSvc = GWT.create(AdvertiserRemoteService.class);
	public String advertiserRelativeURL = Environment.urlParam + "/AdvertiserServlet";
	
	public MemberRemoteServiceAsync memberSvc = GWT.create(MemberRemoteService.class);
	public String memberRelativeURL = Environment.urlParam + "/MemberServlet";

	public ServiceDefTarget[] localAsynSvcLst = { (ServiceDefTarget) testSvc, (ServiceDefTarget) adminSvc, (ServiceDefTarget) advertiserSvc ,(ServiceDefTarget) memberSvc};

	public String[] localRelativeURLLst = { testRelativeURL, adminRelativeURL, advertiserRelativeURL ,memberRelativeURL};
}
