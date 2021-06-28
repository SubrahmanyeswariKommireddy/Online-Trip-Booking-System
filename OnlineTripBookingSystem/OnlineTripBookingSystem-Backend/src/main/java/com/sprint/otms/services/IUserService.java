package com.sprint.otms.services;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.User;
import com.sprint.otms.models.User_Type;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Service
public interface IUserService {

	/**
	 * @param user
	 * @return User
	 */
	public User registerUser(User user);

	/**
	 * @param emailId
	 * @param password
	 * @param userType
	 * @return User Login status
	 */
	public User Login(String emailId, String password, User_Type userType);

	/**
	 * @param emailId
	 * @param password
	 * @param userType
	 * @return User Logout status
	 */
	public User Logout(String emailId, String password, User_Type userType);

}