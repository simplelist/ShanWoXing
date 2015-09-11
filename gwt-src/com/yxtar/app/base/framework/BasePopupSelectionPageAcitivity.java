package com.yxtar.app.base.framework;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
/**
 * popup widget activity
 * @author jackshi
 *
 */
public abstract class BasePopupSelectionPageAcitivity extends BaseSelectionPageActivity implements PopupSelectionPageView.Presenter {

	public BasePopupSelectionPageAcitivity(CommenClientFactory clientFactory) {
		super(clientFactory);
	}

	public SelectionPageEventHandler handler;

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.start();
	}

	public void start() {
		((PopupSelectionPageView) this.view).show();
		this.search(object, view.getMaxResultPerPage(), 1);
	}

	public void setSelectionPageEventHandler(SelectionPageEventHandler handler) {
		this.handler = handler;
	}

	@Override
	public void confirmSelection(List<Object> selectedObjLst) {
		handler.onSelected(removeDuplicate(selectedObjLst));
	};

	@Override
	public void cancel() {
		((PopupSelectionPageView) this.view).close();
	}
}
