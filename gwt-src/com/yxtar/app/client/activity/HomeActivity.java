package com.yxtar.app.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yxtar.app.base.model.map.AdminMap;
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
//		getAll();
		getAdminList();
	}

	public void getAdminList(){
		clientFactory.getclientRpcRequestor().adminSvc.getAdminList(new AsyncCallback<ListResultMap<AdminMap>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ListResultMap<AdminMap> result) {
				// TODO Auto-generated method stub
				if (result!=null) {
					view.setAdminList(result);
				}
			}
		});
	}
	public void getAll() {
		clientFactory.getclientRpcRequestor().testSvc.getTestList(new AsyncCallback<List<TestCassandra>>() {

			@Override
			public void onSuccess(List<TestCassandra> result) {
//				view.setList(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getLocalizedMessage());
			}
		});
	}
}