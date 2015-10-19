package com.yxtar.app.client.ui;

import java.util.List;

import com.yxtar.app.base.framework.SearchTablePageView;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.model.map.AdvertiserMap;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.app.shared.TestCassandra;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget. 
 * 
 */
public interface HomeView extends SearchTablePageView
{
	public void setList(List<TestCassandra> list);

	public void setAdminList(ListResultMap<AdminMap> result);

	public void setAdvertiserList(ListResultMap<AdvertiserMap> result);


}