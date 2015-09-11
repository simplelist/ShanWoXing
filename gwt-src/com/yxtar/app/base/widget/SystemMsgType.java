package com.yxtar.app.base.widget;

public enum SystemMsgType {
	Info(1), Error(2),Warning(3);
	private Integer type;

	SystemMsgType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
