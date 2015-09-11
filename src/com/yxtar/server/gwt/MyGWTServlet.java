package com.yxtar.server.gwt;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.spring4gwt.server.SpringGwtRemoteServiceServlet;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;

public class MyGWTServlet extends SpringGwtRemoteServiceServlet {
  
  @Override
  public String processCall(String payload) throws SerializationException {
    try {
      Object handler = getBean(getThreadLocalRequest());

      InterfaceUtil util = new InterfaceUtil();

      boolean flag = util.isInterface(handler.getClass(), IRequestAware.class.getName()); // 判断是否实现了IRequestAware接口
      if (flag) {// 如果实现了IRequestAware就进行HttpServletRequest注入
        java.lang.reflect.Method method = null;
        try {
          method = handler.getClass().getDeclaredMethod("setServletRequest", new Class[] { HttpServletRequest.class });
          method.invoke(handler, getThreadLocalRequest());

        } catch (NoSuchMethodException e) {
          e.printStackTrace();
        } catch (SecurityException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (IllegalArgumentException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        }
      }

      RPCRequest rpcRequest = RPC.decodeRequest(payload, handler.getClass(), this);
      onAfterRequestDeserialized(rpcRequest);
//      if (LOG.isDebugEnabled()) {
//        LOG.debug("Invoking " + handler.getClass().getName() + "." + rpcRequest.getMethod().getName());
//      }
      return RPC.invokeAndEncodeResponse(handler, rpcRequest.getMethod(), rpcRequest.getParameters(),
          rpcRequest.getSerializationPolicy());
    } catch (IncompatibleRemoteServiceException ex) {
      log("An IncompatibleRemoteServiceException was thrown while processing this call.", ex);
      return RPC.encodeResponseForFailure(null, ex);
    }

  }
}
