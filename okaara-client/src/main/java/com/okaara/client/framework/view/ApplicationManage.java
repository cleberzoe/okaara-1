package com.okaara.client.framework.view;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationManage {

	public static <T extends Widget> void changeBody(T widget) {
		RootPanel.get().clear();
		RootPanel.get().add(widget);
	}
	
	/**
	 * add widget dentro da tag body
	 * 
	 * @param w
	 */
	public static <T extends Widget> void addBody(T w) {
		RootPanel rp = RootPanel.get();
		rp.add(w);
	}

	public static <T extends Widget> void removeBody(T w) {
		RootPanel.get().remove(w);
	}

}
