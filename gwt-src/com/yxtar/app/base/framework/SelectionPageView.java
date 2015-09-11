package com.yxtar.app.base.framework;

import java.util.List;

import com.yxtar.app.base.ui.UIObjectLifeCycle;
import com.yxtar.app.base.widget.SystemMsgType;


public interface SelectionPageView extends UIObjectLifeCycle {
	public interface Presenter {
		public void search(Object dataObj, int maxResults, int pageIndex);

		public void confirmSelection(List<Object> selectedObjLst);

		public void loadingShow();

		public void loadingHide();

		public void alert(SystemMsgType type, String msg);

	}

	public void setTotalNumOfPage(int totalNumOfPage);

	public void setCurrentPageIndex(int currentPageIndex);

	public void setDisplayData(List<Object> dataLst);

	public void setPresenter(SelectionPageView.Presenter presenter);
	
	public void setSelectionPageEventHandler(SelectionPageEventHandler handler);

	public void setMultipleSelectionFlag(boolean multipleSelectionFlag);

	public int getMaxResultPerPage();

	public int getPageIndex();

}
