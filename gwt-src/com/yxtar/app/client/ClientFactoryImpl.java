/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.yxtar.app.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.yxtar.app.base.environment.SystemParams;
import com.yxtar.app.base.framework.CommenClientFactory;
import com.yxtar.app.base.framework.CommenClientFactoryImpl;
import com.yxtar.app.client.activity.SystemEngine;
import com.yxtar.app.client.ui.HomeView;
import com.yxtar.app.client.ui.HomeViewImpl;
import com.yxtar.app.client.ui.UserEditView;
import com.yxtar.app.client.ui.UserEditViewImpl;
import com.yxtar.app.client.ui.UserView;
import com.yxtar.app.client.ui.UserViewImpl;
import com.yxtar.app.client.widget.Frame;
import com.yxtar.app.client.widget.Menu;

/**
 * @author Daniel Kurka
 * 
 */
public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;
	private SystemParams systemParams = new SystemParams();
	private HomeView homeView = new HomeViewImpl();
	private SystemEngine systemEngine;
	private ClientRpcRequestor clientRpcRequestor; 
	private Frame frame = null;
	private Menu menu;
	private CommenClientFactory commenClientFactory;
	private UserView userView;
	private UserEditView userEditView;
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
		systemEngine = new SystemEngine(this);
		clientRpcRequestor=new ClientRpcRequestor();
		userView = new UserViewImpl();
		userEditView = new UserEditViewImpl(systemParams);
		commenClientFactory = new CommenClientFactoryImpl();
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public HomeView getHomeView() {
		// TODO Auto-generated method stub
		return this.homeView;
	}

	@Override
	public SystemParams getSystemParams() {
		// TODO Auto-generated method stub
		return this.systemParams;
	}

	@Override
	public SystemEngine getSystemEngine() {
		// TODO Auto-generated method stub
		return this.systemEngine;
	}

	@Override
	public ClientRpcRequestor getClientRpcRequestor() {
		return this.clientRpcRequestor;
	}

	@Override
	public void setFrame(Frame app) {
		this.frame = app;
		menu = frame.getMenu();
	}

	@Override
	public Frame getFrame() {
		return this.frame;
	}

	@Override
	public Menu getMenu() {
		return this.menu;
	}

	@Override
	public UserView getUserView() {
		return this.userView;
	}

	@Override
	public UserEditView getUserEditView() {
		return this.userEditView;
	}

	@Override
	public CommenClientFactory getCommenClientFactory() {
		return this.commenClientFactory;
	}


}
