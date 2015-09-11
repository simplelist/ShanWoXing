package com.yxtar.app.base.environment;

import com.google.gwt.core.shared.GWT;

/**
 * system parameter object,include machine parameter, view setting
 * parameter,internationalization object
 * @author wufeng
 * 
 */
public class SystemParams {
  
  private static SystemConstants constants =GWT.create(SystemConstants.class);

  public SystemConstants getConstants() {
    return constants;
  }

}