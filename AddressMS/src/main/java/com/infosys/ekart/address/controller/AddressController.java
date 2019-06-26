package com.infosys.ekart.address.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ekart.address.dto.AddressDTO;
import com.infosys.ekart.address.service.AddressService;

@RestController
public class AddressController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AddressService addressService;

	// Add address
	@RequestMapping(value = "/{userId}/address/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String addAddress(@PathVariable String userId, @RequestBody AddressDTO addressDTO) {
		String result = null;
		addressDTO.setUserId(userId);
		try {
			addressService.addAddress(addressDTO);
			result = "Address added Successfully";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// View Address to Modify
	@RequestMapping(value = "/{userId}/address/{addressId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressDTO viewAddressToModify(@PathVariable String userId, @PathVariable Integer addressId) {
		AddressDTO addressDTO = null;
		try {
			addressDTO = addressService.viewAddressToModify(addressId, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return new AddressDTO();
		}
		return addressDTO;
	}

	// Modify Address
	@RequestMapping(value = "/{userId}/address/{addressId}/modify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String modifyAddress(@PathVariable String userId, @PathVariable Integer addressId,
			@RequestBody AddressDTO addressDTO) {
		addressDTO.setUserId(userId);
		addressDTO.setAddressId(addressId);
		String result;
		try {
			addressService.modifyAddress(addressDTO);
			result = "Address modified successfully";
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	// Delete Address
	@RequestMapping(value = "/{userId}/address/{addressId}/delete", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteAddress(@PathVariable String userId, @PathVariable Integer addressId) {
		String result;
		try {
			addressService.deleteAddress(addressId);
			result = "Address deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	// View Addresses
	@RequestMapping(value = "/{userId}/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AddressDTO> viewAddress(@PathVariable String userId) {

		return addressService.viewAddress(userId);
	}

}
