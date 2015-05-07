package com.okaara.client.framework.components.datatables;

import org.gwtbootstrap3.client.ui.gwt.Widget;

import com.google.gwt.dom.client.Document;


public abstract class AbstractDataTableColumn extends Widget implements TableColumn {

	private String header;
	private String keyValue;
	
	public AbstractDataTableColumn() {
		setElement(Document.get().createDivElement());	
	}
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
}
