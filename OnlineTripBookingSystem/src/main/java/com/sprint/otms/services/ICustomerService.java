package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;

/**
 * 
 * @author Shourya
 *
 */
@Service
@Transactional
public interface ICustomerService extends IUserService {

	/**
	 * @param customer
	 * @return Customer
	 */
	public Customer addCustomer(Customer customer);

	/**
	 * @return all Customers
	 */
	public List<Customer> getAllCustomer();

	/**
	 * @param customer
	 * @return
	 */
	public Customer updateCustomer(Customer customer);

	/**
	 * @param password
	 * @return Changed Password
	 */
	public boolean changePassword(String password);

	/**
	 * @param id
	 * @return
	 */
	public String delete(Long id);

	/**
	 * @param id
	 * @return Customer Details By Customer Id
	 */
	public Customer findCustomerById(Long id);

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return Updated Customer Password
	 * @throws ValidationException
	 */
	public Customer updateCustomerPasswordById(Long id, String oldPassword, String newPassword)
			throws ValidationException;

	/**
	 * @param id
	 * @param oldMobileNo
	 * @param newMobileNo
	 * @return Updated Customer Mobile Number
	 * @throws ValidationException
	 */
	public Customer updateCustomerMobileNoById(Long id, Long oldMobileNo, Long newMobileNo) throws ValidationException;

	/**
	 * @param id
	 * @param oldEmail
	 * @param newEmail
	 * @return Updated Customer Email
	 * @throws ValidationException
	 */
	public Customer updateCustomerEmailById(Long id, String oldEmail, String newEmail) throws ValidationException;

}
