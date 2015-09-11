package com.yxtar.app.base.widget;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.PopupPanel;

public class FixPopupPanel extends PopupPanel{
	private boolean flag = true;
	public FixPopupPanel(boolean flag,boolean flg){
		super(false, true);
		this.flag = flag;
		if(flag){
			this.setStyleName("glass");
			this.getElement().setAttribute("style", "min-width: 1024px;position:fixed;");
			if(flg){
				this.setAnimationEnabled(true);
			}
			
		}else{
			this.removeStyleName("gwt-PopupPanel");
			this.getElement().setAttribute("style", "left: 0px; top: 197px; position: fixed; overflow: visible;width: 100%;min-width: 1024px;");
		}
	}
	

	public void shows(){
		this.show();
		this.getElement().getStyle().setPosition(Position.FIXED);
		if(!flag){
			this.center();
			this.getElement().getStyle().setTop(150, Unit.PX);
		} 
	}

	public void hides(){
		this.hide();
	}

}
