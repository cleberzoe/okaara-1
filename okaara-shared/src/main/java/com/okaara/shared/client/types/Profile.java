package com.okaara.shared.client.types;


public enum Profile implements HasType {

	BRONZE("Bronze"), SILVER("Silver"), GOLD("Gold");

	private String type;

	private Profile(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

}
