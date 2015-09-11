package com.yxtar.app.base.widget;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;

/**
 * ProtectGlass is a glass panel from protected whole screen
 * 
 * @author Jimmy Lo
 */
public class ProtectGlass extends AutoRecalPopupPanel {
	public ProtectGlass(){
		super(true, false);
		this.setStyleName("glass-panel");
	}
	
	  /**
	   * method for enabling protective glass panel to handle scrolling and window resizing problem
	   */
	@Override
	protected void enableScrollWithBroswer(){
		//recalculate popup panel position
		Window.addResizeHandler(new ResizeHandler() {

			Timer resizeTimer = new Timer() {  
				@Override
				public void run() {
					setPopupPosition(getLeft()+Window.getScrollLeft() , getTop()+Window.getScrollTop());
				}
			};

			@Override
			public void onResize(ResizeEvent event) {
				resizeTimer.cancel();
				resizeTimer.schedule(250/2);
			}
		});
				
		Window.addWindowScrollHandler(new ScrollHandler(){
			
			Timer resizeTimer = new Timer() {  
				@Override
				public void run() {
					setPopupPosition(getLeft()+Window.getScrollLeft() , getTop()+Window.getScrollTop());
				}
			};
			@Override
			public void onWindowScroll(ScrollEvent arg0) {
				// TODO Auto-generated method stub
				resizeTimer.cancel();
				resizeTimer.schedule(20);
			}
			
		});
	}

}
