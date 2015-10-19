package com.yxtar.server.push;

import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;

/**
 *  getui android push 
 * @author jimmylo
 *
 */
public class GetuiPushImpl implements PushInterface{
	private String appId = "";
	private String appKey = "";
	private String master = "";

	static String host = "";


	private static IGtPush push;
	private static IGtPush getIGtPush(String master, String appKey){
		if(push == null){
			push = new IGtPush(host, appKey, master);
		}
		return push;
	}

	@Override
	public boolean sendMessage(String title, String body, String parm) {
		boolean successFlag = false;
		IGtPush push = this.getIGtPush(master, appKey);

		NotificationTemplate template = this.createNotificationMsgObj(title, body, parm, true, true);
		AppMessage message = new AppMessage();
		message.setData(template);

		message.setOffline(true);
		message.setOfflineExpireTime(24 * 1000 * 3600);

		List<String> appIdList = new ArrayList<String>();
		List<String> phoneTypeList = new ArrayList<String>();
		List<String> provinceList = new ArrayList<String>();
		List<String> tagList = new ArrayList<String>();

		appIdList.add(appId);


		message.setAppIdList(appIdList);

		//		 message.setPushNetWorkType(1);
		//		 message.setSpeed(1000);
		IPushResult ret = null;
		try{
			ret = push.pushMessageToApp(message,"任务别名_toApp");
			successFlag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		if(ret != null){
			System.out.println(ret.getResponse().toString());
			successFlag = true;
		}
		
		return successFlag;
	}

	@Override
	public boolean sendMessageWithToken(String title, String body, String parm, String token) {
		boolean successFlag = false;
		IGtPush push = getIGtPush(this.master, this.appKey);

		NotificationTemplate template = this.createNotificationMsgObj(title, body, parm, true, true);

		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		//离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setData(template);
		message.setPushNetWorkType(0); //可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		Target target = new Target();

		target.setAppId(appId);
		target.setClientId(token);

		IPushResult ret = null;
		try{
			ret = push.pushMessageToSingle(message, target);
			successFlag = true;
		}catch(RequestException e){
			e.printStackTrace();
			//resend if fail
			ret = push.pushMessageToSingle(message, target, e.getRequestId());
		}
		if(ret != null){
			System.out.println(ret.getResponse().toString());
			successFlag = true;
		}
		return successFlag;
	}

	/**
	 * create "NotificationTemplate" message obj
	 * 
	 * @param title
	 * @param body
	 * @param parm
	 * @param isRing 是否响铃
	 * @param isVibrate 是否震动
	 * @return
	 */
	private NotificationTemplate createNotificationMsgObj(String title, String body, String parm, boolean isRing, boolean isVibrate){
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(appId);
		template.setAppkey(appKey);
		// 设置通知栏标题与内容
		template.setTitle(title);
		template.setText(body);
		// 配置通知栏图标
		template.setLogo("icon.png");
		// 配置通知栏网络图标
		template.setLogoUrl("");
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(isRing);
		template.setIsVibrate(isVibrate);
		template.setIsClearable(true);
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(1);
		template.setTransmissionContent(parm);
		// 设置定时展示时间
		// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
		return template;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		GetuiPushImpl.host = host;
	}



}
