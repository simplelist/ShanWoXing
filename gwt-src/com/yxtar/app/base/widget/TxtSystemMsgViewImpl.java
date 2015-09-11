package com.yxtar.app.base.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.yxtar.app.base.constants.WidgetsConstants;

public class TxtSystemMsgViewImpl extends Composite implements SystemMsgView {
	private VerticalPanel rootPanel = new VerticalPanel();
	private FixPopupPanel dialogBox = new FixPopupPanel(false,true);
	private FixPopupPanel glassBox = new FixPopupPanel(true,true);
	private FlexTable showTable = new FlexTable();
	private WidgetsConstants constants = GWT.create(WidgetsConstants.class);
	private PreloadImage icon;
	private HorizontalPanel buttonPanel = new HorizontalPanel();
	private Button confim = new Button();
	private Button cancel = new Button();
	private String cssMain = "max-width:796px; min-height:45px;outline:none;";
	private int rootheight = 200;
	private int height = (Window.getClientHeight() - rootheight) / 2;
	private Listener handler;
	private String message="./image/message.png";
	private String error="./image/error.png";
	private String warn="./image/warn.png";
	public TxtSystemMsgViewImpl() {
		initWidget(rootPanel);
		confim.setText(constants.confirm());
		cancel.setText(constants.cancel());
		cssMain = cssMain + "margin:0px auto;margin-top:" +(height-rootheight/2)+ "px;";
		rootPanel.getElement().setAttribute("style", cssMain);
		rootPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		rootPanel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		rootPanel.setSize("400px", rootheight + "px");
		buttonPanel.setStyleName("alert_buttonPanel");
		rootPanel.add(showTable);

		showTable.setWidget(2, 0, buttonPanel);
		buttonPanel.add(cancel);
		buttonPanel.add(confim);
		confim.setStyleName("buttonStyle");
		cancel.setStyleName("buttonStyle");

		rootPanel.setStyleName("system_msg_view");
		showTable.setStyleName("tabelMessage");
		showTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		showTable.getFlexCellFormatter().setColSpan(2, 0, 2);
		

	}

	public void setMessageImg(String path){
		message=path;
	}
	public void setErrorImg(String path){
		error=path;
	}
	public void setWarnImg(String path){
		warn=path;
	}
	public void showMsg(SystemMsgType systemMsgType, String msg) {
		glassBox.shows();
		dialogBox.shows();
		dialogBox.clear();
		dialogBox.add(this);

		showTable.setText(1, 0, msg);
		if (systemMsgType.getType() == SystemMsgType.Info.getType()) {
			icon = new PreloadImage(message, 35, 35);

			/* The header information */
			showTable.setText(0, 1, constants.info());
			showTable.getRowFormatter().setStyleName(0, "tabelMessageHeader1");
			confim.removeStyleName("tabelMessageHeader2");
			confim.removeStyleName("tabelMessageHeader3");
			confim.addStyleName("tabelMessageHeader1");
			cancel.addStyleName("tabelMessageHeader1");
			if (handler == null) {
				//set the cancel button is hidden
				cancel.setVisible(false);
				confim.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						hide();
					}
				});
			} else {
				//set the cancel button is show
				cancel.setVisible(true);

				confim.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (handler != null) {
							handler.onClick(true);
						}
						hide();
					}
				});
				cancel.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (handler != null) {
							handler.onClick(false);
						}
						hide();
					}
				});

			}
		} else if (systemMsgType.getType() == SystemMsgType.Error.getType()) {
			icon = new PreloadImage(error, 35, 35);

			/* The header information */
			showTable.setText(0, 1, constants.error());
			showTable.getRowFormatter().setStyleName(0, "tabelMessageHeader2");
			confim.removeStyleName("tabelMessageHeader1");
			confim.removeStyleName("tabelMessageHeader3");
			confim.addStyleName("tabelMessageHeader2");
			cancel.setVisible(false);
			confim.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					hide();
				}
			});
		} else if (systemMsgType.getType() == SystemMsgType.Warning.getType()) {
			icon = new PreloadImage(warn, 35, 35);

			/* The header information */
			showTable.setText(0, 1, constants.warning());
			showTable.getRowFormatter().setStyleName(0, "tabelMessageHeader3");
			confim.removeStyleName("tabelMessageHeader1");
			confim.removeStyleName("tabelMessageHeader2");
			confim.addStyleName("tabelMessageHeader3");
			cancel.setVisible(false);
			confim.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					hide();
				}
			});
		}
		showTable.setWidget(0, 0, icon);
	}

	public void show() {
		glassBox.shows();
		dialogBox.shows();

	}

	public void hide() {
		glassBox.hides();
		dialogBox.hides();
	}


	@Override
	public void setListener(Listener l) {
		this.handler=l;
	}

	

	
}
