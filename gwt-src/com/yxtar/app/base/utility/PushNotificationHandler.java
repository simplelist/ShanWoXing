package com.yxtar.app.base.utility;

/**
 * Interface for handling all push notification event
 * @author jimmylo
 *
 */
public interface PushNotificationHandler {
	/**
	 * call when token(key) is created after APP push registeration
	 * @param token
	 */
	public void onTokenReceived(String token);

	/**
	 * call when registeration fail and occur error
	 * @param error
	 */
	public void onErrorReceived(String error);
	
	/**
	 * for apple push notication sound handling
	 * there is a sound information in payload 
	 */
	public void playSound(String event);
	
	/**
	 * will be call when notification received
	 * @param event
	 */
	public void processNotification(String event);
}
