package com.yxtar.app.base.ui;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Interface for standardize UI view/object  
 * @author jimmylo
 *
 */
public interface UIObjectLifeCycle extends IsWidget{
	
	/**
	 * method to initialize the widget
	 * e.g. clear textbox content, calling sub-widget's initialize
	 */
	public void initialize();
	
	/**
	 * method for refreshing the widget, usually called for loading and displaying data
	 */
	public void refresh();
	
	/**
	 * method for updating the data model object from screen data
	 */
	public void update();
	
	/**
	 * method called when widget is detached
	 */
	public void destroy();
}
