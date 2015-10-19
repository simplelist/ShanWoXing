package com.yxtar.server.push;

/**
 * 发送消息接口
 * @author JimmyLo
 * 
 */
public interface PushInterface {

  /**
   * 广播 (for android) 
   * @param msg
   * @return
   */
  public boolean sendMessage(String title, String body, String parm);


  /**
   * 定向发送消息
   * @param content
   * @param token
   * @return
   */
  public boolean sendMessageWithToken(String title, String body, String parm, String token);

}
