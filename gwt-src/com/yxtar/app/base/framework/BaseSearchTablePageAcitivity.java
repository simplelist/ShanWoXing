package com.yxtar.app.base.framework;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * search map,result show UI
 * 
 * @author jackshi
 * 
 */
public abstract class BaseSearchTablePageAcitivity extends BaseSelectionPageActivity implements SearchTablePageView.Presenter {
	public SelectionPageEventHandler handler;

	public abstract void delete(List<Object> deleteList);

	public BaseSearchTablePageAcitivity(CommenClientFactory factory) {
		super(factory);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.start();
	}

	public void start() {
		this.search(object, view.getMaxResultPerPage(), view.getPageIndex());
	}

	public void confirmSelection(List<Object> selectedObjLst) {
		// determine to see if edit mode or not, process delete or edit
		delete(removeDuplicate(selectedObjLst));
	};

	public void setSelectionPageEventHandler(SelectionPageEventHandler selectionPageEventHandler) {
		this.handler = selectionPageEventHandler;
	}
}
