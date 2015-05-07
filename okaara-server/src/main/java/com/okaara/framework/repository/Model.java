package com.okaara.framework.repository;

import java.util.HashMap;

public class Model extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	private Model() {
	}

	public static Model create() {
		return new Model();
	}

	public Model add(String key, Object value) {
		Model model = create();
		model.put(key, value);
		return model;
	}

}
