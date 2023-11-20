package com.jsp.Springboot_GYM_App.exception;

public class MemberShipIdNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}
}
