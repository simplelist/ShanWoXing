package com.yxtar.server.action;

public enum ErrorType {
	WrongOldPassword("WrongOldPassword"), ParasIsNull("ParasIsNull"), FormatError("FormatError");
	
	
	String name;

	ErrorType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
