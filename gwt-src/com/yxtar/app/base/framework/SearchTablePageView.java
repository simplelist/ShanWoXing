package com.yxtar.app.base.framework;

import com.google.gwt.place.shared.Place;

public interface SearchTablePageView extends SelectionPageView {
	public interface Presenter extends SelectionPageView.Presenter {
		public void onEdit(Object dataObj);

		public void goTo(Place place);

	}
}
