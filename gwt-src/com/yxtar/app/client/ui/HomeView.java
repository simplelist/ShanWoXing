package com.yxtar.app.client.ui;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.shared.TestCassandra;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget. 
 * 
 * @author drfibonacci
 */
public interface HomeView extends IsWidget
{
	public void setList(List<TestCassandra> list);

	public void setAdminList(ListResultMap<AdminMap> result);


}