package com.yxtar.server.gwt;

import javax.servlet.http.HttpServletRequest;

public interface IRequestAware {
  
  void setServletRequest(HttpServletRequest request); 

}
