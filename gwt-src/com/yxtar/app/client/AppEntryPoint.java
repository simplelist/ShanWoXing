package com.yxtar.app.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.widget.animation.AnimationWidget;
import com.yxtar.app.base.event.AsynProcEventHandler;
import com.yxtar.app.client.activity.SystemEngine;
import com.yxtar.app.client.mvp.AppPlaceHistoryMapper;
import com.yxtar.app.client.mvp.PhoneActivityMapper;
import com.yxtar.app.client.mvp.PhoneAnimationMapper;
import com.yxtar.app.client.place.HomePlace;


public class AppEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		// TODO Auto-generated method stub
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				//TODO put in your own meaninful handler
				Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();

			}
		});

		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);
	}

	private void start() {

		// setting used for mobile app
		/*
		//set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());
		 */	
			
		// setting used for mobile web
		// set viewport and other settings 
		ViewPort viewPort = new MGWTSettings.ViewPort();
		//configure view port
		viewPort.setMinimumScale(0.2).setInitialScale(1.0).setMaximumScale(5).setUserScaleAble(true);

		//create settings and set view port
		MGWTSettings settings = new MGWTSettings();
		settings.setViewPort(viewPort);

		//apply the setting e.g. create meta tag in page
		MGWT.applySettings(settings);


		final ClientFactory clientFactory = new ClientFactoryImpl();

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new HomePlace());
		 if(Window.Navigator.getUserAgent().indexOf("Safari") == -1&& Window.Navigator.getUserAgent().indexOf("Chrome") == -1){
				createIEDisplay(clientFactory);
			}else{
				createPhoneDisplay(clientFactory);
			}
		 historyHandler.handleCurrentHistory();
		 SystemEngine systemEngine = clientFactory.getSystemEngine();
		    systemEngine.setSystemInitializeHandler(new AsynProcEventHandler() {

		      @Override
		      public void onProcCompleted() {

		    	  if(Window.Navigator.getUserAgent().indexOf("Safari") == -1&& Window.Navigator.getUserAgent().indexOf("Chrome") == -1){
						createIEDisplay(clientFactory);
					}else{
						createPhoneDisplay(clientFactory);
					}
		        historyHandler.handleCurrentHistory();
		      }

		      @Override
		      public void onReportProgress(int percentage) {
		        // handle progress bar here
		        // Window.alert("processing "+percentage+" %");
		      }

		      @Override
		      public void onProcFail(String errMsg) {
		        if (errMsg.isEmpty()) {
		          Window.alert("System initialization fail, please contact administrator. Thank you.");
		        } else {
		          Window.alert(errMsg);
		        }
		      }

		    });
//		    systemEngine.initialize();

	}

	private void createPhoneDisplay(ClientFactory clientFactory) {
		AnimationWidget display = new AnimationWidget();
		PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);
		PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();
		AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper, appAnimationMapper, clientFactory.getEventBus());
		activityManager.setDisplay(display);
		RootPanel.get("home").add(display);

	}
	
	private void createIEDisplay(ClientFactory clientFactory) {

		PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);
		SimplePanel display= new SimplePanel();
		ActivityManager activityManager = new ActivityManager(appActivityMapper, clientFactory.getEventBus());
		activityManager.setDisplay(display);
		RootPanel.get("home").add(display);

	}

}
