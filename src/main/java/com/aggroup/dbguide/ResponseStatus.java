package com.aggroup.dbguide;

public enum ResponseStatus {

		INFORMATIONAL("1"),
		SUCCESSFUL("2"),
		BAD_REQUEST("4"),
		SERVER_ERROR("5");
	
	private final String value;

	ResponseStatus(String value) {
		this.value = value;
	}

	/**
	 * Return the  value of this status
	 */
	public String value() {
		return this.value;
	}
}
