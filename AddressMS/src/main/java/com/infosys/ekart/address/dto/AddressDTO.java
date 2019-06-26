package com.infosys.ekart.address.dto;

import com.infosys.ekart.address.entity.Address;

public class AddressDTO {
	Integer addressId;
	String userId;
	String address;
	Integer pincode;
	String city;
	String state;
	Long phoneNumber;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	// Converts DTO into Entity
	public Address entityObject() {
		Address address = new Address();
		address.setAddressId(this.getAddressId());
		address.setAddress(this.getAddress());
		address.setCity(this.getCity());
		address.setState(this.getState());
		address.setPincode(this.getPincode());
		address.setPhoneNumber(this.getPhoneNumber());
		address.setUserId(this.getUserId());

		return address;
	}

	// Converts Entity into DTO
	public static AddressDTO dtoObject(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(address.getAddressId());
		addressDTO.setAddress(address.getAddress());
		addressDTO.setCity(address.getCity());
		addressDTO.setState(address.getState());
		addressDTO.setPincode(address.getPincode());
		addressDTO.setPhoneNumber(address.getPhoneNumber());
		addressDTO.setUserId(address.getUserId());

		return addressDTO;
	}

}
