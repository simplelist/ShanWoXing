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
import com.yxtar.app.base.environment.SystemParams;
import com.yxtar.app.base.framework.CommenClientFactory;
import com.yxtar.app.client.activity.SystemEngine;
import com.yxtar.app.client.ui.HomeView;
import com.yxtar.app.client.ui.UserEditView;
import com.yxtar.app.client.ui.UserView;
import com.yxtar.app.client.widget.Frame;
import com.yxtar.app.client.widget.Menu;

public interface ClientFactory {

	public EventBus getEventBus();

	public ClientRpcRequestor getClientRpcRequestor();

	public PlaceController getPlaceController();

	public HomeView getHomeView();

	public SystemParams getSystemParams();

	public SystemEngine getSystemEngine();

	public void setFrame(Frame app);

	public Frame getFrame();

	public Menu getMenu();

	public UserView getUserView();

	public UserEditView getUserEditView();

	public CommenClientFactory getCommenClientFactory();


}
