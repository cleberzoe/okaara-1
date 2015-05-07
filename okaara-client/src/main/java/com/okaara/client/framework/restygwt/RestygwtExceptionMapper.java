package com.okaara.client.framework.restygwt;

import org.fusesource.restygwt.client.ExceptionMapper;
import org.fusesource.restygwt.client.FailedStatusCodeException;
import org.fusesource.restygwt.client.Method;

import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class RestygwtExceptionMapper extends ExceptionMapper {

	@Override
	public Throwable createFailedStatusException(Method method, Response response) {

		String text = "";
		if (response.getText() != null && !response.getText().isEmpty()) {
			JSONObject json = JSONParser.parseStrict(response.getText()).isObject();
			JSONValue jsonValue = json.get("text");
			if (jsonValue.isString() != null) {
				text = jsonValue.isString().stringValue();
			}
		}

		return new FailedStatusCodeException(text, response.getStatusCode());
	}

	@Override
	public Throwable createNoResponseException() {
		return super.createNoResponseException();
	}

}
