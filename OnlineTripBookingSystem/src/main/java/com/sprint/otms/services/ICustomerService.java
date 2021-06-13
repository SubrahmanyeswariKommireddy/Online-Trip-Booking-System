package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;

@Service
@Transactional
public interface ICustomerService extends IUserService {

	/**
	 * @param customer
	 * @return
	 */
	public Customer addCustomer(Customer customer);

	/**
	 * @return
	 */
	public List<Customer> getAllCustomer();

	/**
	 * @param customer
	 * @return
	 */
	public Customer updateCustomer(Customer customer);

	/**
	 * @param password
	 * @return
	 */
	public boolean changePassword(String password);

	/**
	 * @param id
	 * @return
	 */
	public String delete(Long id);

	/**
	 * @param id
	 * @return
	 */
	public Customer findCustomerById(Long id);

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws ValidationException
	 */
	public Customer updateCustomerPasswordById(Long id, String oldPassword, String newPassword)
			throws ValidationException;

	/**
	 * @param id
	 * @param oldMobileNo
	 * @param newMobileNo
	 * @return
	 * @throws ValidationException
	 */
	public Customer updateCustomerMobileNoById(Long id, Long oldMobileNo, Long newMobileNo) throws ValidationException;

	/**
	 * @param id
	 * @param oldEmail
	 * @param newEmail
	 * @return
	 * @throws ValidationException
	 */
	public Customer updateCustomerEmailById(Long id, String oldEmail, String newEmail) throws ValidationException;

//	public Optional<Customer> getCustomersByName(String userName);

}
