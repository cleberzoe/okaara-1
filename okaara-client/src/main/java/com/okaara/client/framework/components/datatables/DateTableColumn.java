package com.okaara.client.framework.components.datatables;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;

public class DateTableColumn extends AbstractDataTableColumn {

	private DateTableColumnType type;

	@Override
	public String format(JSONObject object) {
		if (object.containsKey(getKeyValue())) {
			JSONNumber jsonValue = object.get(getKeyValue()).isNumber();
			long timemills = (long) jsonValue.doubleValue();
			Date date = new Date(timemills);

			DateTableColumnType type = getType() != null ? getType() : DateTableColumnType.SHORT;

			if (type.equals(DateTableColumnType.SHORT)) {
				return DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM).format(date);
			} else {
				return DateTimeFormat.getFormat(PredefinedFormat.DATE_LONG).format(date);
			}
		}
		return "";
	}

	public DateTableColumnType getType() {
		return type;
	}

	public void setType(DateTableColumnType type) {
		this.type = type;
	}
}
