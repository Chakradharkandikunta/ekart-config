package com.infosys.ekart.account.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.ekart.account.dto.LoginDTO;
import com.infosys.ekart.account.dto.UpdateUserDTO;
import com.infosys.ekart.account.dto.UserDTO;
import com.infosys.ekart.account.entity.User;
import com.infosys.ekart.account.exception.AllFieldsMandatoryException;
import com.infosys.ekart.account.exception.ConfirmPasswordMismatchException;
import com.infosys.ekart.account.exception.EmailIdAlreadyExistsException;
import com.infosys.ekart.account.exception.InvalidCharacterInNameException;
import com.infosys.ekart.account.exception.InvalidPasswordException;
import com.infosys.ekart.account.exception.UserIdAlreadyExistsException;
import com.infosys.ekart.account.exception.UserIdDoesNotExistException;
import com.infosys.ekart.account.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	// Creates an User account
	public void saveUser(UserDTO userDTO)
			throws UserIdAlreadyExistsException, EmailIdAlreadyExistsException, AllFieldsMandatoryException,
			InvalidCharacterInNameException, InvalidPasswordException, ConfirmPasswordMismatchException {

		validateUser(userDTO);
		User user = userDTO.entityObject();
		accountRepository.save(user);
	}

	// Login Service
	public String login(LoginDTO loginDTO) {
		Optional<User> user = accountRepository.findById(loginDTO.getUserId());
		if (user != null && user.get().getPassword().equals(loginDTO.getPassword())) {
			return "User successfully logged in";
		}
		return "Invalid User details";
	}

	// Updates User account
	public void updateUser(String userId, UpdateUserDTO updateUserDTO) throws InvalidPasswordException,
			ConfirmPasswordMismatchException, UserIdDoesNotExistException, InvalidCharacterInNameException {
		Optional<User> optional_user = accountRepository.findById(userId);
		if (optional_user.isPresent()) {
			validateName(updateUserDTO.getName());
			validatePassword(updateUserDTO.getPassword());
			validateConfirmPassword(updateUserDTO.getPassword(), updateUserDTO.getConfirmPassword());
			User user = optional_user.get();
			user.setName(updateUserDTO.getName());
			user.setPassword(updateUserDTO.getPassword());
			accountRepository.saveAndFlush(user);
		} else
			throw new UserIdDoesNotExistException("User Id doesn't exist");
	}

	// Validating User data
	public void validateUser(UserDTO userDTO)
			throws UserIdAlreadyExistsException, EmailIdAlreadyExistsException, AllFieldsMandatoryException,
			InvalidCharacterInNameException, InvalidPasswordException, ConfirmPasswordMismatchException {

		validateMandatoryFields(userDTO);
		validateUserId(userDTO.getUserId());
		validateEmailId(userDTO.getEmailId());
		validateName(userDTO.getName());
		validatePassword(userDTO.getPassword());
		validateConfirmPassword(userDTO.getPassword(), userDTO.getConfirmPassword());

	}

	/*
	 *
	 * Checks if any field is empty
	 * 
	 */
	public void validateMandatoryFields(UserDTO userDTO) throws AllFieldsMandatoryException {

		if (userDTO.getEmailId() == null || userDTO.getName() == null || userDTO.getPassword() == null
				|| userDTO.getConfirmPassword() == null || userDTO.getAccountType() == null)
			throw new AllFieldsMandatoryException(
					"All fields are mandatory during signup. Please provide all details and sign up again");
	}

	/*
	 * 
	 * Checks if the user id already exists
	 * 
	 */
	public void validateUserId(String userId) throws UserIdAlreadyExistsException {
		Optional<User> optional_user = accountRepository.findById(userId);
		logger.info("Getting user info with user id {} and is Present : {}", userId, optional_user.isPresent());
		if (optional_user.isPresent())
			throw new UserIdAlreadyExistsException("User Id already exists");

	}

	/*
	 * 
	 * Checks if email Id already Used by any other user
	 * 
	 */
	public void validateEmailId(String emailId) throws EmailIdAlreadyExistsException {
		User user = accountRepository.findByEmailId(emailId);
		if (user != null)
			throw new EmailIdAlreadyExistsException("Email Id already exists");
	}

	/*
	 * 
	 * Checks if name is valid
	 *
	 */
	public void validateName(String name) throws InvalidCharacterInNameException {
		if (!name.matches("^[a-zA-Z]*$"))
			throw new InvalidCharacterInNameException("Name should only contain alphabets");
	}

	/*
	 *
	 * Checks if password is valid
	 * 
	 */
	public void validatePassword(String password) throws InvalidPasswordException {

		if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W])(?=\\S+$).{4,50}$"))
			throw new InvalidPasswordException("Password doesn't match required criteria.");

	}

	/*
	 * 
	 * Checks if password and confirm password matches
	 * 
	 */
	public void validateConfirmPassword(String password, String confirmPassword)
			throws ConfirmPasswordMismatchException {

		if (!password.equals(confirmPassword))
			throw new ConfirmPasswordMismatchException("Password and Confirm Password doesn't match");
	}

}
