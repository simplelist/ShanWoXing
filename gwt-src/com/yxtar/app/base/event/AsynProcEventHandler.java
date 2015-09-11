package com.yxtar.app.base.event;

public interface AsynProcEventHandler {
	public void onProcCompleted();
	public void onProcFail(String errMsg);
	public void onReportProgress(int percentage);
}
