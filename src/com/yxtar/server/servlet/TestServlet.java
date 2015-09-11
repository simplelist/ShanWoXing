package com.yxtar.server.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yxtar.app.client.AdminTestService;
import com.yxtar.app.shared.TestCassandra;
import com.yxtar.server.service.TestCassandraService;

@Component("TestServlet")
public class TestServlet extends RemoteServiceServlet implements AdminTestService {

	@Autowired
	private TestCassandraService testCassandraService;

	@Override
	public List<TestCassandra> getTestList() {
		List<TestCassandra> list = testCassandraService.findAll();
		if (list == null) {
			return null;
		}
		return list;
	}
}
