package com.yxtar.server.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.yxtar.app.base.utility.ListResultMap;
import com.yxtar.server.dto.BaseDto;

@SuppressWarnings("serial")
public class List2ListResultMap<M extends IsSerializable> implements IsSerializable {
	@SuppressWarnings("rawtypes")
	private static List2ListResultMap util;

	@SuppressWarnings("rawtypes")
	public static List2ListResultMap getInstance() {
		if (util == null) {
			synchronized (List2ListResultMap.class) {
				if (util == null) {
					util = new List2ListResultMap();
				}
			}
		}
		return util;
	}

	private List2ListResultMap() {
	}

	@SuppressWarnings("unchecked")
	public ListResultMap<M> dtoToMap(ListResult dtoResult) {
		ListResultMap<M> mapListResult = null;
		if (dtoResult != null && dtoResult.getCount() > 0 && dtoResult.getDataList() != null && dtoResult.getDataList().size() > 0) {
			mapListResult=new ListResultMap<M>();
			List<M> mapList = new ArrayList<M>();
			for (Object f : dtoResult.getDataList()) {
				if (f != null) {
					mapList.add((M) ((BaseDto) f).generateMap());
				}
			}
			mapListResult.setDataList(mapList);
			mapListResult.setCount(mapList.size());
		}
		return mapListResult;
	}
}
