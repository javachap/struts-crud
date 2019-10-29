package com.javachap.service.impl;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 2301643675735660187L;

	public ServiceException() {
	}

	public ServiceException(String arg0) {
		super(arg0);
	}

	public ServiceException(Throwable arg0) {
		super(arg0);
	}

	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
