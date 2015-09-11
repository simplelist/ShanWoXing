package com.yxtar.app.base.environment;

import com.google.gwt.i18n.client.Constants;

public interface SystemConstants extends Constants {

  @DefaultStringValue("Save")
  String btnSave();

  @DefaultStringValue("Cancel")
  String btnCancel();

  @DefaultStringValue("Back")
  String btnBack();

}
