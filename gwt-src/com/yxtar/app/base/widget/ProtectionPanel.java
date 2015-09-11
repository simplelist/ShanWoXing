package com.yxtar.app.base.widget;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * ProtectionPanel extend FlowPanel, with a protection glass layer to protect child widget from user click
 * @author jimmylo
 *
 */
public class ProtectionPanel extends FlowPanel   {

	private SimplePanel protectGlass;

	/**
	 * true for protecting
	 */
	private boolean isProtectedFlg = true;

	/**
	 * constructor
	 */
	public ProtectionPanel(){
		this.getElement().getStyle().setOverflow(Overflow.VISIBLE);

		this.protectGlass = new SimplePanel();
		this.protectGlass.getElement().getStyle().setPosition(Position.RELATIVE);
		this.protectGlass.getElement().getStyle().setLeft(0, Unit.PX);
	}
	
	/**
	 * constructor
	 * @param protectColor - color of protection layer
	 * @param protectOpacity - opacity of protection layer
	 */
	public ProtectionPanel(String protectColor, double protectOpacity){
		this.getElement().getStyle().setOverflow(Overflow.VISIBLE);

		this.protectGlass = new SimplePanel();
		this.protectGlass.getElement().getStyle().setPosition(Position.RELATIVE);
		this.protectGlass.getElement().getStyle().setLeft(0, Unit.PX);
		this.protectGlass.getElement().getStyle().setBackgroundColor(protectColor);
		this.protectGlass.getElement().getStyle().setOpacity(protectOpacity);
	}

	/** 
	 * return the protect glass object
	 */
	public SimplePanel getProtectGlass(){
		return this.protectGlass; 
	}

	/**
	 * set up panel size so that it know the protection area
	 * @param width - panel width in px
	 * @param height - panel height in px
	 */
	public void setSize(int width, int height) {
		this.setSize(width+Unit.PX.toString(), height+Unit.PX.toString());
		this.protectGlass.getElement().getStyle().setWidth(width, Unit.PX);
		this.protectGlass.getElement().getStyle().setHeight(height, Unit.PX);
	}

	public void  setProtectedGrassTop(int top) {
    this.protectGlass.getElement().getStyle().setTop(-1*top, Unit.PX);
  }

  public void  setProtectedGrassTop(String top) {
    this.protectGlass.getElement().getStyle().setProperty("top", top);
  }
	/**
	 * 
	 * @return return true if protection enabled; false otherwise
	 */
	public boolean isProtected(){
		return this.isProtectedFlg;
	}

	/**
	 * to enable or disable protection
	 * @param protectFlg - true to enable protection; false otherwise
	 */
	public void setProtected(boolean protectFlg){
		this.isProtectedFlg = protectFlg;
		this.protectGlass.setVisible(this.isProtectedFlg);
	}

	/**
	 * method to add widget to ProtectionPanel
	 */
	@Override
	public void add(Widget widget){
		if(this.protectGlass.getParent()!= null){
			this.protectGlass.removeFromParent();
		}
		super.add(widget);
		super.add(this.protectGlass);
	}

	
}
