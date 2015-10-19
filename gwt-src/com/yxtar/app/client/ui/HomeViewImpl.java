package com.yxtar.app.client.ui;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.yxtar.app.base.framework.BaseSearchTablePageViewImpl;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.shared.TestCassandra;

public class HomeViewImpl extends BaseSearchTablePageViewImpl implements HomeView {

	private FlexTable showTable = new FlexTable();
	private AdvertiserMap map = new AdvertiserMap();

	private FlexTable showTable2 = new FlexTable();
	
	public HomeViewImpl() {
		super();
		initWidget(rootPanel);
		deleteButton.setText(constants.delete());
		yesButton.setText(constants.yes());
		conTable.setWidget(0, 3, searchButton);
		conTable.setWidget(0, 4, conColse);
		yesButton.setVisible(false);

		splitLine.setVisible(false);

		showTable.removeFromParent();
		resultDiv.add(titleTable);
		resultDiv.add(showTable);
		resultDiv.add(showTable2);
		resultDiv.setStyleName("ui_edit_text_resultDiv");
		showTable2.setStyleName("ui_edit_text_showFlexTable");
		showTable.setStyleName("ui_edit_text_showFlexTable");
		titleTable.setStyleName("ui_edit_user_showFlexTable_title");
	}

	@Override
	public void setList(List<TestCassandra> list) {
		showTable.clear();
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				showTable.setText(i, 0, list.get(i).getId().toString());
				showTable.setText(i, 1, list.get(i).getDisplayName());
			}
		}
	}

	@Override
	public void setAdminList(ListResultMap<AdminMap> result) {
		showTable.clear();
		if (!result.isEmpty()) {
			for (int i = 0; i < result.getDataList().size(); i++) {
				showTable.setText(i, 0, result.getDataList().get(i).getId()+"");
				showTable.setText(i, 1, result.getDataList().get(i).getEmail());
			}
		}
	}

	@Override
	public void setAdvertiserList(ListResultMap<AdvertiserMap> result) {
		showTable2.clear();
		if (!result.isEmpty()) {
			for (int i = 0; i < result.getDataList().size(); i++) {
				showTable2.setText(i, 0, result.getDataList().get(i).getId()+"");
				showTable2.setText(i, 1, result.getDataList().get(i).getCpersonEmail());
//				showTable2.setText(i, 2, result.getDataList().get(i).getMoneyInRecords());
			}
		}
	}

	@Override
	public int getMaxResultPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDeleteModeFlag(boolean deleteModeFlag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeImpl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshImpl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSearchData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTableHead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSearchObject() {
		// TODO Auto-generated method stub
		return null;
	}


}
