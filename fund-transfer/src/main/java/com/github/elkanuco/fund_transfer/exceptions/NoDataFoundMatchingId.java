package com.github.elkanuco.fund_transfer.exceptions;

public class NoDataFoundMatchingId extends Exception {
	private static final long serialVersionUID = 3612814960206681531L;
	public NoDataFoundMatchingId(String message) {
		super(message);
	}
}
