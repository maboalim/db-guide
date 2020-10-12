package com.aggroup.dbguide;

public enum ResponseStatus {

	SUCCESSFUL("200"), INFORMATIONAL("100"), NOT_FOUND("404"), BAD_REQUEST("400"), SERVER_ERROR("500");

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
