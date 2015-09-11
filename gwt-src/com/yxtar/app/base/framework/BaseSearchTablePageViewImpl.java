package com.yxtar.app.base.framework;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.yxtar.app.base.widget.PreloadImage;

/**
 * search map,result show
 * @author jackshi
 *
 */
public abstract class BaseSearchTablePageViewImpl extends BaseSelectionPageViewImpl implements SearchTablePageView {
	public abstract void setDeleteModeFlag(boolean deleteModeFlag);

	public FlexTable showFlexTable = new FlexTable();
	public Boolean deleteModeFlag = false;
	public PreloadImage conColse = new PreloadImage("./admin_ext_img/con_close.png", 46, 46);
	public Button conOpen = new Button();
	public FlowPanel buttonPanel = new FlowPanel();
	public FlowPanel rightBtnPanel = new FlowPanel();
	public Button addButton = new Button();
	public Button yesButton = new Button();

	public BaseSearchTablePageViewImpl() {
		super();
		operationTable.setStyleName("operation_table");
		deleteButton.setStyleName("operation_table_delete");
		rootPanel.setStyleName("ui_widget_rootPanel");
		searchButton.setText(constants.search());
		conOpen.setText(constants.search());
		addButton.setText(constants.add());
		conditionDiv.setStyleName("ui_search_condition_div_animotion");
		conOpen.setStyleName("ui_search_condition_div_animotion");
		conTable.setStyleName("ui_widget_conTable");
		splitLine.setVisible(true);
		resultDiv.setStyleName("ui_widget_resultDiv");
		resultHead.setStyleName("ui_widget_resultHead");
		showTable.setStyleName("ui_widget_showTable");
		opearPanel.setStyleName("ui_widget_opearPanel");
		confirmButton.setStyleName("ui_widget_confirmButton");

		bottom.setStyleName("widget_bottomPanel");
		pagePanel.setStyleName("widget_pagePanel");
		previousPageButton.setStyleName("widget_prePageButton");
		nextPageButton.setStyleName("widget_nextPageButton");
		currentPagePanel.setStyleName("widget_currentPanel");
		prePanel.setStyleName("widget_prePanel");
		nextPanel.setStyleName("widget_nextPanel");
		operationTable.setBorderWidth(0);
		operationTable.setCellPadding(0);
		operationTable.setCellSpacing(0);
		showFlexTable.setBorderWidth(0);
		showFlexTable.setCellPadding(0);
		showFlexTable.setCellSpacing(0);
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(conOpen);
		rightBtnPanel.add(yesButton);
		operationTable.setWidget(0, 0, buttonPanel);
		operationTable.setWidget(0, 1, rightBtnPanel);
		buttonPanel.setStyleName("ui_buttonPanel");
		rightBtnPanel.setStyleName("ui_rightBtnPanel");

		searchButton.setStyleName("ui_widget_searchButton");

		conditionDiv.getElement().setAttribute("style", "height:0;");
		conColse.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				conditionDiv.getElement().setAttribute("style", "height:0;");
				conOpen.setVisible(true);
			}
		});
		conOpen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				conditionDiv.getElement().setAttribute("style", "height:66px;");
				conOpen.setVisible(false);
			}
		});
		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				((SearchTablePageView.Presenter) presenter).onEdit(null);
			}
		});
		deleteButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (deleteModeFlag) {
					deleteModeFlag = false;
					selectedList.clear();
					deleteButton.removeStyleName("delete_button_click_after");
					refreshImpl();
				} else {
					deleteModeFlag = true;
					deleteButton.addStyleName("delete_button_click_after");
					refreshImpl();
				}
				yesButton.setVisible(deleteModeFlag);
				addButton.setVisible(!deleteModeFlag);
			}
		});
		yesButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				((SearchTablePageView.Presenter) presenter).confirmSelection(selectedList);
			}
		});
	}
}
