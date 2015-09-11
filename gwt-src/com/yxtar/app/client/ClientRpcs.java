package com.yxtar.app.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.yxtar.app.base.environment.Environment;

public interface ClientRpcs {

	public AdminTestServiceAsync testSvc = GWT.create(AdminTestService.class);
	public String testRelativeURL = Environment.urlParam + "/TestServlet";

	public AdminRemoteServiceAsync adminSvc = GWT.create(AdminRemoteService.class);
	public String adminRelativeURL = Environment.urlParam + "/AdminServlet";

	public ServiceDefTarget[] localAsynSvcLst = { (ServiceDefTarget) testSvc, (ServiceDefTarget) adminSvc };

	public String[] localRelativeURLLst = { testRelativeURL, adminRelativeURL };
}
