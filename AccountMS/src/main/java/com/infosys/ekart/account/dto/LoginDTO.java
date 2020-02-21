package com.infosys.ekart.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

	String userId;
	String password;

	/*
	 * public String getUserId() { return userId; }
	 * 
	 * public void setUserId(String userId) { this.userId = userId; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

	@Override
	public String toString() {
		return "LoginDTO [User Id=" + userId + ", password=" + password + "]";
	}
}
