package com.jwt.model;

public class TokenResponse {
	boolean check;

	public TokenResponse() {
		super();
	}

	public TokenResponse(boolean check) {
		super();
		this.check = check;
	}
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	@Override
	public String toString() {
		return "TokenResponse [check=" + check + "]";
	}
}
