package com.yxtar.app.client;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.rpc.RemoteService;
import com.yxtar.app.base.utility.ListResultMap;

public interface BaseRemoteService<M extends IsSerializable> extends RemoteService{
	ListResultMap<M> getList(M map,int pageIndex, int maxResult);
}
