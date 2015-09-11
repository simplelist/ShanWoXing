package com.yxtar.app.base.utility;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
/**
 * 
 * @author jimmylo
 *	This is a class for apple push notification
 *	need to install phonegap push plugin 'PushPlugin' - com.phonegap.plugins.PushPlugin
 */
public class APNSEngine implements PushNotificationEngine{

	private static PushNotificationHandler handler;
	public APNSEngine(){
	}
	
	public void setPushNotificationHandler(PushNotificationHandler handlers){
		handler = handlers;
	}
	
	public PushNotificationHandler getAPNSNotificationHandler(){
		return handler;
	}
	
	public void register(){
		if(PhonegapUtil.isDeviceReady()){
			pushRegistration();
		}else{
			Timer t = new Timer(){
	
				@Override
				public void run() {
					
					if(!PhonegapUtil.isDeviceReady())
					{
						pushRegistration();	
					}
				}
				
			};
			t.schedule(1000);
		}
	}

	/**
	 * method to register the ios push 
	 */
	public native void pushRegistration() /*-{
	    try
	    {
	    	function onNotificationAPN(e) {
            
            	if (e.sound) {
	                // playing a sound also requires the org.apache.cordova.media plugin
	                this.@com.yxtar.app.base.utility.APNSEngine::playSound(Ljava/lang/String;)(e.sound);
	            }
	            
	            if (e.alert) {
	                alert('<li>push-notification: ' + e.alert + '</li>');
	                // showing an alert also requires the org.apache.cordova.dialogs plugin
	               // navigator.notification.alert(e.alert);
	               this.@com.yxtar.app.base.utility.APNSEngine::processNotification(Ljava/lang/String;)(e.alert);
	            }
	            
	            if (e.badge) {
	                $wnd.plugins.pushNotification.setApplicationIconBadgeNumber(successHandler, e.badge);
	            }
        	}
	    	$wnd.plugins.pushNotification.register(this.@com.yxtar.app.base.utility.APNSEngine::tokenHandler(Ljava/lang/String;), 
	    	this.@com.yxtar.app.base.utility.APNSEngine::errorHandler(Ljava/lang/String;), 
	    	{"badge":"true","sound":"true","alert":"true","ecb":"onNotificationAPN"});	// required!
	    }
	    catch(err)
	    {
	    	txt="There was an error on this page.\n\n";
	        txt+="Error description: " + err.message + "\n\n";
	        $wnd.alert(txt);
	    }
    }-*/;

	/**
	 * 
	 * @param token
	 */
	public void tokenHandler(String token){
		handler.onTokenReceived(token);
	}

	public void errorHandler(String error){
		handler.onErrorReceived(error);
	}
	
	public void playSound(String event){
		handler.playSound(event);
	}
	 
	public void processNotification(String event){
		handler.processNotification(event);
	}
	
}
