package com.okaara.client.framework.components.datatables;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class TextTableColumn extends AbstractDataTableColumn {

	@Override
	public String format(JSONObject object) {
		if (object.containsKey(getKeyValue())) {
			JSONValue jsonValue = object.get(getKeyValue());
			
			if(jsonValue instanceof JSONNumber){
				JSONNumber number = jsonValue.isNumber();
				return number.toString();
				
			}else {
				JSONString string = jsonValue.isString();
				return string.stringValue();
			}
		}
		return "";
	}

}
