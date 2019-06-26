package com.infosys.ekart.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ekart.account.dto.LoginDTO;
import com.infosys.ekart.account.dto.UpdateUserDTO;
import com.infosys.ekart.account.dto.UserDTO;
import com.infosys.ekart.account.service.AccountService;

@RestController
public class AccountController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountService accountService;

	// Creates an user account
	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String signUp(@RequestBody UserDTO userDTO) {
		logger.info("Creating User with data {}", userDTO);
		String result;
		try {
			accountService.saveUser(userDTO);
			result = "User registered Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String login(@RequestBody LoginDTO loginDTO) {
		logger.info("Logging in with user Id {}", loginDTO.getUserId());
		return accountService.login(loginDTO);
	}

	// Updates the details of the user logged in
	@RequestMapping(value = "/{userId}/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String update(@PathVariable String userId, @RequestBody UpdateUserDTO updateUserDTO) {
		logger.info("Updating User {}", userId);
		String result;
		try {
			accountService.updateUser(userId, updateUserDTO);
			result = "User updated successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

}
