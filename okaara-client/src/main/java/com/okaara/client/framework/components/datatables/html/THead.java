package com.okaara.client.framework.components.datatables.html;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class THead extends ComplexPanel {

	public THead() {
		setElement(Document.get().createTHeadElement());
	}

	@Override
	public void add(Widget child) {
		super.add(child, (Element) getElement());
	}
}
