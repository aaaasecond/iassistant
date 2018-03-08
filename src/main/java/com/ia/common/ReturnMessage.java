package com.ia.common;

public enum ReturnMessage {
	USER_EXIST("exist"),
	USER_CREATED_SUCCESS("success"),
	USER_LOGIN_SUCCESS("loginSuccess"),
	USER_LOGIN_FALL("loginFail");
	
	
	private String message;
	private ReturnMessage(String message){
		this.setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
