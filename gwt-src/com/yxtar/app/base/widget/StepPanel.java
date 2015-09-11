package com.yxtar.app.base.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEndEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEndHandler;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEvent.DIRECTION;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeMoveEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeMoveHandler;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeStartEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeStartHandler;
import com.googlecode.mgwt.ui.client.widget.touch.TouchPanel;
import com.yxtar.app.base.event.FollowerMoveEvent;
import com.yxtar.app.base.event.FollowerMoveEventHandler;


/**
 * StepPanel is a Panel with steps, which can be swipe it to four direction
 * 
 * @author jimmylo
 * 
 */
public class StepPanel extends TouchPanel {

  /**
   * SwipeDirection is a enum for indicating swipe direction including Up, Down,
   * Left and Right
   */
  public enum SwipeDirection {
    Up("Y"), Down("Y"), Left("X"), Right("X");
    private String cssIndex = "";

    SwipeDirection(String cssIndex) {
      this.cssIndex = cssIndex;
    }

    public String getCssIndex() {
      return this.cssIndex;
    }
  }

  /**
   * inter class which is used for storing step information, and is used by
   * StepPanel
   */
  public class Step {
    private int target;
    private int destination;
    private double opacity;

    /**
     * Step constructor
     * @param target position for indicating go to destination or not
     * @param destination step destination position
     * @param opacity opacity at step destination
     */
    public Step(int target, int destination, double opacity) {
      this.target = target;
      this.destination = destination;
      this.opacity = opacity;
    }

    public int getTarget() {
      return this.target;
    }

    public int getDestination() {
      return this.destination;
    }

    public double getOpacity() {
      return this.opacity;
    }

  }
  /** default animation time is 0.3s */
  public final double defaultAnimationTime = 0.3;
  /** list for storing step informations */
  private List steps = new ArrayList<Step>();
  /** index of the current step */
  private int stepIndex;
  /** step object of the current step */
  private Step currentStep;
  /** opacity of the step at starting point */
  private double stepStartOpacity;
  /**
   * store the step starting position, i.e. the destination of the last step
   */
  private int stepStartPos;

  /** the directioni of the swipePanel */
  protected SwipeDirection swipeDirection;
  /** store the initial touch position */
  private int initTouchPosition;
  /** store the last position the panel reached */
  private int lastReachPosition;

  private EventBus moveFollowerEventBus = GWT.create(SimpleEventBus.class);

  private EventBus moveEndEventBus = GWT.create(SimpleEventBus.class);

  /** true to disable step adding function */
  private boolean lockStepFlag = false;

  /** true to enable panel on translating */
  private boolean translateEnableFlag = false;

  /** true if the move is by calling method but not by swipe */
  private boolean translateAutoFlag = true;

  public StepPanel(SwipeDirection swipeDirection) {
    super();

    this.swipeDirection = swipeDirection;

    this.registerSwipeHandler();
  }

  public void addStep(Step step) {
    if (!this.lockStepFlag) {
      this.steps.add(step);
      if (steps.size() == 1) {
        this.currentStep = step;
      }
    }
  }

  /**
   * this method is call to add the final step no more step can be added after
   * calling lockStep
   */
  public void lockStep() {

    Step lastStepAdded = (Step) this.steps.get(this.steps.size() - 1);
    Step finalStep = new Step(lastStepAdded.getDestination(), lastStepAdded.getDestination(),
        lastStepAdded.getOpacity());
    this.addStep(finalStep);
    this.lockStepFlag = true;
    this.setCurrentStep((Step) steps.get(0));
  }

  protected void registerSwipeHandler() {

    this.addSwipeStartHandler(new SwipeStartHandler() {

      @Override
      public void onSwipeStart(SwipeStartEvent event) {
        // check swiping direction first
        if (((event.getDirection().equals(SwipeEvent.DIRECTION.RIGHT_TO_LEFT) || event.getDirection().equals(
            SwipeEvent.DIRECTION.LEFT_TO_RIGHT)) && (swipeDirection.equals(SwipeDirection.Left) || swipeDirection
            .equals(SwipeDirection.Right)))
            || ((event.getDirection().equals(SwipeEvent.DIRECTION.TOP_TO_BOTTOM) || event.getDirection().equals(
                SwipeEvent.DIRECTION.BOTTOM_TO_TOP)) && (swipeDirection.equals(SwipeDirection.Up) || swipeDirection
                .equals(SwipeDirection.Down)))) {
          translateEnableFlag = true;
          translateAutoFlag = false;
        } else {
          translateEnableFlag = false;
          translateAutoFlag = true;
        }
        // store the initial touch position for later use
        if (swipeDirection.equals(SwipeDirection.Right) || swipeDirection.equals(SwipeDirection.Left)) {
          initTouchPosition = event.getTouch().getPageX();
        } else {
          initTouchPosition = event.getTouch().getPageY();
        }

      }

    });

    this.addSwipeMoveHandler(new SwipeMoveHandler() {

      @Override
      public void onSwipeMove(SwipeMoveEvent event) {
        if (!translateEnableFlag) {
          return;
        }
        // calculate the translate position
        int curX = 0;
        int translateDist = 0;
        if (swipeDirection.equals(SwipeDirection.Right) || swipeDirection.equals(SwipeDirection.Left)) {
          curX = event.getTouch().getPageX() - initTouchPosition;
        } else {
          curX = event.getTouch().getPageY() - initTouchPosition;
        }
        translateDist = curX + stepStartPos;

        // prevent exceed the start and end boundaries
        if (swipeDirection.equals(SwipeDirection.Right) || swipeDirection.equals(SwipeDirection.Down)) {
          if (translateDist <= 0 || translateDist >= ((Step) steps.get(steps.size() - 1)).getDestination()) {
            return;
          }
        } else {
          if (translateDist >= 0 || translateDist <= ((Step) steps.get(steps.size() - 1)).getDestination()) {
            return;
          }
        }
        translate(translateDist, 0);
      }

    });

    this.addSwipeEndHandler(new SwipeEndHandler() {

      @Override
      public void onSwipeEnd(SwipeEndEvent event) {
        if (!translateEnableFlag) {
          return;
        }
        translateEnableFlag = false;
        handleMoveEnd();
      }

    });
    
    this.addDomHandler(new MouseOutHandler(){

		@Override
		public void onMouseOut(MouseOutEvent event) {
			if (!translateEnableFlag) {
		          return;
		    }
			translateEnableFlag = false;
			handleMoveEnd();
			
		}}, MouseOutEvent.getType());

    registerTransitionEndEvent(getElement());
  }
  
  /**
   * process for the end of the drag movement
   */
  public void handleMoveEnd(){
	  int returnStepIndex = locateCurrentStep(lastReachPosition);
      if (returnStepIndex != stepIndex) {
        stepIndex = returnStepIndex;
        setCurrentStep((Step) steps.get(stepIndex));
      }
      translateAutoFlag = true;
      if (((swipeDirection.equals(SwipeDirection.Right) || swipeDirection.equals(SwipeDirection.Down)) && lastReachPosition > currentStep
          .getTarget())
          || ((swipeDirection.equals(SwipeDirection.Left) || swipeDirection.equals(SwipeDirection.Up)) && lastReachPosition < currentStep
              .getTarget())) {
        // reach the target position, go to destination
        moveToStepDestination(defaultAnimationTime);

      } else {
        // back to initial step start point
        backToStepStart(defaultAnimationTime);
      }
  }

  /**
   * for clear the css style after swipe end
   */
  public static native void registerTransitionEndEvent(Element element)/*-{
		element.addEventListener('webkitTransitionEnd', function(event) {
			this.style.webkitTransition = 'none';
		}, false);
		element.addEventListener('transitionEnd', function(event) {
      this.style.transition = 'none';
    }, false);
  }-*/;

  public void backToStepStart(double animationTime) {
    getElement().getStyle().setProperty("webkitOpacity", this.stepStartOpacity + "");
    getElement().getStyle().setProperty("opacity", this.stepStartOpacity + "");
    this.translate(this.stepStartPos, animationTime);
    moveEndEventBus.fireEvent(new StepMoveEndEvent((Step) steps.get(stepIndex),stepIndex,0));
  }

  /**
   * method for translate the panel to given position
   * @param position the destinated position value in corresponding axis
   * @param animationTime time duration for the translation
   */
  private void translate(int position, double animationTime) {

    this.lastReachPosition = position;
    getElement().getStyle().setProperty("webkitTransition", "all " + animationTime + "s ease-in");
    getElement().getStyle().setProperty("transition", "all " + animationTime + "s ease-in");
    if (swipeDirection.equals(SwipeDirection.Up) || swipeDirection.equals(SwipeDirection.Down)) {
      getElement().getStyle().setProperty("webkitTransform",
          "translate3d(0" + Unit.PX + "," + position + Unit.PX + ",0" + Unit.PX + ")");
      getElement().getStyle().setProperty("transform",
          "translate3d(0" + Unit.PX + "," + position + Unit.PX + ",0" + Unit.PX + ")");
    } else {
      getElement().getStyle().setProperty("webkitTransform",
          "translate3d(" + position + Unit.PX + ",0" + Unit.PX + ",0" + Unit.PX + ")");
      getElement().getStyle().setProperty("transform",
          "translate3d(" + position + Unit.PX + ",0" + Unit.PX + ",0" + Unit.PX + ")");
    }

    // fire the event for the followers
    this.fireEventForFollower(position, animationTime);
  }

  /**
   * move the widget to current step destination
   */
  protected void moveToStepDestination(double animationTime) {

    getElement().getStyle().setProperty("webkitOpacity", Double.toString(this.currentStep.getOpacity()));
    getElement().getStyle().setProperty("opacity", Double.toString(this.currentStep.getOpacity()));
    this.translate(this.currentStep.getDestination(), animationTime);

    if (this.stepIndex + 1 < this.steps.size()) {
      this.stepIndex++;
      this.setCurrentStep((Step) this.steps.get(this.stepIndex));
    } else {
      this.stepStartPos = this.currentStep.getDestination();
    }
    moveEndEventBus.fireEvent(new StepMoveEndEvent((Step) steps.get(stepIndex),stepIndex,1));

  }

  public void addFollowerMoveHandler(FollowerMoveEventHandler followerMoveEventHandler) {
    this.moveFollowerEventBus.addHandler(FollowerMoveEvent.TYPE, followerMoveEventHandler);
  }

  public void addMoveEndHandler(StepMoveEndEventHandler moveEndEventHandler) {
    this.moveEndEventBus.addHandler(StepMoveEndEvent.TYPE, moveEndEventHandler);
  }

  /**
   * set the current step
   * @param step
   */
  private void setCurrentStep(Step step) {
    this.currentStep = step;
    if (this.stepIndex == 0) {
      this.stepStartPos = 0;
      this.stepStartOpacity = 1;
    } else {
      Step previousStep = (Step) this.steps.get(stepIndex - 1);
      this.stepStartPos = previousStep.getDestination();
      this.stepStartOpacity = previousStep.getOpacity();
    }

  }

  /**
   * locate the current step during the user move the panel
   * @param lastReachPosition the last translated position of the widget
   */
  private int locateCurrentStep(int lastReachPosition) {
    int returnStepIndex = this.stepIndex;
    // check if the last translated position is within the same step
    if (this.swipeDirection.equals(SwipeDirection.Right) || this.swipeDirection.equals(SwipeDirection.Down)) {
      if (lastReachPosition <= this.currentStep.destination && lastReachPosition >= this.stepStartPos) {
        return returnStepIndex;
      }
    } else {
      if (lastReachPosition >= this.currentStep.destination && lastReachPosition <= this.stepStartPos) {
        return returnStepIndex;
      }
    }

    // find the corresponding step
    Step returnStep = (Step) this.steps.get(0);

    for (returnStepIndex = 0; returnStepIndex < this.steps.size(); returnStepIndex++) {
      returnStep = (Step) this.steps.get(returnStepIndex);
      if (this.swipeDirection.equals(SwipeDirection.Right) || this.swipeDirection.equals(SwipeDirection.Down)) {
        if (lastReachPosition < returnStep.getDestination()) {
          break;
        }

      } else if (lastReachPosition > returnStep.getDestination()) {
        break;
      }
    }
    return returnStepIndex;

  }

  /**
   * moveToStep is a method for moving the panel by other control
   * @param stepIndex stepIndex is the step index which indicate which step it
   *        is going to
   * @param animationTime animationTime is the time for the translating
   *        animation
   */
  public void moveToStep(int stepIndex, double animationTime) {
    if (stepIndex < 0) {
      stepIndex = 0;
    } else if (stepIndex >= this.steps.size()) {
      stepIndex = this.steps.size() - 1;
    }
    this.stepIndex = stepIndex;
    this.setCurrentStep((Step) this.steps.get(this.stepIndex));
    this.backToStepStart(animationTime);
  }

  /**
   * fire event for informing the follower for the movement
   */
  private void fireEventForFollower(int translateDist, double translateTime) {
    this.moveFollowerEventBus.fireEvent(new FollowerMoveEvent(translateDist, this.swipeDirection, translateTime,
        this.currentStep.getDestination(), this.translateAutoFlag));
  }

  /**
   * a static method provided for followers to move
   * @param element follower's element object
   * @param translateDistance translate distance
   * @param swipeDirection Enum from StepPanel
   * @param translateTime translate time
   */
  public static void moveFollower(Element element, int translateDistance, SwipeDirection swipeDirection,
      double translateTime) {
    element.getStyle().setProperty("webkitTransition", "all " + translateTime + "s ease-in");
    element.getStyle().setProperty("transition", "all " + translateTime + "s ease-in");
    if (swipeDirection.equals(SwipeDirection.Up) || swipeDirection.equals(SwipeDirection.Down)) {
      element.getStyle().setProperty("webkitTransform",
          "translate3d(0" + Unit.PX + "," + translateDistance + Unit.PX + ",0" + Unit.PX + ")");
      element.getStyle().setProperty("transform",
          "translate3d(0" + Unit.PX + "," + translateDistance + Unit.PX + ",0" + Unit.PX + ")");
    } else {
      element.getStyle().setProperty("webkitTransform",
          "translate3d(" + translateDistance + Unit.PX + ",0" + Unit.PX + ",0" + Unit.PX + ")");
      element.getStyle().setProperty("transform",
          "translate3d(" + translateDistance + Unit.PX + ",0" + Unit.PX + ",0" + Unit.PX + ")");
    }
  }

  /**
   * 2013-08-12 wufeng get current step position
   * @return current step
   */
  public int getCurrentStep() {
    return steps.indexOf(this.currentStep);
  }
}
