package com.yxtar.app.client.ui;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.yxtar.app.base.environment.SystemParams;
import com.yxtar.app.base.model.map.AdminMap;
import com.yxtar.app.base.utility.ValidationUtil;
import com.yxtar.app.base.widget.StatusWidget;
import com.yxtar.app.base.widget.SystemMsgType;
import com.yxtar.app.client.i18n.UIConstants;

/**
 * user edit viewImpl
 * 
 * @author jackshi
 * 
 */
public class UserEditViewImpl extends Composite implements UserEditView {

	private AdminMap beans = null;
	private Presenter presenter = null;
	private VerticalPanel root = new VerticalPanel();
	private FlexTable headTable = new FlexTable();
	private UIConstants constants = GWT.create(UIConstants.class);
	private Button backImage = new Button();
	private Button back = new Button();
	private Button save = new Button();

	private VerticalPanel beanPanel = new VerticalPanel();
	private SimplePanel titlePanel = new SimplePanel();
	private Label title = new Label();

	private HTML hr = new HTML("<hr class='ui_edit_split_hr'></hr>");
	private Label idlbl = new Label();
	private TextBox no = new TextBox();
	private TextBox emailBox = new TextBox();
	private TextBox firstNameBox = new TextBox();
	private TextBox lastNameBox = new TextBox();
	private PasswordTextBox passBox = new PasswordTextBox();
	private PasswordTextBox confirmPassBox = new PasswordTextBox();

	private StatusWidget statusWidget = null;
	private StatusWidget defultCheckBox = null;
	private FlexTable flexTable = new FlexTable();

	public UserEditViewImpl(SystemParams params) {
		initWidget(root);
		root.add(headTable);
		root.add(beanPanel);

		headTable.setWidget(0, 0, backImage);
		headTable.setWidget(0, 1, back);
		headTable.setWidget(0, 2, save);
		beanPanel.add(titlePanel);
		titlePanel.add(title);
		beanPanel.add(hr);
		beanPanel.add(flexTable);

		back.setText(constants.back());
		save.setText(constants.save());
		title.setText(constants.userMaintenance());

		String[] cols = constants.userEditForm();
		setColsName(cols);

		this.defultCheckBox = new StatusWidget(params.getConstants().selected(), params.getConstants().unSelected());
		this.statusWidget = new StatusWidget(params.getConstants().selected(), params.getConstants().unSelected());
		flexTable.setWidget(0, 1, idlbl);
		flexTable.setWidget(1, 1, no);
		flexTable.setWidget(2, 1, emailBox);
		flexTable.setWidget(3, 1, firstNameBox);
		flexTable.setWidget(4, 1, lastNameBox);
		flexTable.setWidget(5, 1, passBox);
		flexTable.setWidget(6, 1, confirmPassBox);
		flexTable.setWidget(7, 1, statusWidget);
		flexTable.setWidget(8, 1, defultCheckBox);
		flexTable.addStyleName("page_edit_table");
		flexTable.addStyleName("page_edit_table_user_edit");
		flexTable.setCellPadding(0);
		flexTable.setCellSpacing(0);
		for (int i = 0; i < constants.userEditForm().length; i++) {
			flexTable.getFlexCellFormatter().setStyleName(i, 0, "left_tr");
			flexTable.getFlexCellFormatter().setStyleName(i, 1, "right_tr");
		}
		root.setStyleName("ui_edit_root");
		headTable.setStyleName("ui_edit_headTable");
		backImage.setStyleName("ui_edit_headTable_back_img");
		back.setStyleName("ui_edit_headTable_back_button");
		save.setStyleName("ui_edit_headTable_save");

		beanPanel.setStyleName("ui_edit_user_beanPanel");
		titlePanel.setStyleName("ui_edit_picture_beanPanel_titlePanel");
		// flexTable.setStyleName("ui_edit_text_beanPanel_textFlexTable");

		backImage.addClickHandler(backHandler);
		back.addClickHandler(backHandler);

		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (check()) {
					updateDate();
					if (presenter != null) {
						presenter.update(beans);
					}
				}
			}

		});
	}

	/**
	 * set the edit table left TEXT;
	 * 
	 * @param cols
	 */
	private void setColsName(String... cols) {
		int i = 0;
		for (String string : cols) {
			flexTable.setText(i++, 0, string + ":");
		}
	}

	/**
	 * Validation the input is ok?
	 * 
	 * @return boolean validation is ok
	 */
	private boolean check() {
		boolean flag = false;
		/*
		 * check Email is ok
		 */
		if (ValidationUtil.getInstance().getInstance().StrNotNull(emailBox.getText())) {
			if (ValidationUtil.getInstance().getInstance().isEmail(emailBox.getText())) {
				flag = true;
			} else {
				flag = false;
				presenter.alert(SystemMsgType.Error, constants.checkEmail());
			}
		} else {
			flag = false;
			presenter.alert(SystemMsgType.Error, constants.checkEmptyEmail());
		}
		/**
		 * check firstName & lastName
		 */
		if (flag) {
			if (ValidationUtil.getInstance().getInstance().StrNotNull(firstNameBox.getText())) {
				if (ValidationUtil.getInstance().getInstance().isOperaLength(firstNameBox.getText(), 1, 20)) {
					flag = true;
				} else {
					flag = false;
					presenter.alert(SystemMsgType.Error, constants.checkFirstName());
				}
			} else {
				flag = false;
				presenter.alert(SystemMsgType.Error, constants.checkEmptyFirstName());
			}
			if (ValidationUtil.getInstance().getInstance().StrNotNull(lastNameBox.getText())) {
				if (ValidationUtil.getInstance().getInstance().isOperaLength(lastNameBox.getText(), 1, 20)) {
					flag = true;
				} else {
					flag = false;
					presenter.alert(SystemMsgType.Error, constants.checkLastName());
				}
			} else {
				flag = false;
				presenter.alert(SystemMsgType.Error, constants.checkEmptyLastName());
			}

		}

		/**
		 * check password & confirmPwd
		 */
		if (flag) {
			/**
			 * update or create
			 */
		
		}
		return flag;
	}

	/**
	 * check is ok,use this method update the beans,then presenter.update();
	 */
	private void updateDate() {
//		beans.setuNo(no.getText());
//		beans.setuEmail(emailBox.getText());
//		beans.setuName(firstNameBox.getText());
//		beans.setuSurName(lastNameBox.getText());
//		beans.setAdminUser(defultCheckBox.getValue() ? 1 : 0);
//		beans.setUserState(statusWidget.getValue() ? 1 : 0);
	}

	/**
	 * back button&img
	 */
	ClickHandler backHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
//			presenter.goTo(new UserPlace());
		}
	};

	@Override
	public void clearPageData() {
		/**
		 * clear the page input info
		 */
		this.emailBox.setText("");
		this.firstNameBox.setText("");
		this.idlbl.setText("N/A");
		this.lastNameBox.setText("");
		this.passBox.setText("");
		this.confirmPassBox.setText("");
		this.defultCheckBox.clean();
		this.statusWidget.clean();
		this.no.setText("");
	}

	@Override
	public void setAdminMap(AdminMap bean) {
		/**
		 * when get the bean ,set the info on page
		 */
		this.beans = bean;
//		if (bean != null && beans.getuId() != null) {
//			idlbl.setText(bean.getDisplayId());
//			no.setText(bean.getuNo());
//			emailBox.setText(bean.getuEmail());
//			firstNameBox.setText(bean.getuName());
//			lastNameBox.setText(bean.getuSurName());
//			statusWidget.setValue(bean.getUserState() == 1 ? true : false);
//			defultCheckBox.setValue(bean.getAdminUser() == 1 ? true : false);
//		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
