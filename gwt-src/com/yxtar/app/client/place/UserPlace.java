package com.yxtar.app.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UserPlace extends Place {

  public static class UserPlaceTokenizer implements PlaceTokenizer<UserPlace> {

    @Override
    public UserPlace getPlace(String token) {
      return new UserPlace();
    }

    @Override
    public String getToken(UserPlace place) {
      return "";
    }

  }

}
