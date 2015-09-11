package com.yxtar.app.base.framework;

public enum SelectionWidgetEnum {
	UserSelect(1) 
	;
	private Integer type;

	SelectionWidgetEnum(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
