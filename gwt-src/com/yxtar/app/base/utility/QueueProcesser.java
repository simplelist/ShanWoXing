package com.yxtar.app.base.utility;

import com.yxtar.app.base.event.AsynProcEventHandler;

/**
 * QueueProcesser extends AsynProcesser, but process each asyn process one by one
 * @author jimmylo
 */
public class QueueProcesser extends AsynProcesser {
	
	private int currentIndex = 0;
	

	public QueueProcesser(){
		super();
	}
	
	/**
	 * 
	 * @return the current process index in the list
	 */
	public int getCurrentProcIndex(){
		return this.currentIndex;
	}
	
	@Override
	public void startAsynProc(int maxTimeLimit){
		this.maxTimeLimit = maxTimeLimit;
		//max time limit timer
		this.failTimer.schedule(this.maxTimeLimit);
		
		this.asynProcLst.get(0).proccess();
		
	}

	@Override
	public void onProcCompleted() {
		//increase the index
		this.currentIndex++;
		//check if all process are completed
		if(this.currentIndex == this.asynProcLst.size()){
			/* if all process are completed, 
			 * 1/ cancel the timer
			 * 2/ call the handler's onProcCompleted
			 */
			this.failTimer.cancel();
			if(this.asynProcEventHandler != null){
				this.asynProcEventHandler.onProcCompleted();
			}		
		}else{
			/* if not completed,
			 * 1/ report the progress status 
			 * 2/ start the next process
			 */
			int percentage = (int) ((double)this.currentIndex/this.asynProcLst.size() * 100);
			if(this.asynProcEventHandler != null){
				this.asynProcEventHandler.onReportProgress(percentage);
			}
			this.asynProcLst.get(this.currentIndex).proccess();
		}

	}
}
