package com.yxtar.app.client.ui;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.shared.TestCassandra;

public class HomeViewImpl extends Composite implements HomeView {

	private FlowPanel root = new FlowPanel();
	private FlexTable showTable = new FlexTable();
	private AdvertiserMap map = new AdvertiserMap();

	public HomeViewImpl() {
		initWidget(root);
		root.add(showTable);
		showTable.addStyleName("table");
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


}
