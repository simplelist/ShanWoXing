package com.yxtar.server.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListResult<T extends Serializable> implements Serializable {
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

	public boolean isEmpty() {
		if (count==null||count<=0||dataList==null||dataList.size()<=0) {
			return true;
		}else {
			return false;
		}
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
