package com.infosys.ekart.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
	String name;

	String password;

	String confirmPassword;

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * public String getConfirmPassword() { return confirmPassword; }
	 * 
	 * public void setConfirmPassword(String confirmPassword) { this.confirmPassword
	 * = confirmPassword; }
	 */

}
