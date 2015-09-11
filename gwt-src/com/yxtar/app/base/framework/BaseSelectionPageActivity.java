package com.yxtar.app.base.framework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yxtar.app.base.widget.SystemMsgType;

public abstract class BaseSelectionPageActivity extends AbstractActivity implements SelectionPageView.Presenter {

	public SelectionPageView view;
	private boolean multipleSelectionFlag; // true for multiple selection
	public CommenClientFactory clientFactory;
	protected Object object;

	public abstract void start(AcceptsOneWidget panel, EventBus eventBus);

	public BaseSelectionPageActivity(CommenClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public void initialize() {
		this.view = this.getView();
		this.view.initialize();
		this.view.setPresenter(this);
	}

	public void setInitSearchMap(Object obj) {
		this.object = obj;
	}

	public Object getInitSearchMap() {
		return this.object;
	}

	public abstract SelectionPageView getView();

	public void setSelectionPageEventHandler(SelectionPageEventHandler handler) {
		this.view.setSelectionPageEventHandler(handler);
	}

	/**
	 * implements this function use asynProcesser to get data set data list to
	 * view by calling view.setDisplayData(….) set total number of page by
	 * calling view.setTotalNumOfPage(….) call this.view.refresh(); after all
	 * processes completed
	 */
	public abstract void search(final Object dataObj, final int maxResults, final int pageIndex);

	public void setMultipleSelectonFlag(boolean multipleSelectionFlag) {
		this.multipleSelectionFlag = multipleSelectionFlag;
	};

	public boolean getMultipleSelectonFlag() {
		return multipleSelectionFlag;
	}

	@Override
	public void loadingShow() {
		clientFactory.getLoadingSystemMsgView().show();
	}

	@Override
	public void loadingHide() {
		clientFactory.getLoadingSystemMsgView().hide();
	}

	@Override
	public void alert(SystemMsgType type, String msg) {
		clientFactory.getTxtSystemMsgView().showMsg(type, msg);
	}

	/**
	 * remove the double date from the list
	 * 
	 * @param selectedObjLst
	 * @return ArrayList
	 */
	public ArrayList removeDuplicate(List<Object> selectedObjLst) {
		// delete the double data in the List;
		return new ArrayList(new HashSet(selectedObjLst));
	}
}
