package com.yxtar.app.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ListResultMap;

public interface AdminRemoteServiceAsync {

	void getAdminList(AsyncCallback<ListResultMap<AdminMap>> callback);

}
