package com.yxtar.app.client.ui;

import com.google.gwt.place.shared.Place;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.widget.SystemMsgType;

public interface UserEditView extends BaseView {
	public void setPresenter(Presenter presenter);

	// set the pictures object to this;
	public void setAdminMap(AdminMap bean);

	// set the data to the label;
	public interface Presenter {
		// go to other page;
		public void goTo(Place place);

		// update data;
		void update(AdminMap map);

		public void findById(Integer id);

		void alert(SystemMsgType type, String msg);
	}

}
