package com.yxtar.server.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Iterable2ListResult<F extends Serializable> implements Serializable{
	@SuppressWarnings("rawtypes")
	private static Iterable2ListResult util;

	@SuppressWarnings("rawtypes")
	public static Iterable2ListResult getInstance() {
		if (util == null) {
			synchronized (Iterable2ListResult.class) {
				if (util == null) {
					util = new Iterable2ListResult();
				}
			}
		}
		return util;
	}

	private Iterable2ListResult() {
	}


	public ListResult<F> caseToResult(Iterable<F> iterable) {
		ListResult<F> listResult = null;
		if (iterable != null) {
			List<F> list = new ArrayList<F>();
			listResult = new ListResult<F>();
			for (F object : iterable) {
				if (object != null) {
					list.add((F) object);
				}
			}
			listResult.setDataList(list);
			listResult.setCount(list.size());
		}
		return listResult;
	}
	
}
