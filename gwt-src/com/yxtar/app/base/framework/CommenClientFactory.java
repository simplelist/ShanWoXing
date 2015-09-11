package com.yxtar.app.base.framework;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.yxtar.app.base.activity.BaseRPCEngine;
import com.yxtar.app.base.widget.SystemMsgView;

public interface CommenClientFactory {

	public EventBus getEventBus();

	public PlaceController getPlaceController();

	public BaseRPCEngine getBaseRPCEngine();

	public SystemMsgView getTxtSystemMsgView();

	public SystemMsgView getLoadingSystemMsgView();

	public WidgetMapper getWidgetMapper();

}
