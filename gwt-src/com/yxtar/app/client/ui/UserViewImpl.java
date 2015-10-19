package com.yxtar.app.client.ui;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.yxtar.app.base.framework.BaseSearchTablePageViewImpl;
import com.yxtar.app.base.framework.SearchTablePageView;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ValidationUtil;
import com.yxtar.app.client.i18n.UIConstants;

public class UserViewImpl extends BaseSearchTablePageViewImpl implements UserView {
	private AdminMap searchMap;
	private TextBox con1Box = new TextBox();
	private TextBox con2Box = new TextBox();
	private int max_result = 10;
	private UIConstants uiconstants = GWT.create(UIConstants.class);

	public UserViewImpl() {
		super();
		initWidget(rootPanel);
		con1Box.getElement().setAttribute("PlaceHolder", uiconstants.userEditForm()[0] + ":");
		con2Box.getElement().setAttribute("PlaceHolder", uiconstants.userEditForm()[1] + ":");
		deleteButton.setText(constants.delete());
		yesButton.setText(constants.yes());
		conTable.setWidget(0, 0, con1Box);
		conTable.setWidget(0, 1, con2Box);
		conTable.setWidget(0, 2, searchButton);
		conTable.setWidget(0, 3, conColse);
		yesButton.setVisible(false);

		splitLine.setVisible(false);

		showTable.removeFromParent();
		resultDiv.add(titleTable);
		resultDiv.add(showFlexTable);
		resultDiv.setStyleName("ui_edit_text_resultDiv");
		showFlexTable.setStyleName("ui_edit_text_showFlexTable");
		titleTable.setStyleName("ui_edit_user_showFlexTable_title");

	}

	@Override
	public void setTableHead() {
		 for (int i = 0; i < uiconstants.userShowTitle().length; i++) {
			 titleTable.setText(0, i, uiconstants.userShowTitle()[i]);
		 }
	}

	@Override
	public void update() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void initializeImpl() {
		searchMap = null;
		con1Box.setText("");
		con2Box.setText("");
		deleteModeFlag=false;
		selectedList.clear();
	}

	@Override
	public void refreshImpl() {
		if (deleteModeFlag) {
			deleteButton.addStyleName("delete_button_click_after");
		}else {
			deleteButton.removeStyleName("delete_button_click_after");
		}
		yesButton.setVisible(deleteModeFlag);
		addButton.setVisible(!deleteModeFlag);
		showFlexTable.removeAllRows();
	
		for (int i = 0; i < list.size(); i++) {
			final AdminMap certMap = (AdminMap) list.get(i);
			UserItem item = new UserItem(certMap);
			showFlexTable.setWidget(i, 0, item);
			showFlexTable.getFlexCellFormatter().getElement(i, 0).setAttribute("style", "width:100%;");
			item.addTextItemHandler(new UserItemHandler() {

				@Override
				public void onSelected() {
					if (deleteModeFlag) {

					} else {

						((SearchTablePageView.Presenter) presenter).onEdit(certMap);
					}
				}
			});
			for (int k = 0; k < selectedList.size(); k++) {
				AdminMap sup = (AdminMap) selectedList.get(k);
//				if (sup.getuId() == certMap.getuId()) {
//					item.setSelectedStyle(true, "widget_selected_tb");
//				}
			}
		}

	}

	/**
	 * Search Condition Map
	 */
	@Override
	public void setSearchData() {
		searchMap = new AdminMap();
//		searchMap.setuId(null);
//		searchMap.setuEmail(null);
//		if (ValidationUtil.getInstance().getInstance().isNumber(con1Box.getText())) {
//			searchMap.setuId(Integer.parseInt(con1Box.getText()));
//		}
//		if (ValidationUtil.getInstance().getInstance().StrNotNull(con2Box.getText())) {
//			searchMap.setuEmail(con2Box.getText());
//		}
	}

	@Override
	public Object getSearchObject() {
		return this.searchMap;
	}

	@Override
	public int getMaxResultPerPage() {
		return max_result;
	}

	@Override
	public void setDeleteModeFlag(boolean deleteModeFlag) {
		this.deleteModeFlag = deleteModeFlag;
	}

	public class UserItem extends Composite {
		private FlexTable itemTable = new FlexTable();
		private UserItemHandler userItemHandler;
		private Label idLabel = new Label("N/A");
		private Label emailLabel = new Label("N/A");
		private Label loginIDLabel = new Label("N/A");
		private Label firstLabel = new Label("N/A");
		private Label lastLabel = new Label("N/A");
		private AdminMap u;

		public UserItem(final AdminMap map) {
			initWidget(itemTable);
//			if (map != null) {
//				if (map.getuId() != null) {
//					idLabel.setText(map.getDisplayId() + "");
//				}
//				if (map.getuEmail() != null) {
//					emailLabel.setText(map.getuEmail());
//				}
//				if (map.getuNo()!=null) {
//					loginIDLabel.setText(map.getuNo());
//				}
//				if (map.getuName()!=null) {
//					firstLabel.setText(map.getuName());
//				}
//				if (map.getuSurName()!=null) {
//					lastLabel.setText(map.getuSurName());
//				}
//			}
			itemTable.setCellPadding(0);
			itemTable.setCellSpacing(0);
			itemTable.setWidget(0, 0, idLabel);
			itemTable.setWidget(0, 1, emailLabel);
			itemTable.setWidget(0, 2, loginIDLabel);
			itemTable.setText(0, 3, firstLabel.getText()+" "+lastLabel.getText());
			itemTable.setStyleName("select_normal_tb");
			itemTable.getFlexCellFormatter().getElement(0, 0).setAttribute("style", "width:25%;text-align:center;");
			itemTable.getFlexCellFormatter().getElement(0, 1).setAttribute("style", "width:25%;text-align:center;");
			itemTable.getFlexCellFormatter().getElement(0, 2).setAttribute("style", "width:25%;text-align:center;");
			itemTable.getFlexCellFormatter().getElement(0, 3).setAttribute("style", "width:25%;text-align:center;");
//			itemTable.addClickHandler(new ClickHandler() {
//
//				@Override
//				public void onClick(ClickEvent event) {
//					userItemHandler.onSelected();
//					if (showFlexTable.getCellForEvent(event) != null) {
//						if (map.getuId() > 0) {
//							u = new AdminMap();
//							u.setuId(Integer.parseInt(map.getuId() + ""));
//
//							if (deleteModeFlag) {
//								if (itemTable.getStyleName().contains("widget_selected_tb")) {
//									selectedList.remove(u);
//									int deleteIndex = -99;
//									for (int i = 0; i < selectedList.size(); i++) {
//										AdminMap temp = (AdminMap) selectedList.get(i);
//										if (temp.getuId().equals(u.getuId()) || temp.getuId() == u.getuId()) {
//											deleteIndex = i;
//										}
//									}
//									if (deleteIndex >= 0) {
//										selectedList.remove(deleteIndex);
//									}
//									setSelectedStyle(false, "widget_selected_tb");
//								} else {
//									selectedList.add(map);
//									setSelectedStyle(true, "widget_selected_tb");
//								}
//								userItemHandler.onSelected();
//							}
//						}
//					}
//				}
//			});
		}

		private void setSelectedStyle(boolean show, String style) {
			if (show) {
				itemTable.addStyleName(style);
			} else {
				itemTable.removeStyleName(style);
			}
		}

		public void addTextItemHandler(UserItemHandler textItemHandler) {
			this.userItemHandler = textItemHandler;
		}
	}

	public interface UserItemHandler {
		public void onSelected();
	}

}
