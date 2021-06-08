package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import com.sprint.otms.models.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();
	
	public Customer updateCustomer(Customer customer);
	
	public boolean changePassword(String password);
	
	public void delete(Long id);
	
	public Optional<Customer> getCustomerById(Long id);
	
	public Optional<Customer> getCustomersByName(String userName);

}
