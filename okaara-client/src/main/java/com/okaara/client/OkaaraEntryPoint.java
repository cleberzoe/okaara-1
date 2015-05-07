package com.okaara.client;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.okaara.client.application.login.LoginUX;
import com.okaara.client.framework.restygwt.RestygwtExceptionMapper;
import com.okaara.client.framework.view.ApplicationManage;

public class OkaaraEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		configureRestyGwt();
		initialize();
	}

	private void initialize() {
		ApplicationManage.changeBody((Widget) GWT.create(LoginUX.class));
	}

	private void configureRestyGwt() {
		Defaults.setServiceRoot(GWT.getHostPageBaseURL().concat("services/"));
		Defaults.setExceptionMapper(new RestygwtExceptionMapper());
	}

}
