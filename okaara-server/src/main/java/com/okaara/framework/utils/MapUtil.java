package com.okaara.framework.utils;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class MapUtil {

	public static <T> Map<String, Object> to(T params) {
		ObjectMapper m = new ObjectMapper();
		return m.convertValue(params, Map.class);
	}
}
