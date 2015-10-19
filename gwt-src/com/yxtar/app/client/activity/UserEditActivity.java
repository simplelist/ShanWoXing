package com.yxtar.app.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.widget.SystemMsgType;
import com.yxtar.app.client.ClientFactory;
import com.yxtar.app.client.ClientRpcRequestor;
import com.yxtar.app.client.place.UserEditPlace;
import com.yxtar.app.client.place.UserPlace;
import com.yxtar.app.client.ui.UserEditView;
import com.yxtar.app.client.ui.UserEditView.Presenter;

;
public class UserEditActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private UserEditView userEditView;
	private ClientRpcRequestor requestor = null;
	private UserEditPlace place = null;

	public UserEditActivity(UserEditPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		this.requestor = clientFactory.getClientRpcRequestor();
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Integer id = null;
		userEditView = clientFactory.getUserEditView();
		panel.setWidget(userEditView.asWidget());
		userEditView.setPresenter(this);
		findById(id);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void update(AdminMap beans) {
//	
//		this.requestor.adminSvc.saveUser(beans, new AsyncCallback<Boolean>() {
//
//			@Override
//			public void onSuccess(Boolean result) {
//				if (result) {
//					alert(SystemMsgType.Info, clientFactory.getSystemParams().getConstants().saveSuccess()[1]);
//				}else {
//					alert(SystemMsgType.Error, clientFactory.getSystemParams().getConstants().saveFailure()[1]);
//				}
//				goTo(new UserPlace());
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				alert(SystemMsgType.Error, clientFactory.getSystemParams().getConstants().saveFailure()[1]);
//				goTo(new UserPlace());
//			}
//		});
	}

	@Override
	public void findById(Integer id) {
		userEditView.clearPageData();
//		if (id != null) {
//			this.requestor.adminSvc.findByUserId(id, new AsyncCallback<AdminMap>() {
//
//				@Override
//				public void onFailure(Throwable caught) {
//					alert(SystemMsgType.Error, caught.getLocalizedMessage());
//				}
//
//				@Override
//				public void onSuccess(AdminMap result) {
//					userEditView.setAdminMap(result);
//				}
//			});
//		} else {
//			AdminMap map = new AdminMap();
//			userEditView.setAdminMap(map);
//		}
	}

	@Override
	public void alert(SystemMsgType type, String msg) {
		clientFactory.getCommenClientFactory().getTxtSystemMsgView().showMsg(type, msg);
	}

}
