package com.infosys.ekart.address.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.ekart.address.dto.AddressDTO;
import com.infosys.ekart.address.entity.Address;
import com.infosys.ekart.address.exception.AddressIdDoesNotExistsException;
import com.infosys.ekart.address.exception.AddressIdForUserDoesNotExistsException;
import com.infosys.ekart.address.exception.InvalidCityException;
import com.infosys.ekart.address.exception.InvalidPhoneNumberException;
import com.infosys.ekart.address.exception.InvalidPincodeException;
import com.infosys.ekart.address.exception.InvalidStateException;
import com.infosys.ekart.address.repository.AddressRepository;

@Service
public class AddressService {

	public static HashSet<String> states = new HashSet<String>();
	static {
		states.add("Andhra Pradesh");
		states.add("Arunachal Pradesh");
		states.add("Assam");
		states.add("Bihar");
		states.add("Chhattisgarh");
		states.add("Goa");
		states.add("Gujarat");
		states.add("Haryana");
		states.add("Himachal Pradesh");
		states.add("Jammu and Kashmir");
		states.add("Jharkhand");
		states.add("Karnataka");
		states.add("Kerala");
		states.add("Madhya Pradesh");
		states.add("Maharashtra");
		states.add("Manipur");
		states.add("Meghalaya");
		states.add("Mizoram");
		states.add("Nagaland");
		states.add("Odisha");
		states.add("Punjab");
		states.add("Rajasthan");
		states.add("Sikkim");
		states.add("Tamilnadu");
		states.add("Telangana");
		states.add("Tripura");
		states.add("Uttar Pradesh");
		states.add("Uttarakhand");
		states.add("West Bengal");
	}
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AddressRepository addressRepository;

	// Adding address for an user
	public void addAddress(AddressDTO addressDTO)
			throws InvalidPincodeException, InvalidStateException, InvalidPhoneNumberException, InvalidCityException {
		validateAddress(addressDTO);
		Address address = addressDTO.entityObject();
		addressRepository.saveAndFlush(address);
	}

	// View Address to modify
	public AddressDTO viewAddressToModify(Integer addressId, String userId)
			throws AddressIdForUserDoesNotExistsException {
		Address address = addressRepository.findByAddressIdAndUserId(addressId, userId);
		if (address == null) {
			throw new AddressIdForUserDoesNotExistsException("Address Id doesn't exist for the given user id");
		}
		AddressDTO addressDTO = AddressDTO.dtoObject(address);
		return addressDTO;

	}

	// Modifying address of an User by addressId
	public void modifyAddress(AddressDTO addressDTO) throws AddressIdDoesNotExistsException, InvalidPincodeException,
			InvalidStateException, InvalidPhoneNumberException, InvalidCityException {
		validateAddress(addressDTO);
		Address address = addressRepository.findByAddressIdAndUserId(addressDTO.getAddressId(), addressDTO.getUserId());
		if (address == null) {
			throw new AddressIdDoesNotExistsException("Address Id doesn't exist");
		}

		address = addressDTO.entityObject();
		addressRepository.saveAndFlush(address);
	}

	// Deleting Address of an user by addressId
	public void deleteAddress(Integer addressId) throws AddressIdDoesNotExistsException {
		Optional<Address> address = addressRepository.findById(addressId);
		if (!address.isPresent()) {
			throw new AddressIdDoesNotExistsException("Address Id doesn't exist");
		}
		addressRepository.deleteById(addressId);
	}

	// Get addresses of an user
	public List<AddressDTO> viewAddress(String userId) {
		logger.info("=====Viewing Addresses=======");
		List<Address> address_list = addressRepository.findByUserId(userId);
		List<AddressDTO> addressDTO_list = new ArrayList<AddressDTO>();
		for (Address address : address_list) {
			addressDTO_list.add(AddressDTO.dtoObject(address));
		}
		logger.info("Retrieved the address details of the user with user id {}", userId);

		return addressDTO_list;

	}

	public void validateAddress(AddressDTO addressDTO)
			throws InvalidPincodeException, InvalidStateException, InvalidPhoneNumberException, InvalidCityException {
		validatePincode(addressDTO.getPincode());
		validateState(addressDTO.getState());
		validatePhoneNumber(addressDTO.getPhoneNumber());
		validateCity(addressDTO.getCity());
	}

	/*
	 * Checks if the pin code is of length 6
	 */
	public void validatePincode(Integer pincode) throws InvalidPincodeException {
		if (pincode == null || pincode.toString().length() != 6)
			throw new InvalidPincodeException("Invalid Pincode");
	}

	/*
	 * Checks if the state is one among the 29 states of India
	 */
	public void validateState(String state) throws InvalidStateException {
		if (!AddressService.states.contains(state))
			throw new InvalidStateException("Invalid State provided");
	}

	/*
	 * Checks if phone number is valid
	 */
	public void validatePhoneNumber(Long phoneNumber) throws InvalidPhoneNumberException {
		String phone = phoneNumber.toString();
		if (phoneNumber == null || phone.length() != 10)
			throw new InvalidPhoneNumberException("Phone Number doesn't contain 10 digits");
	}

	/*
	 * Checks if city is valid
	 */
	public void validateCity(String city) throws InvalidCityException {
		for (int i = 0; i < city.length(); i++) {
			char single_character = city.charAt(i);
			if (!Character.isDigit(single_character) && !Character.isLetter(single_character)
					&& !Character.isWhitespace(single_character))
				throw new InvalidCityException("City is invalid");
		}
	}

}
