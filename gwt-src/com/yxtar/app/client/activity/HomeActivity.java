package com.yxtar.app.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.app.base.model.map.MemberMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.client.ClientFactory;
import com.yxtar.app.client.place.HomePlace;
import com.yxtar.app.client.ui.HomeView;
import com.yxtar.app.shared.TestCassandra;

public class HomeActivity extends AbstractActivity {
	private ClientFactory clientFactory;
	private HomeView view;

	public HomeActivity(HomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		view = clientFactory.getHomeView();
		containerWidget.setWidget(view.asWidget());
		getAdminList();
		getMemberList();
	}

	private void getMemberList() {
		clientFactory.getClientRpcRequestor().memberSvc.getList(null, 1, 10, new AsyncCallback<ListResultMap<MemberMap>>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(ListResultMap<MemberMap> result) {
				Window.alert(result.getCount()+""+result.getDataList().get(0).getNickName());
			}
		});
	}

	public void getAdminList() {
		clientFactory.getClientRpcRequestor().adminSvc.getList(null, 1, 10, new AsyncCallback<ListResultMap<AdminMap>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ListResultMap<AdminMap> result) {
				if (result != null) {
					view.setAdminList(result);
				}
			}
		});
//		clientFactory.getClientRpcRequestor().adminSvc.getList(null, 1, 10, new AsyncCallback<ListResultMap>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				
//			}
//
//			@Override
//			public void onSuccess(ListResultMap result) {
//				if (result != null) {
//					view.setAdminList(result);
//				}
//			}
//		});
	}

}