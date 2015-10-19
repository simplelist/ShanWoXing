package com.yxtar.app.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yxtar.app.base.event.AsynProcEventHandler;
import com.yxtar.app.base.framework.BaseSearchTablePageAcitivity;
import com.yxtar.app.base.framework.BaseSearchTablePageViewImpl;
import com.yxtar.app.base.framework.SearchTablePageView.Presenter;
import com.yxtar.app.base.framework.SelectionPageView;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.AsynProcesser;
import com.yxtar.app.base.utility.AsynProcesser.AsynProc;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.base.widget.SystemMsgType;
import com.yxtar.app.client.ClientFactory;
import com.yxtar.app.client.ClientRpcRequestor;
import com.yxtar.app.client.place.UserEditPlace;
import com.yxtar.app.client.place.UserPlace;
import com.yxtar.app.client.ui.UserView;

public class UserActivity extends BaseSearchTablePageAcitivity implements Presenter {

	private UserView userView;
	private ClientRpcRequestor requestor;
	private ClientFactory factory;

	public UserActivity(UserPlace place, ClientFactory clientFactory) {
		super(clientFactory.getCommenClientFactory());
		requestor = clientFactory.getClientRpcRequestor();
		factory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		userView = factory.getUserView();
		panel.setWidget(userView.asWidget());
		userView.setPresenter(this);
		search((AdminMap) ((BaseSearchTablePageViewImpl) userView).getSearchObject(), userView.getMaxResultPerPage(), userView.getPageIndex());
	}

	@Override
	public SelectionPageView getView() {
		return this.userView;
	}

	@Override
	public void goTo(Place place) {
		factory.getPlaceController().goTo(place);
	}

	@Override
	public void onEdit(Object dataObj) {
		if (dataObj != null) {
			if (dataObj instanceof AdminMap) {
				if (((AdminMap) dataObj).getId() != null) {
					goTo(new UserEditPlace(Integer.valueOf(((AdminMap) dataObj).getId())));
				}
			}
		} else {
			goTo(new UserEditPlace(null));
		}
	}

	@Override
	public void delete(List<Object> deleteList) {
		loadingShow();
		ArrayList<String> list = new ArrayList<String>();
		if (deleteList != null && deleteList.size() > 0) {
			for (Object o : deleteList) {
				list.add(((AdminMap) o).getId() + "");
			}
		}
//		if (list.size() > 0) {
//			requestor.adminSvc.delete(list, new AsyncCallback<Void>() {
//
//				@Override
//				public void onFailure(Throwable caught) {
//					loadingHide();
//					alert(SystemMsgType.Error, caught.getLocalizedMessage());
//					((BaseSearchTablePageViewImpl) userView).initializeImpl();
//					search(null, userView.getMaxResultPerPage(), 1);
//				}
//
//				@Override
//				public void onSuccess(Void result) {
//					loadingHide();
//					((BaseSearchTablePageViewImpl) userView).initializeImpl();
//					search(null, userView.getMaxResultPerPage(), 1);
//				}
//			});
//		} else {
//			((BaseSearchTablePageViewImpl) userView).initializeImpl();
//			search(null, userView.getMaxResultPerPage(), 1);
//		}
	}

	@Override
	public void search(final Object dataObj, final int maxResults, final int pageIndex) {
		// use asynprocesser to get data
		// set data list to view by calling view.setDisplayData(….)
		// set total number of page by calling view.setTotalNumOfPage(….)
		// call this.view.refresh(); after all processes completed
		if (getInitSearchMap() instanceof AdminMap && dataObj instanceof AdminMap) {
			// ((AdminMap)dataObj).setUserState(((AdminMap)getInitSearchMap()).getUserState());
		}
		final AsynProcesser processer = new AsynProcesser();
		loadingShow();
		
		processer.addAsynProc(new AsynProc() {

			@Override
			public void proccess() {
				requestor.adminSvc.getList((AdminMap) dataObj, pageIndex, maxResults, new AsyncCallback<ListResultMap<AdminMap>>() {

					@Override
					public void onFailure(Throwable caught) {
						processer.onProcFail("error" + caught.getLocalizedMessage());
					}

					@Override
					public void onSuccess(ListResultMap<AdminMap> result) {
						List<Object> list = new ArrayList<Object>();
						if (result != null) {
							for (AdminMap sMap : result.getDataList()) {
								list.add(sMap);
							}
						}
						userView.setDisplayData(list);
						processer.onProcCompleted();
					}
				});
			}
		});
		processer.setAsynProcEventHandler(new AsynProcEventHandler() {

			@Override
			public void onReportProgress(int percentage) {

			}

			@Override
			public void onProcFail(String errMsg) {
				loadingHide();
				alert(SystemMsgType.Error, errMsg);
			}

			@Override
			public void onProcCompleted() {
				loadingHide();
				userView.refresh();
			}
		});
		processer.startAsynProc(60000);

	}

}
