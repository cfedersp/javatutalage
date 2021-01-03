package org.cjf.demo.models;

public class WelcomeResponse {
	private String message;
	private Integer errorCode;
	
	public WelcomeResponse(String msg, Integer err) {
		this.message = msg;
		this.errorCode = err;
	}
	
	public String getMessage() {
		return message;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
}