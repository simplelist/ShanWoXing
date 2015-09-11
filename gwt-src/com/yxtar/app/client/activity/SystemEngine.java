package com.yxtar.app.client.activity;

import com.google.gwt.storage.client.Storage;
import com.yxtar.app.base.activity.BaseSystemEngine;
import com.yxtar.app.base.event.AsynProcEventHandler;
import com.yxtar.app.base.utility.AsynProcesser;
import com.yxtar.app.base.utility.AsynProcesser.AsynProc;
import com.yxtar.app.client.ClientFactory;

/**
 * Class System is using for all system level logic which is not included in any activity.
 * @author jimmylo
 *
 */
public class SystemEngine extends BaseSystemEngine {

	private ClientFactory clientFactory;

	Storage storage = Storage.getLocalStorageIfSupported();
	
	public SystemEngine(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
	}
	
	public void initialize(){
		
		final AsynProcesser asynProcesser = new AsynProcesser();
		
		
		//set up event handler for notify other about the progress
		asynProcesser.setAsynProcEventHandler(new AsynProcEventHandler(){

			@Override
			public void onProcCompleted() {
				initializeCompleted();
			}

			@Override
			public void onProcFail(String errMsg) {
				initializeFail(errMsg);
				
			}

			@Override
			public void onReportProgress(int percentage) {
				initializeProgress(percentage);
			}
			
		});
		
		//start all the processes
		asynProcesser.startAsynProc(4000);
		
	}
	

}
