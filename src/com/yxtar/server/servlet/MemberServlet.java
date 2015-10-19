package com.yxtar.server.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yxtar.app.base.model.map.MemberMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.client.MemberRemoteService;
import com.yxtar.server.service.MemberService;
import com.yxtar.server.util.List2ListResultMap;

@Component("MemberServlet")
public class MemberServlet extends RemoteServiceServlet implements MemberRemoteService {

	@Autowired
	private MemberService memberService;
	private List2ListResultMap util = List2ListResultMap.getInstance();

	@Override
	public ListResultMap<MemberMap> getList(MemberMap map, int pageIndex, int maxResult) {
		return util.dtoToMap(memberService.getList());
	}

}
