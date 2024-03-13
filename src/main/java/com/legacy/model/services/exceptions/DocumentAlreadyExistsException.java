package com.legacy.model.services.exceptions;

public class DocumentAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 1L;

	public DocumentAlreadyExistsException(String msg) {
		super(msg);
	}
}
