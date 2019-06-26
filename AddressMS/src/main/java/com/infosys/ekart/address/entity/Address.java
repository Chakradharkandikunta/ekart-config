package com.infosys.ekart.address.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@Column(name = "userid", length = 20)
	@NotNull
	private String userId;

	@Column(name = "address", length = 50)
	@NotNull
	private String address;

	@Column(name = "pincode", length = 6)
	@NotNull
	private Integer pincode;

	@Column(name = "state", length = 50)
	@NotNull
	private String state;

	@Column(name = "phonenumber", length = 10)
	@NotNull
	private Long phoneNumber;

	@Column(name = "city", length = 50)
	@NotNull
	private String city;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
