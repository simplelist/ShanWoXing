package com.yxtar.app.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.yxtar.app.shared.TestCassandra;

/**
 * The client side stub for the RPC service.
 */
public interface AdminTestService extends RemoteService {

	List<TestCassandra> getTestList();
}
