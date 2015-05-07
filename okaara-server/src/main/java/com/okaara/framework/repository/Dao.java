package com.okaara.framework.repository;

import org.springframework.stereotype.Component;

@Component
public abstract class Dao {

	/**
	 * Faz a busca de um objeto utilizandos as options informada como parâmetro na busca
	 * 
	 * @param key
	 * @param value
	 * @param entity
	 * @param options
	 * @return
	 */
	protected <T> T findOne(String key, String value, Class<T> entity) {
		return null;
	}

	protected <T> void insert(T t) {
	}

}
