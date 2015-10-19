package com.yxtar.server.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.yxtar.server.push.PushInterface;

public class PushNotificationUtils {

	public enum PLATFORM{
		IOS("ios"), ANDROID("android");

		private String platform;
		
		PLATFORM(String platform){
			this.platform = platform;
		}

		public String getPlatform() {
			return platform;
		}

		public void setPlatform(String platform) {
			this.platform = platform;
		}
		
	}
	@Autowired
	private PushInterface iOSPush;
	@Autowired
	private PushInterface androidPush;

	private PushInterface selectPlatformPushInterface(PLATFORM platform){
		try{
			if(platform.equals(PLATFORM.IOS)){
				return this.iOSPush;
			}else if(platform.equals(PLATFORM.ANDROID)){
				return this.androidPush;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 定向发送消息
	 * @param content
	 * @param token
	 * @return
	 */
	public boolean sendMessageWithToken(PLATFORM platform,String title, String body, String parm, String token){
		boolean returnFlag = false;
		PushInterface push = this.selectPlatformPushInterface(platform);
		if(push != null){
			returnFlag = push.sendMessageWithToken(title, body, parm, token);
		}
		return returnFlag;
	}
	
	/**
	 * 定向发送消息
	 * support android only
	 * @param content
	 * @param token
	 * @return
	 */
	public boolean sendMessageToApp(PLATFORM platform,String title, String body, String parm){
		boolean returnFlag = false;
		PushInterface push = this.selectPlatformPushInterface(platform);
		if(push != null){
			returnFlag = push.sendMessage(title, body, parm);
		}
		return returnFlag;
	}




}
