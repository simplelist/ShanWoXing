
package com.yxtar.app.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.yxtar.app.client.ClientFactory;
import com.yxtar.app.client.activity.HomeActivity;
import com.yxtar.app.client.place.HomePlace;


/**
 * 
 */
public class PhoneActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public PhoneActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return new HomeActivity((HomePlace)place, clientFactory);
		}
		return new HomeActivity((HomePlace)place, clientFactory);
	}
}
