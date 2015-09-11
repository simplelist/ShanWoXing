package com.yxtar.app.base.event;

import com.google.gwt.event.shared.EventHandler;

public interface FollowerMoveEventHandler extends EventHandler {
	/**
	 * FollowerMoveEvent event will be fired when StepPanel is translated 
	 * @param event FollowerMoveEvent event
	 */
  void onFollowerMoveEvent(FollowerMoveEvent event);
}
