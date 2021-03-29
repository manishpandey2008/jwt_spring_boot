package com.jwt.model;

public class ResponseMsg {
	String message;
	String status;
	public ResponseMsg() {
		super();
	}
	public ResponseMsg(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ResponseMsg [message=" + message + ", status=" + status + "]";
	}
	
	
	
}
