package com.aggroup.dbguide;

public enum ResponseStatus {

	SUCCESSFUL("1"), INFORMATIONAL("2"), NOT_FOUND("3"), BAD_REQUEST("4"), SERVER_ERROR("5");

	private final String value;

	ResponseStatus(String value) {
		this.value = value;
	}

	/**
	 * Return the value of this status
	 */
	public String value() {
		return this.value;
	}
}
