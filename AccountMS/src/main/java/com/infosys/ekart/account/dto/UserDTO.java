package com.infosys.ekart.account.dto;

import com.infosys.ekart.account.entity.User;

public class UserDTO {

	String userId;

	String emailId;

	String name;

	String password;

	String confirmPassword;

	String accountType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	// Converts Entity into DTO
	public static UserDTO dtoObject(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setEmailId(user.getEmailId());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setAccountType(user.getAccountType());
		return userDTO;
	}

	// Converts DTO into Entity
	public User entityObject() {
		User user = new User();
		user.setUserId(this.userId);
		user.setEmailId(this.emailId);
		user.setName(this.name);
		user.setPassword(this.password);
		user.setAccountType(this.accountType);
		return user;
	}

	@Override
	public String toString() {
		return "UserDTO [ user Id: " + userId + " Email Id: " + emailId + " Name: " + name + " ]";
	}

}
