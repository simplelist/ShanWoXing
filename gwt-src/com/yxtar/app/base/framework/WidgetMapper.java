package com.yxtar.app.base.framework;


public class WidgetMapper {

	private CommenClientFactory clientFactory;

	WidgetMapper(CommenClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public BaseSelectionPageActivity getActivity(Integer type) {
		if (type == SelectionWidgetEnum.UserSelect.getType()) {
//			return (BasePopupSelectionPageAcitivity) new PopPictureSelectActivity(clientFactory);
		}
		return null;
	}

}
