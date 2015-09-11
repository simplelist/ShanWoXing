package com.yxtar.app.base.constants;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.Constants.DefaultStringValue;

//this interface use to i18n 
public interface CalendarConstants extends Constants {

	/**
	 * @param args
	 */
	@DefaultStringValue("save")
	String save();

	@DefaultStringValue("cancel")
	String cancel();
	
	@DefaultStringValue("年")
	String year();
	
	@DefaultStringValue("月")
	String month();
	//Sunday to Saturday
	@DefaultStringValue("Sunday")
	String Sunday();
	@DefaultStringValue("Monday")
	String Monday();
	@DefaultStringValue("Tuesday")
	String Tuesday();
	@DefaultStringValue("Wednesday")
	String Wednesday();
	@DefaultStringValue("Thursday")
	String Thursday();
	@DefaultStringValue("Friday")
	String Friday();
	@DefaultStringValue("Saturday")
	String Saturday();
}
