package com.yxtar.app.base.framework;

import java.util.List;

public interface SelectionPageEventHandler {
	public void onSelected(List<Object> selectedObjLst);

	public void onCancel();
}
