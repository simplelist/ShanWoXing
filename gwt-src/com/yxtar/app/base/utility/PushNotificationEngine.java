package com.yxtar.app.base.utility;

/**
 * PushNotificationEngine interface is used for hidden push logic between apple and android device
 * @author jimmylo
 *
 */
public interface PushNotificationEngine {

	/**
	 * method for setting up the notification handler
	 * @param handler
	 */
	public void setPushNotificationHandler(PushNotificationHandler handler);
	
	/**
	 * method to register the APP for push notification
	 */
	public void register();
}
