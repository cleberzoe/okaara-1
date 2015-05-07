package com.okaara.client.application.portal.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Content extends Composite {

	private static ContentUXUiBinder uiBinder = GWT.create(ContentUXUiBinder.class);

	interface ContentUXUiBinder extends UiBinder<Widget, Content> {
	}

	public Content() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	protected void onLoad() {
		initSidebar();
	}

	private native void initSidebar()/*-{
		$wnd.$(".has_sub > a").click(function(e) {
			e.preventDefault();
			var menu_li = $wnd.$(this).parent("li");
			var menu_ul = $wnd.$(this).next("ul");

			if (menu_li.hasClass("open")) {
				menu_ul.slideUp(350);
				menu_li.removeClass("open")
			} else {
				$wnd.$("#nav > li > ul").slideUp(350);
				$wnd.$("#nav > li").removeClass("open");
				menu_ul.slideDown(350);
				menu_li.addClass("open");
			}
		});
	}-*/;

}
