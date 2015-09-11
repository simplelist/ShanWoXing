package com.yxtar.app.base.event;

import com.google.gwt.event.shared.GwtEvent;
import com.yxtar.app.base.widget.StepPanel.SwipeDirection;

public class FollowerMoveEvent extends GwtEvent<FollowerMoveEventHandler> {
  public static Type<FollowerMoveEventHandler> TYPE = new Type<FollowerMoveEventHandler>();
  private int translateDist = 0;
  private SwipeDirection swipeDirection = SwipeDirection.Right;
  private double translateTime = 0;
  private int currentStepDestination = 0;
  private boolean autoFlag = false;
  
  /**
   * Constructor or FollowerMoveEvent
   * @param translateDist	distance moved
   * @param swipeDirection	moving direction
   * @param translateTime	time used for moving animation
   * @param currentStepDestination the destination of the current step
   * @param autoFlag this flag indicate that this move is by swipe(false) or by calling method(true)
   */
  public FollowerMoveEvent(int translateDist, SwipeDirection swipeDirection, double translateTime, int currentStepDestination, boolean autoFlag){
	  this.translateDist = translateDist;
	  this.translateTime = translateTime;
	  this.swipeDirection = swipeDirection;
	  this.currentStepDestination = currentStepDestination;
	  this.autoFlag = autoFlag;
  }
  
  public int getTranslateDist(){
	  return this.translateDist;
  }
  
  public SwipeDirection getSwipeDirection(){
	  return this.swipeDirection;
  }
  
  public double getTranslateTime(){
	  return this.translateTime;
  }
  
  public int getCurrentStepDestination(){
	  return this.currentStepDestination;
  }
  
  public boolean getAutoFlag(){
	  return this.autoFlag;
  }
  
  @Override
  public Type<FollowerMoveEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(FollowerMoveEventHandler handler) {
    handler.onFollowerMoveEvent(this);
  }
}
