package com.infosys.ekart.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "userid", length = 20)
	private String userId;

	@Column(name = "emailid", length = 50)
	@NotNull
	private String emailId;

	@NotNull
	@Column(name = "name", length = 50)
	private String name;

	@NotNull
	@Column(name = "password", length = 50)
	private String password;

	@NotNull
	@Column(name = "accounttype")
	private String accountType;

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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
