package com.bkap.entity;

public class BkapRespone {
	private int code;
	private String message;
	
	
	public BkapRespone(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
