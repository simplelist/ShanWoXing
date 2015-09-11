package com.yxtar.app.base.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.google.gwt.user.client.Timer;
import com.yxtar.app.base.event.AsynProcEventHandler;

/**
 * AsynProcesser allow program to handle asyn processes with single start and end point
 * @author jimmylo
 */
public class AsynProcesser implements AsynProcEventHandler {

	/**
	 * AsynProc is the interface for run asyn call
	 * @author jimmylo
	 */
	public interface AsynProc {
		public void proccess();
	}

	/**
	 * asynProcLst stores all the asyn process
	 */
	protected List<AsynProc> asynProcLst;
	/**
	 * finishFlgStack is used to indicating whether all processes are completed or not
	 * if size = 0, it means all processes are completed
	 */
	private Stack<Boolean> finishFlgStack;
	/**
	 * maxTimeLimit is used to indicating max time wait for all process to completed
	 */
	protected int maxTimeLimit;
	protected Timer failTimer;
	protected AsynProcEventHandler asynProcEventHandler;
	/**
	 * true means fail
	 */
	protected boolean failFlg;
	public AsynProcesser(){
		this.asynProcLst = new ArrayList<AsynProc>();
		this.finishFlgStack = new Stack<Boolean>();
		this.failFlg = false;
		this.failTimer = new Timer() {
			@Override
			public void run() {
				failFlg = true;
				onProcFail("time exceeded");
			}
		};
	}

	public void addAsynProc(AsynProc asynProcess){
		this.asynProcLst.add(asynProcess);
		this.finishFlgStack.push(true);
	}

	public void startAsynProc(int maxTimeLimit){
		this.maxTimeLimit = maxTimeLimit;
		for(int i = 0; i < this.asynProcLst.size(); i++){
			this.asynProcLst.get(i).proccess();
		}

		//max time limit timer
		this.failTimer.schedule(this.maxTimeLimit);
	}

	@Override
	public void onProcCompleted() {
		if(!this.finishFlgStack.empty() && !this.failFlg){
			this.finishFlgStack.pop();
			if(this.finishFlgStack.empty()){
				if(this.asynProcEventHandler != null){
					this.asynProcEventHandler.onProcCompleted();
				}
				this.failTimer.cancel();
			}else{
				int percentage = 100 - (int) (((double)this.finishFlgStack.size())/this.asynProcLst.size() * 100);
				if(this.asynProcEventHandler != null){
					this.asynProcEventHandler.onReportProgress(percentage);
				}
			}
		}
	}

	@Override
	public void onProcFail(String errMsg) {
		//notify other that something goes wrong
		this.failFlg = true;
		this.failTimer.cancel();
		if(this.asynProcEventHandler != null){
			this.asynProcEventHandler.onProcFail(errMsg);
		}

	}

	public void setAsynProcEventHandler(AsynProcEventHandler asynProcEventHandler){
		this.asynProcEventHandler = asynProcEventHandler;
	}

	@Override
	public void onReportProgress(int percentage) {
		//nothing to do here

	}
}
