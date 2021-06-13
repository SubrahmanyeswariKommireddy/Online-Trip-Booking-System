package com.sprint.otms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.User;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.repositories.ICustomerRepository;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		if (user.getUserType() == User_Type.ADMIN) {
			Admin adm = new Admin();
			adm.setEmail(user.getEmail());
			adm.setMobileNumber(user.getMobileNumber());
			adm.setUserName(user.getUserName());
			adm.setPassword(user.getPassword());
			adm.setUserType(User_Type.ADMIN);
			adm.setPassword(user.getUserName());
			adm = adminRepository.save(adm);
		} else {
			Customer customer = new Customer();
			customer.setEmail(user.getEmail());
			customer.setMobileNumber(user.getMobileNumber());
			customer.setUserName(user.getUserName());
			customer.setPassword(user.getPassword());
			customer.setUserType(User_Type.CUSTOMER);
			customer.setPassword(user.getUserName());
			customer = customerRepository.save(customer);
		}
		return user;
	}

	@Override
	public User Login(String emailId, String password, User_Type userType) {
		// TODO Auto-generated method stub
		if (userType == User_Type.ADMIN) {
			Admin admin = (Admin) adminRepository.findByEmail(emailId);
			if (admin.getPassword() == password) {
				return admin;
			}
		} else {
			Customer customer = customerRepository.findByEmail(emailId);
			if (customer.getPassword() == password) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public User Logout(String emailId, String password, User_Type userType) {
		// TODO Auto-generated method stub
		if (userType == User_Type.ADMIN) {
			Admin admin = (Admin) adminRepository.findByEmail(emailId);
			if (admin.getPassword() == password) {
				return admin;
			}
		} else {
			Customer customer = customerRepository.findByEmail(emailId);
			if (customer.getPassword() == password) {
				return customer;
			}
		}
		return null;
	}
}
