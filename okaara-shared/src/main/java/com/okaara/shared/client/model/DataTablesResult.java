package com.okaara.shared.client.model;

import java.util.List;

public class DataTablesResult<T> {
	private List<T> list;

	public DataTablesResult(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
