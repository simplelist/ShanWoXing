package com.yxtar.server.push;

import java.io.InputStream;

import com.dbay.apns4j.IApnsService;
import com.dbay.apns4j.impl.ApnsServiceImpl;
import com.dbay.apns4j.model.ApnsConfig;
import com.dbay.apns4j.model.Payload;
import com.dbay.apns4j.model.PushNotification;
/**
 * Apple APNS 
 * @author JimmyLo
 * 
 */
public class IOSPushImpl implements PushInterface{

	private String appleP12File="";
	private String appleP12PSWD="";
	private boolean devFlag=true;
	private static IApnsService apnsService;
	private static IApnsService getApnsService(String appleP12File, String appleP12PSWD, boolean devFlag){
		if (apnsService == null) {
			ApnsConfig config = new ApnsConfig();
			InputStream is = IOSPushImpl.class.getClassLoader().getResourceAsStream(appleP12File);
			config.setKeyStore(is);
			config.setDevEnv(devFlag);
			config.setPassword(appleP12PSWD);
			config.setPoolSize(3);
			// 假如需要在同个java进程里给不同APP发送通知，那就需要设置为不同的name
			apnsService = ApnsServiceImpl.createInstance(config);
		}
		return apnsService;
	}

	public boolean sendMessageWithToken(String title, String body, String parm, String token) {
		try {
			IApnsService service = getApnsService(this.appleP12File, this.appleP12PSWD, this.devFlag);
			Payload payload = new Payload();
			payload.setAlert(body);
			payload.setBadge(1);

			//payload.setSound("msg.mp3");
//			payload.addParam("uid", 123456);
//			payload.addParam("type", 12);
			service.sendNotification(token, payload);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean sendMessage(String title, String body, String parm) {
		return true;
	}

	public String getAppleP12File() {
		return appleP12File;
	}

	public void setAppleP12File(String appleP12File) {
		this.appleP12File = appleP12File;
	}

	public String getAppleP12PSWD() {
		return appleP12PSWD;
	}

	public void setAppleP12PSWD(String appleP12PSWD) {
		this.appleP12PSWD = appleP12PSWD;
	}

	public boolean isDevFlag() {
		return devFlag;
	}

	public void setDevFlag(boolean devFlag) {
		this.devFlag = devFlag;
	}


	
	

	
}
