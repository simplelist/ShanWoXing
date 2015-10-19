package com.yxtar.app.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.yxtar.app.base.utility.ListResultMap;


public interface BaseRemoteServiceAsync<M extends IsSerializable> {
	void getList(M map, int pageIndex, int maxResult, AsyncCallback<ListResultMap<M>> asyncCallback);
}
