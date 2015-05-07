package com.okaara.client.application.portal.banner;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Banner extends Composite {

	private static BannerUXUiBinder uiBinder = GWT.create(BannerUXUiBinder.class);

	interface BannerUXUiBinder extends UiBinder<Widget, Banner> {
	}

	public Banner() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
