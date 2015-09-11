package com.yxtar.app.base.utility;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ListResultMap<T extends IsSerializable> implements IsSerializable {
	private Integer count = 0;
	private List<T> dataList = new ArrayList<T>();

	public void setDataList(List<T> dataList) {
		if (dataList != null) {
			this.dataList = dataList;
		}
	}

	public List<T> getDataList() {
		return dataList;
	}


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isEmpty() {
		if (count==null||count<=0||dataList==null||dataList.size()<=0) {
			return true;
		}
		return false;
	}
}
