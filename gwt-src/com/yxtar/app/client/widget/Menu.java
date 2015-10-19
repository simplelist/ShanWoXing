package com.yxtar.app.client.widget;import com.google.gwt.core.shared.GWT;import com.google.gwt.event.dom.client.ClickEvent;import com.google.gwt.event.dom.client.ClickHandler;import com.google.gwt.user.client.ui.Composite;import com.google.gwt.user.client.ui.FlowPanel;import com.google.gwt.user.client.ui.HasAlignment;import com.google.gwt.user.client.ui.HorizontalPanel;import com.google.gwt.user.client.ui.Label;import com.google.gwt.user.client.ui.VerticalPanel;import com.yxtar.app.base.widget.StepMoveEndEventHandler;import com.yxtar.app.base.widget.StepPanel;import com.yxtar.app.base.widget.StepPanel.Step;import com.yxtar.app.base.widget.StepPanel.SwipeDirection;import com.yxtar.app.client.ClientFactory;import com.yxtar.app.client.i18n.MenuConstants;import com.yxtar.app.client.place.HomePlace;public class Menu extends Composite {	private FlowPanel containPanel = new FlowPanel();	private VerticalPanel verticalPanel = new VerticalPanel();	private MenuConstants constants = GWT.create(MenuConstants.class);	protected StepPanel animationPanel = new StepPanel(SwipeDirection.Left);	public MenuItem homeItem = null;	public MenuItem userItem = null;	private ClientFactory factory = null;	public Menu(ClientFactory client, StepMoveEndEventHandler end) {		factory = client;		initWidget(animationPanel);		animationPanel.add(containPanel);		containPanel.add(verticalPanel);		verticalPanel.addStyleName("menu-list");		containPanel.getElement().setAttribute("style", "width:200px;");		Step step = animationPanel.new Step(300, 0, 1);		animationPanel.addStep(step);		animationPanel.lockStep();		// generate items		homeItem = new MenuItem("../../../admin_ext_img/nav/5.png", constants.picture());		userItem = new MenuItem("../../../admin_ext_img/nav/8.png", constants.user());		// add items to container		verticalPanel.add(homeItem);		verticalPanel.add(userItem);		animationPanel.addMoveEndHandler(end);		animationPanel.moveToStep(1, 0);	}	// display menu	public void show() {		animationPanel.moveToStep(0, .4);	}	// hidden menu	public void hiden() {		animationPanel.moveToStep(1, .3);	}	public void menuClicked(Object object) {		if (object.equals(homeItem)) {			factory.getPlaceController().goTo(new HomePlace());//		} else if (object.equals(interfaceItem)) {//			factory.getPlaceController().goTo(new InterfacePlace());//		} else if (object.equals(userItem)) {//			factory.getPlaceController().goTo(new UserPlace());		}		hiden();	}	public class MenuItem extends Composite {		private FlowPanel containPanel = new FlowPanel();		private HorizontalPanel horizontalPanel = new HorizontalPanel();		private MenuItem self = this;		public MenuItem(String imgurl, String displayTxt) {			initWidget(containPanel);			horizontalPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);			horizontalPanel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);			containPanel.getElement().addClassName("item");			containPanel.add(horizontalPanel);//			Image image = new Image(Environment.imgServlet + imgurl);//			image.addStyleName("icon");//			horizontalPanel.add(image);			Label dispLabel = new Label(displayTxt);			dispLabel.addStyleName("word");			horizontalPanel.add(dispLabel);			containPanel.addDomHandler(new ClickHandler() {				private Object object = self;				@Override				public void onClick(ClickEvent event) {					menuClicked(object);				}			}, ClickEvent.getType());		}		public void isSelected() {			containPanel.getElement().setAttribute("style", "background-color:#e0e0f0");		}		public void unSelected() {			containPanel.getElement().setAttribute("style", "background-color:#fbfbfb");		}	}	public void clearSelected() {		homeItem.unSelected();		userItem.unSelected();	}}