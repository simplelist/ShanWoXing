package com.yxtar.app.base.framework;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.yxtar.app.base.constants.WidgetsConstants;
import com.yxtar.app.base.widget.PreloadImage;

public abstract class BaseSelectionPageViewImpl extends Composite implements SelectionPageView {

	/**
	 * define the UI object
	 */
	public FlowPanel root = new FlowPanel();
	public VerticalPanel rootPanel = new VerticalPanel();
	public WidgetsConstants constants = GWT.create(WidgetsConstants.class);
	public List<Object> list = new ArrayList<Object>();
	public List<Object> selectedList = new ArrayList<Object>();
	public FlowPanel headTitlePanel = new FlowPanel();
	public FlowPanel closePanel = new FlowPanel();
	public Image closeimg = new Image("./admin_ext_img/close.png");
	public SimplePanel simTitle = new SimplePanel();

	public FlexTable noResult = new FlexTable();
	private PreloadImage noImage = new PreloadImage("./admin_ext_img/noresult.png", 150, 150);
	private Label sorryLabel = new Label();
	private Label sorryData = new Label();
	public SimplePanel conditionDiv = new SimplePanel();
	public FlexTable conTable = new FlexTable();
	public FlowPanel contentPanel = new FlowPanel();
	public Button searchButton = new Button();

	public FlowPanel resultDiv = new FlowPanel();
	public FlexTable resultHead = new FlexTable();
	public FlexTable showTable = new FlexTable();
	public HorizontalPanel bottom = new HorizontalPanel();
	public Button confirmButton = new Button();

	public FlexTable operationTable = new FlexTable();
	public HorizontalPanel pagePanel = new HorizontalPanel();
	public SimplePanel nextPanel = new SimplePanel();
	public SimplePanel prePanel = new SimplePanel();
	public Button nextPageButton = new Button();
	public Button previousPageButton = new Button();
	public HorizontalPanel currentPagePanel = new HorizontalPanel();
	public Presenter presenter;
	public int currentPageIndex = 1;
	public int totalNumOfPage = 0;
	public FlowPanel loadingPanel;
	public boolean multipleSelectionFlag;
	public HorizontalPanel opearPanel = new HorizontalPanel();
	public HTML splitLine = new HTML("<hr class='ui_split_line'/>");
	public HTML pageSplitLine = new HTML("<hr class='ui_pageSplitLine'/>");

	private HorizontalPanel jumpPanel = new HorizontalPanel();
	public Label jumpTo = new Label();
	public TextBox jumpToBox = new TextBox();
	public Button jumpConfirm = new Button();
	public SelectionPageEventHandler handler;
	public FlexTable titleTable = new FlexTable();
	public Button deleteButton = new Button();

	/**
	 * constructor build the UI and General Handler
	 */
	public BaseSelectionPageViewImpl() {
		root.add(closePanel);
		root.add(rootPanel);
		root.getElement().setAttribute("style", "width:1000px;margin:0px auto;");
		closePanel.getElement().setAttribute("style", "float:right;");
		closeimg.getElement().setAttribute("style", "width:60px;height:60px;cursor:pointer;");
		noResult.getElement().setAttribute("id", "noresult");
		closePanel.add(closeimg);
		confirmButton.setText(constants.confirm());
		jumpConfirm.setText(constants.confirm());
		jumpTo.setText(constants.jump());
		showTable.setBorderWidth(0);
		showTable.setCellPadding(0);
		showTable.setCellSpacing(0);
		noResult.setBorderWidth(0);
		noResult.setCellPadding(0);
		noResult.setCellSpacing(0);
		rootPanel.add(headTitlePanel);
		headTitlePanel.add(simTitle);
		operationTable.setBorderWidth(0);
		operationTable.setCellPadding(0);
		operationTable.setCellSpacing(0);

		noResult.setWidget(0, 0, noImage);
		noResult.setWidget(1, 0, sorryLabel);
		sorryLabel.setStyleName("noresult_sorry");
		noResult.setWidget(2, 0, sorryData);
		sorryLabel.setText(constants.sorry());
		sorryData.setText(constants.noresult());
		rootPanel.add(conditionDiv);
		conditionDiv.add(conTable);
		prePanel.add(previousPageButton);
		nextPanel.add(nextPageButton);
		rootPanel.add(operationTable);
		rootPanel.add(contentPanel);
		rootPanel.add(splitLine);
		rootPanel.add(resultDiv);
		resultDiv.add(showTable);
		resultDiv.add(noResult);
		splitLine.setVisible(false);
		noResult.setVisible(false);
		splitLine.setStyleName("html_ui_split_line");
		rootPanel.add(pageSplitLine);
		rootPanel.add(bottom);
		bottom.add(pagePanel);
		bottom.add(opearPanel);

		opearPanel.add(confirmButton);
		pagePanel.add(prePanel);
		pagePanel.add(currentPagePanel);
		pagePanel.add(nextPanel);
		pagePanel.add(jumpPanel);

		jumpPanel.add(jumpTo);
		jumpPanel.add(jumpToBox);
		jumpPanel.add(jumpConfirm);

		jumpTo.setStyleName("widget_bottomPage_jumpTo_label");
		jumpToBox.setStyleName("widget_bottomPage_jumpTo_box");
		jumpConfirm.setStyleName("widget_bottomPage_jumpTo_button");

		confirmButton.setVisible(false);

		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				setSearchData();
				currentPageIndex = 1;
				presenter.search(getSearchObject(), getMaxResultPerPage(), currentPageIndex);
			}
		});

		previousPageButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				currentPageIndex--;
				goPage();
			}
		});
		nextPageButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				currentPageIndex++;
				goPage();
			}
		});
		jumpConfirm.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				currentPageIndex = 1;
				if (jumpToBox.getText().matches("\\d{1,10}")) {
					currentPageIndex = Integer.valueOf(jumpToBox.getText());
				}
				jumpToBox.setText("");
				goPage();
			}
		});

		confirmButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.confirmSelection(selectedList);
				// presenter.close();
			}
		});

	}

	/**
	 * init the data for example : search map,textBox,ListBox
	 */
	public void initialize() {
		this.initializeImpl();
		list.clear();
		selectedList.clear();

		showTable.clear();
		currentPageIndex = 1;
		confirmButton.setVisible(false);
	};

	public abstract void initializeImpl();

	/**
	 * refresh the showTable data from list
	 */
	public void refresh() {
		showTable.removeAllRows();
		setTableHead();
		showTable.setVisible(list.size() > 0);
		noResult.setVisible(!(list.size() > 0));
		setCurrentPageButton(currentPageIndex);
		this.refreshImpl();
	};

	public abstract void refreshImpl();

	/**
	 * 
	 * set the totalNumOfPage *@param totalNumOfPage
	 */
	public void setTotalNumOfPage(int totalNumOfPage) {
		this.totalNumOfPage = totalNumOfPage;
		jumpPanel.setVisible(totalNumOfPage > 5);
	}

	/**
	 * 
	 * set the currentPageIndex *@param currentPageIndex
	 */
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	};

	/**
	 * set the showList by return List * @param List<Object> dataLst
	 */
	public void setDisplayData(List<Object> dataLst) {
		list.clear();
		if (dataLst != null) {
			if (dataLst.size() > 0) {
				sethasResult();
				for (Object sMap : dataLst) {
					list.add(sMap);
				}
			} else {
				setNoResult();
			}
		} else {
			setNoResult();
		}
	}

	/**
	 * search condition map
	 */
	public abstract void setSearchData();

	/**
	 * init the showTable table head
	 */
	public abstract void setTableHead();

	public void setPresenter(SelectionPageView.Presenter presenter) {
		this.presenter = presenter;
	};

	/**
	 * if no data
	 */
	public void setNoResult() {
		deleteButton.setVisible(false);
		titleTable.setVisible(false);
		resultDiv.add(noResult);
		showTable.setVisible(false);
		noResult.setVisible(true);
		bottom.setVisible(false);
	}

	public void sethasResult() {
		deleteButton.setVisible(true);
		titleTable.setVisible(true);
		resultDiv.add(showTable);
		showTable.setVisible(true);
		noResult.setVisible(false);
		bottom.setVisible(true);
	}

	/**
	 * multi select flag true :select more than one false :select one * @param
	 * multipleSelectionFlag
	 */
	public void setMultipleSelectionFlag(boolean multipleSelectionFlag) {
		this.multipleSelectionFlag = multipleSelectionFlag;
	}

	/**
	 * go to current page
	 */
	public void goPage() {
		if (currentPageIndex >= totalNumOfPage) {
			currentPageIndex = totalNumOfPage;
		}
		if (currentPageIndex < 1) {
			currentPageIndex = 1;
		}
		presenter.search(this.getSearchObject(), getMaxResultPerPage(), currentPageIndex);
	}

	/**
	 * get the Search ConditionMap
	 * 
	 * @return
	 */
	public abstract Object getSearchObject();

	/**
	 * if multi select ,set background-color
	 * 
	 * @param row
	 * @param show
	 */
	public void setSelecteRowStyle(int row, boolean show) {
		if (show) {
			showTable.getRowFormatter().setStyleName(row, "widget_search_seleted_row");
		} else {
			showTable.getRowFormatter().removeStyleName(row, "widget_search_seleted_row");
		}
	}

	/**
	 * 1,2,3,4,5 currentPage max is 5 for example 4,5,6,7,8 click this button
	 * goPage is current
	 * 
	 * @param start
	 */
	public void setCurrentPageButton(int start) {
		currentPagePanel.clear();
		nextPageButton.setVisible(currentPageIndex < totalNumOfPage);
		previousPageButton.setVisible(currentPageIndex > 1);
		if (totalNumOfPage == 1) {
			nextPageButton.setVisible(false);
			previousPageButton.setVisible(false);
		}
		List<Integer> pages = new ArrayList<Integer>();
		int MAX_PAGERS = 5;
		for (int i = 1; i <= totalNumOfPage; i++) {
			pages.add(i);
		}
		if (pages.size() > MAX_PAGERS) {
			// totalpages > MAX_PAGERS
			if (pages.size() - MAX_PAGERS < MAX_PAGERS / 2 + 1) {
				pages.clear();
				pages.add(start - 4);
				pages.add(start - 3);
				pages.add(start - 2);
				pages.add(start - 1);
				pages.add(start);
			}
			if (start > MAX_PAGERS / 2 + 1) {
				pages.clear();
				pages.add(start - 2);
				pages.add(start - 1);
				pages.add(start);
				pages.add(start + 1);
				pages.add(start + 2);
			} else {
				pages.clear();
				for (int i = 1; i < MAX_PAGERS + 1; i++) {
					pages.add(i);
				}
			}
		}

		for (Integer i : pages) {
			final Button cButton = new Button();
			if (i <= totalNumOfPage) {
				cButton.setText(i + "");
				currentPagePanel.add(cButton);
			}
			if (currentPageIndex == i) {
				cButton.addStyleName("current_page_button");
			}
			cButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					currentPageIndex = Integer.parseInt(cButton.getText().trim());
					if (currentPageIndex == Integer.parseInt(cButton.getText())) {
						goPage();
					}
				}
			});
		}
	}

	public int getPageIndex() {
		return this.currentPageIndex;
	}

	public void setSelectionPageEventHandler(SelectionPageEventHandler handler) {
		this.handler = handler;
	};
}
