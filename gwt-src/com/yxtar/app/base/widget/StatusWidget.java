package com.yxtar.app.base.widget;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.input.checkbox.MCheckBox;

public class StatusWidget  extends Composite implements IsWidget {
	private FlowPanel statPanel = new FlowPanel();
	private MCheckBox checkBox = new MCheckBox();
	private Label statusLabel = new Label();
	private String selected = null;
	private String unselected = null;

	public StatusWidget(String on,String off) {
		this.selected = on;
		this.unselected = off;
		initWidget(statPanel);
		statPanel.add(checkBox);
		statPanel.add(statusLabel);
		checkBox.setValue(true);
		if(Window.Navigator.getUserAgent().indexOf("Safari") == -1&&Window.Navigator.getUserAgent().indexOf("Chrome") == -1){
			statPanel.setWidth("48%");
			checkBox.removeStyleName("GGVW5XCGY");
			checkBox.removeStyleName("GNOTACLBGY");
			checkBox.addStyleName("status_widget_checkbox");
			statusLabel.addStyleName("status_widget_label");
			statusLabel.getElement().setAttribute("style", "float:right;");
	 
		}else{
		 
			statPanel.setStyleName("class-classcreate-border");
			statPanel.getElement().setAttribute("style", "width:97%;height:50px;");
			checkBox.getElement().setAttribute("style", "float:left;margin-top:10px;width:98px;"); 
			statusLabel.getElement().setAttribute("style", "float:left;margin-left:100px;line-height:50px;");
		}
		
		checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				setDisplay(event.getValue() ? unselected : selected);
			}
		});
	}

	public void addValueChangeListener(ValueChangeHandler<Boolean> valueChangeHandler) {
		checkBox.addValueChangeHandler(valueChangeHandler);
	}

	public void setDisplay(String value) {
		statusLabel.setText(value);
	}

	public void setValue(boolean value) {
		checkBox.setValue(value);
		setDisplay(value ? this.unselected : this.selected);
	}

	public void setEnable(Boolean flag) {
		checkBox.setReadOnly(flag);
	}

	public void addValueChangeHandler(ValueChangeHandler<Boolean>  valueChangeHandler) {
		checkBox.addValueChangeHandler(valueChangeHandler);
	}

	public boolean getValue() {
		return checkBox.getValue();
	}

	public void setPanelWidth(String width){
		statPanel.setWidth(width);
	}

	public void clean(){
		//this.selected=null;
		//this.unselected=null;

	}
}
