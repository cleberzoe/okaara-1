package com.okaara.client.framework.components.datatables;

import com.google.gwt.json.client.JSONObject;

public interface TableColumn {

	String getHeader();

	String getKeyValue();
	
	String format(JSONObject object);
}
