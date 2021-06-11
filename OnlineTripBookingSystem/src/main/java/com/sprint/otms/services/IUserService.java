package com.sprint.otms.services;

import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.User;
import com.sprint.otms.models.User_Type;

@Service
public interface IUserService {
	
    public User registerUser(User user);
	
	public User Login(String emailId,String password, User_Type userType);
	
	public User Logout(String emailId,String password,User_Type userType);
	
}