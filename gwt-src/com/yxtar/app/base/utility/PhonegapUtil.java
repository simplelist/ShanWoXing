package com.yxtar.app.base.utility;

import com.google.gwt.user.client.Window;

public class PhonegapUtil {
	
	private static PhonegapEventHandler handler;
	private static boolean isDeviceReady = false;
	public PhonegapUtil(){
	}
	
	public static boolean isDeviceReady(){
		return isDeviceReady;
	}

	public native void addDeviceReadyEvent()/*-{
		try{
		 $doc.addEventListener('deviceready', this.@com.yxtar.app.base.utility.PhonegapUtil::onDeviceReady(), false);
		}catch(err){
			alert('errors=='+err);
		}
	}-*/;
	
	public void onDeviceReady(){
		if(handler!=null){
			isDeviceReady = true;
			handler.onDeviceReady();
		}else{
			Window.alert("null");
		}
	}
	
	public void setPhonegapEventHandler(PhonegapEventHandler handlerParm){
		handler = handlerParm;
	}
}
