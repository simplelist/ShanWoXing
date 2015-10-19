package com.yxtar.app.client.i18n;

import com.google.gwt.i18n.client.Constants;

public interface UIConstants extends Constants {
	
	@DefaultStringValue("Back")
	String back();

	@DefaultStringValue("Picture Maintenance")
	String pictureEditTitle();

	@DefaultStringValue("Save")
	String save();

	@DefaultStringValue("Please check the picture name.")
	String checkName();
	
	@DefaultStringArrayValue({ "ID", "Title" ,"Description","Content","Category","Picture"})
	String[] textEditForm();

	@DefaultStringValue("Text Maintenance")
	String textMaintenance();

	@DefaultStringArrayValue({ "ID", "Email" ,"Login ID","Name"})
	String[] userShowTitle();
	
	@DefaultStringArrayValue({ "ID","Login ID", "Email" ,"First Name","Last Name","Password","Confirm Password","Status","Admin Status"})
	String[] userEditForm();

	@DefaultStringValue("User Maintenance")
	String userMaintenance();

	@DefaultStringValue("Please check the Email.")
	String checkEmail();

	@DefaultStringValue("Email Can't be Empty.")
	String checkEmptyEmail();

	@DefaultStringValue("FirstName Can't be Empty.")
	String checkEmptyFirstName();
	
	@DefaultStringValue("Please check the FirstName.")
	String checkFirstName();

	@DefaultStringValue("Please check the LastName.")
	String checkLastName();

	@DefaultStringValue("LastName Can't be Empty.")
	String checkEmptyLastName();

	@DefaultStringValue("please enter confirm password")
	String checkSurePwd();

	@DefaultStringValue("The passwords entered do not match")
	String checkTwoPwd();
	
	@DefaultStringValue("please enter password")
	String checkPwd();
	
	@DefaultStringArrayValue({ "ID", "Name" ,"Size","Type","Download"})
	String[] docSearchTitle();
	
	@DefaultStringArrayValue({ "ID", "Name" ,"Size","Type","Download","Download Address"})
	String[] docEditForm();
	
	@DefaultStringValue("Document Maintenance")
	String docMaintenance();

	@DefaultStringValue("Please Enter Document Name")
	String checkEmptyDocName();
	
	@DefaultStringValue("Upload")
	String upload();

	@DefaultStringValue("Document size exceeded(Max 10Mb)" )
	String uploadmaxsizeError();

	@DefaultStringValue("Pictures")
	String selectPicture();

	@DefaultStringValue("Please Enter Text Description")
	String checkDesc();

	@DefaultStringValue("Please Enter Text Content")
	String checkContent();

	@DefaultStringValue("Please Enter Text Category")
	String checkCategory();

	@DefaultStringValue("Please Enter Text Picture")
	String checkPicture();

	@DefaultStringArrayValue({ "ID", "Name" ,"Tag","Content"})
	String[] interfaceEditForm();
}
