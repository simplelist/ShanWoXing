package com.yxtar.app.base.constants;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.Constants.DefaultStringValue;

public interface WidgetsConstants extends Constants {

	@DefaultStringValue("ID")
	String id();

	@DefaultStringValue("name")
	String name();
	
	@DefaultStringValue("status")
	String status();
	
	@DefaultStringValue("type")
	String type();

	@DefaultStringValue("Add")
	String add();

	@DefaultStringValue("OK")
	String confirm();

	@DefaultStringValue("ON")
	String proStateON();

	@DefaultStringValue("OFF")
	String proStateOFF();

	@DefaultStringValue("Search")
	String search();
	
	@DefaultStringValue("Advance")
	String highsearch();
	
	@DefaultStringValue("select one")
	String selectone();
	
	@DefaultStringValue("Basic")
	String simplesearch();
	
	@DefaultStringValue("Condition")
	String condition();
	
	@DefaultStringValue("Update")
	String update();

	@DefaultStringValue("Cancel")
	String cancel();

	@DefaultStringValue("Info")
	String info();

	@DefaultStringValue("Warning")
	String warning();

	@DefaultStringValue("Error")
	String error();

	@DefaultStringValue("no data")
	String noresult();
	
	@DefaultStringValue("Upload")
	String upload();
	
	@DefaultStringValue("Uploading")
	String uploading();
	
	@DefaultStringArrayValue({"Week","Month","No Limit"})
	String[] storeddate();

	@DefaultStringValue("User Select Page")
	String userSearchTitle();

	@DefaultStringArrayValue({"ID","Name","Company","Email"})
	String[] userWidgetSearch();
	
	@DefaultStringArrayValue({ "ID","Name","Type","Size","Download link"})
	String[] uploadfilelist();
 
	@DefaultStringArrayValue({ "Select File","File in info","Share to"})
	String[] uploadstep();
	
	@DefaultStringValue("Max File Size (50MB) existed")
	String uploadmaxsizeError();

	@DefaultStringValue("Delete")
	String delete();

	@DefaultStringValue("Confirm")
	String yes();

	@DefaultStringValue("Jump To:")
	String jump();
	
	@DefaultStringArrayValue({"ID", "Name","Status","Type","Count","Price"})
	String[] pdtview();
	
	@DefaultStringValue("count")
	String count();
	
	@DefaultStringArrayValue({"Desc", "Value"})
	String[] textparamDesc();

	@DefaultStringArrayValue({"ID", "Name","Type"})
	String[] pictureSearch();

	@DefaultStringValue("Picture")
	String pictureSearchTitle();
	
	
	@DefaultStringValue("Title")
	String title();

	@DefaultStringValue("Document")
	String docSearchTitle();

	@DefaultStringArrayValue({"ID", "Name","Type"})
	String[] docSearch();
	
	@DefaultStringValue("Please select one category!")
	String selectCate();

	@DefaultStringValue("Sorry")
	String sorry();
	
	@DefaultStringValue("Cannot delete default lang!")
	String deldefaultLang();

	@DefaultStringValue("Category")
	String category();

}
