package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.CflowPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;
import com.sprint.otms.repositories.ICustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();		
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public String delete(Long id) {
		 customerRepository.deleteById(id);
		 return "success";
	}
	
//
//	public Optional<Customer> getCustomersByName(String userName) {
//		// TODO Auto-generated method stub
//		return customerRepository.findOne(userName);
//	}

	@Override
	public boolean changePassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.getById(id);
	}

}