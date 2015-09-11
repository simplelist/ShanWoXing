package com.yxtar.app.base.activity;

import com.yxtar.app.base.event.AsynProcEventHandler;

/**
 * Class System is using for all system level logic which is not included in any activity.
 * @author jimmylo
 *
 */
public abstract class BaseSystemEngine extends BaseRPCEngine{
	protected AsynProcEventHandler asynProcEventHandler;
	//protected SystemParams systemParams = null;

	

	/*public BaseSystemEngine(SystemParams systemParams){
		this.systemParams = systemParams;

	}*/
	public BaseSystemEngine(){
	}
	public void setSystemInitializeHandler(AsynProcEventHandler asynProcEventHandler){
		this.asynProcEventHandler = asynProcEventHandler;
	}

	public abstract void initialize();


	/**
	 * call when all initializations completed
	 */
	public void initializeCompleted(){
		if(this.asynProcEventHandler != null){
			this.asynProcEventHandler.onProcCompleted();
		}
	}

	/**
	 * call when initialization fail
	 */
	public void initializeFail(String errMsg){
		if(this.asynProcEventHandler != null){
			this.asynProcEventHandler.onProcFail(errMsg);
		}
	}

	/**
	 * call for reporting initialization status 
	 * @param percentage should be an integer smaller than 100
	 */
	public void initializeProgress(int percentage){
		if(percentage > 100){
			percentage = 100;
		}else if(percentage < 0){
			percentage = 0;
		}
		if(this.asynProcEventHandler != null){
			this.asynProcEventHandler.onReportProgress(percentage);
		}
	}



}
