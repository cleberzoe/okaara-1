package com.okaara.client.application.login;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.bootbox.client.Bootbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.okaara.client.application.portal.PortalUX;
import com.okaara.client.framework.view.ApplicationManage;
import com.okaara.shared.client.model.Authorized;
import com.okaara.shared.client.model.User;

public class LoginUX extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, LoginUX> {
	}

	// protected @UiField Form formLogin;
	protected @UiField TextBox email;
	protected @UiField Input password;

	// protected @UiField Anchor forgotPassword;
	// protected @UiField Anchor register;
	protected @UiField Button login;
	protected @UiField Button clean;

	public LoginUX() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	protected void onLoad() {
		email.setFocus(true);
	}

	@UiHandler("login")
	public void onClickLogin(ClickEvent event) {
		authenticate();
	}

	@UiHandler("password")
	public void onKeyEnterEmail(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			authenticate();
		}
	}

	// private void authenticate() {
	// if (formLogin.validate()) {
	// authenticated();
	// }
	// }

	private void authenticate() {
		User user = new User(email.getText(), password.getText());

		LoginRequest service = GWT.create(LoginRequest.class);
		service.authenticate(user, new MethodCallback<Authorized>() {

			@Override
			public void onSuccess(Method method, Authorized response) {
				ApplicationManage.changeBody((Widget) GWT.create(PortalUX.class));
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				Bootbox.alert(exception.getMessage());
			}
		});
	}
}
