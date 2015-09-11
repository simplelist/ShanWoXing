package com.yxtar.app.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.yxtar.app.shared.TestCassandra;

public interface AdminTestServiceAsync {

	void getTestList(AsyncCallback<List<TestCassandra>> callback);

}
