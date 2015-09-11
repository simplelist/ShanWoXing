package com.yxtar.app.base.framework;

public interface PopupSelectionPageView extends SelectionPageView {
	public interface Presenter {
		public void cancel();
	}

	public void show();

	public void close();

}
