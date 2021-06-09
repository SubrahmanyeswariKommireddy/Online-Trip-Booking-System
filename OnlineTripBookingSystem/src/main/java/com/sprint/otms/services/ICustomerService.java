package com.sprint.otms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;

@Service
public interface ICustomerService {

	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer updateCustomer(Customer customer);

	public boolean changePassword(String password);

	public String delete(Long id);

	// public Optional<Customer> getCustomerById(Long id);
	public Customer findCustomerById(Long id);

//	public Optional<Customer> getCustomersByName(String userName);

}
