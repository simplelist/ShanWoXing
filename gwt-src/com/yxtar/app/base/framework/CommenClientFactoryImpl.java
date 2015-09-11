package com.yxtar.app.base.framework;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.yxtar.app.base.activity.BaseRPCEngine;
import com.yxtar.app.base.widget.LoadingSystemMsgViewImpl;
import com.yxtar.app.base.widget.SystemMsgView;
import com.yxtar.app.base.widget.TxtSystemMsgViewImpl;

public class CommenClientFactoryImpl implements CommenClientFactory {
	private EventBus eventBus;
	private PlaceController placeController;
	private BaseRPCEngine baseRPCEngine;
	private WidgetMapper widgetMapper;
	private SystemMsgView txtSystemMsgView = new TxtSystemMsgViewImpl();
	private SystemMsgView loadingSystemMsgView = new LoadingSystemMsgViewImpl();

	public CommenClientFactoryImpl() {
		super();
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
		baseRPCEngine = new BaseRPCEngine();
		widgetMapper = new WidgetMapper(this);
	}

	@Override
	public BaseRPCEngine getBaseRPCEngine() {
		return this.baseRPCEngine;
	}

	@Override
	public WidgetMapper getWidgetMapper() {
		return this.widgetMapper;
	}

	@Override
	public SystemMsgView getTxtSystemMsgView() {
		return this.txtSystemMsgView;
	}

	@Override
	public SystemMsgView getLoadingSystemMsgView() {
		return this.loadingSystemMsgView;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

}
