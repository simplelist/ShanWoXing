package com.yxtar.app.base.framework;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.yxtar.app.base.widget.FixPopupPanel;
/**
 * popup widget
 * @author jackshi
 *
 */
public abstract class BasePopupSelectionPageViewImpl extends BaseSelectionPageViewImpl implements PopupSelectionPageView {
	private FixPopupPanel dialogBox = new FixPopupPanel(false, true);
	private FixPopupPanel glassBox = new FixPopupPanel(true, true);
	private Button closeButton = new Button();
	private Image searchimg = new Image("./admin_ext_img/search1.png");
	public Label searchlbl = new Label();
	public Label headTitle = new Label();
	public HorizontalPanel searchPanel = new HorizontalPanel();
	public BasePopupSelectionPageViewImpl() {
		super();
		rootPanel.setStyleName("widget_rootPanel");
		conTable.setStyleName("widget_conTable");
		conTable.addStyleName("supplierSelectWidget_conTable");
		resultDiv.setStyleName("widget_resultDiv");
		resultHead.setStyleName("widget_resultHead");
		showTable.setStyleName("widget_showTable");
		opearPanel.setStyleName("widget_opearPanel");
		confirmButton.setStyleName("widget_confirmButton");
		searchlbl.setText(constants.search());
		 
		bottom.setStyleName("widget_bottomPanel");
		pagePanel.setStyleName("widget_pagePanel");
		previousPageButton.setStyleName("widget_prePageButton");
		nextPageButton.setStyleName("widget_nextPageButton");
		currentPagePanel.setStyleName("widget_currentPanel");
		prePanel.setStyleName("widget_prePanel");
		nextPanel.setStyleName("widget_nextPanel");

		searchButton.setStyleName("widget_searchButton");
		searchPanel.add(searchimg);
		searchPanel.add(searchlbl);
		searchPanel.setStyleName("common_search_panel");
		searchlbl.removeStyleName("gwt-Label");
		closeButton.setStyleName("widget_closeButton");
		headTitle.setStyleName("widget_headTitle");
		headTitlePanel.setStyleName("widget_headTitlePanel");
		headTitlePanel.add(closeButton);
		simTitle.add(headTitle);
		closeimg.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				((PopupSelectionPageView.Presenter) presenter).cancel();
			}
		});
		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				((PopupSelectionPageView.Presenter) presenter).cancel();
			}
		});
		confirmButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.confirmSelection(selectedList);
				close();
			}
		});
	 

		showTable.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int column = showTable.getCellForEvent(event).getCellIndex();
				int row = showTable.getCellForEvent(event).getRowIndex();
				if (row > 0) {

					if (multipleSelectionFlag) {
						// multiple Select
						if (!showTable.getText(row, column).equals("") && showTable.getText(row, column) != null) {
							if (row <= list.size()) {
								Object map = list.get(row - 1);
								if (showTable.getRowFormatter().getStyleName(row).equals("widget_search_seleted_row")) {
									setSelecteRowStyle(row, false);
									selectedList.remove(map);
								} else {
									setSelecteRowStyle(row, true);
									selectedList.add(map);
								}
								confirmButton.setVisible(selectedList.size() > 0);
							}
						}
					} else {
						// not multiple
						selectedList.clear();
						if (!showTable.getText(row, column).equals("") && showTable.getText(row, column) != null) {
							if (row <= list.size()) {
								Object map = list.get(row - 1);
								selectedList.add(map);
								// handler.onSelected(selectedList);
								// close();
							}
						}
					}

				}
			}
		});

	}

	public void show() {
		glassBox.shows();
		dialogBox.shows();
		dialogBox.clear();
		dialogBox.add(this);
	};

	public void close() {
		glassBox.hides();
		dialogBox.hides();
	}
}
