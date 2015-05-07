package com.okaara.client.framework.components.datatables.html;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class Tr extends ComplexPanel {
	public Tr() {
		setElement(Document.get().createTRElement());
	}

	@Override
	public void add(Widget child) {
		super.add(child, (Element) getElement());
	}
}
