package com.yxtar.app.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ListResultMap;

/**
 * The client side stub for the RPC service.
 */
public interface AdminRemoteService extends RemoteService {

	ListResultMap<AdminMap> getAdminList();
}
