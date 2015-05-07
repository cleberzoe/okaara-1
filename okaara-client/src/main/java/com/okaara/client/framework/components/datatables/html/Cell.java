package com.okaara.client.framework.components.datatables.html;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class Cell extends Widget implements HasText {

	private Cell(Element el, String text) {
		setElement(el);
		this.setText(text);
	}

	public static Cell createTH(String text) {
		return new Cell(Document.get().createTHElement(), text);
	}
	
	public static Cell createTD(String text) {
		return new Cell(Document.get().createTDElement(), text);
	}

	@Override
	public String getText() {
		return getElement().getInnerText();
	}

	@Override
	public void setText(String text) {
		getElement().setInnerText(text);
	}
}