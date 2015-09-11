package com.yxtar.app.base.utility;



/**
 * 
 * @author wufeng This is a class for android push notification need to install
 *         phonegap push plugin 'PushNotification' -
 *         com.cmpsoft.mobile.plugin.pushnotification.PushNotification
 */
public class BaiduPushEngine implements PushNotificationEngine {

	private static PushNotificationHandler handler;

	public BaiduPushEngine() {
		addDeviceReadyEvent();
	}
	
	public BaiduPushEngine(PushNotificationHandler handler1) {
		handler = handler1;
		addDeviceReadyEvent();
	}

	public native void addDeviceReadyEvent()/*-{
		
		function success(info) {
			if (info) {
				
				var retData = eval("(" + info + ")");
				
				if (typeof retData == 'undefined')
					return;

				if (typeof retData.type == 'undefined')
					return;
				//获得推送的基础数据
				if (retData.type == 0) {
                   @com.yxtar.app.base.utility.BaiduPushEngine::baseMsg(Ljava/lang/String;)(retData.user_id+';'+retData.channel_id);
					//通知服务
				} else if (retData.type == 1) {
					var msg = eval("(" + retData.msg + ")");
                   @com.yxtar.app.base.utility.BaiduPushEngine::notify(Ljava/lang/String;)(retData.msg);
					//消息服务
				} else if (retData.type == 2) {
					var msg = eval("(" + retData.msg + ")");
                     @com.yxtar.app.base.utility.BaiduPushEngine::receivedMsg(Ljava/lang/String;)(retData.msg);
				}
			}
		}

		function failure(error) {
           alert('android baidu push failure ');
		}
		
		$wnd.push_success=success;
		
		$wnd.push_failure=failure;
		
		//初始化插件
		function initPushPlugin() {
			$wnd.fastgoPushNotification.initialize("iDpZqHUaFSoGx4dDSLtj3dTz",
					success, failure);
		}
		$doc.addEventListener('deviceready', initPushPlugin, false);
	}-*/;

	public native void register()/*-{
//		 try
//		    {	
//		        $doc.addEventListener('notifyReceived', this.@com.yxtar.app.base.utility.BaiduPushEngine::notify(Ljava/lang/String;), false);
//		        $doc.addEventListener('msgReceived', this.@com.yxtar.app.base.utility.BaiduPushEngine::receivedMsg(Ljava/lang/String;), false);
//		        $doc.addEventListener('basePushData', this.@com.yxtar.app.base.utility.BaiduPushEngine::baseMsg(Ljava/lang/String;), false);
//		        $doc.addEventListener('basePushDataFailure', this.@com.yxtar.app.base.utility.BaiduPushEngine::errorHandler(Ljava/lang/String;), false);
//		    }
//		  
//		    catch(err)
//		    {
//		    	txt="There was an error on this page.\n\n";
//		        txt+="Error description: " + err.message + "\n\n";
//		        $wnd.alert(txt);
//		    }
	}-*/;

	/**
	 * 接收到消息
	 * @param token
	 */
	public static void receivedMsg(String msg) {
		handler.processNotification(msg);
	}
    
	/**
	 * 出现错误
	 * @param error
	 */
	public static void errorHandler(String error) {
		handler.onErrorReceived(error);
	}
   
	/**
	 * 接收到token
	 * @param event
	 */
	public static void baseMsg(String event) {
		handler.onTokenReceived(event);
	}
    
	/**
	 * 接收到通知
	 * @param notify
	 */
	public static void notify(String notify) {
		handler.processNotification(notify);
	}
	
	/**
	 * 设置消息处理者
	 */
	public void setPushNotificationHandler(PushNotificationHandler handlers) {
		handler = handlers;
	}

}
