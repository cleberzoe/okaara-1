package com.okaara.client.framework.components.datatables;

import com.google.gwt.i18n.client.DefaultCurrencyData;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;

public class MoneyTableColumn extends AbstractDataTableColumn {

	@Override
	public String format(JSONObject object) {
		if (object.containsKey(getKeyValue())) {
			JSONNumber number = object.get(getKeyValue()).isNumber();
			NumberFormat format = NumberFormat.getSimpleCurrencyFormat(new DefaultCurrencyData("4217", ""));
			return format.format(number.doubleValue());
		}
		return "";
	}

}
