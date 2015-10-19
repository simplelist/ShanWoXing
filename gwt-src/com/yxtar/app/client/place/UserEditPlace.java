package com.yxtar.app.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UserEditPlace  extends Place {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEditPlace(Integer id) {
		this.id = id;
	}

	public static class UserEditPlaceTokenizer implements PlaceTokenizer<UserEditPlace> {

		@Override
		public UserEditPlace getPlace(String token) {
			return new UserEditPlace(Integer.valueOf(token));
		}

		@Override
		public String getToken(UserEditPlace place) {
			return place.getId() + "";
		}

	}
}
