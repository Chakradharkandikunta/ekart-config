package com.infosys.ekart.account.dto;

public class LoginDTO {

	String userId;
	String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [User Id=" + userId + ", password=" + password + "]";
	}
}
