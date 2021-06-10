package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;

@Service
@Transactional
public interface ICustomerService extends IUserService{

	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer updateCustomer(Customer customer);

	public boolean changePassword(String password);

	public String delete(Long id);

	public Customer findCustomerById(Long id);

//	public Optional<Customer> getCustomersByName(String userName);

}
