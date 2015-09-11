package com.yxtar.app.base.widget;

public interface SystemMsgView {
	// 要显示的文本信息,弹出控件
	public void showMsg(SystemMsgType systemMsgType, String msg);

	// display anyway
	public void show();

	// 隐藏控件
	public void hide();
public void setListener(Listener l);
	
	public interface Listener{
		void onClick(Boolean flag);
	}
}
