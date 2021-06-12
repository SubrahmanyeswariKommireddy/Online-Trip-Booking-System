package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;
import com.sprint.otms.repositories.ICustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl extends UserServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

	public List<Customer> getAllCustomer() {
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

	@Override
	public Customer updateCustomerPasswordById(Long id, String oldPassword, String newPassword)
			throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Customer> customer = customerRepository.findById(id);
		if (customer != null) {
			if (customer.get().getPassword().equals(oldPassword)) {
				customer.get().setPassword(newPassword);
				return customerRepository.save(customer.get());
			} else {
				throw new ValidationException("Incorrect Password");
			}
		}
		return customer.get();
	}

	@Override
	public Customer updateCustomerMobileNoById(Long id, Long oldMobileNo, Long newMobileNo) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Customer> customer = customerRepository.findById(id);
		if (customer != null) {
			if (customer.get().getMobileNumber().equals(oldMobileNo)) {
				customer.get().setMobileNumber(newMobileNo);
				return customerRepository.save(customer.get());
			} else {
				throw new ValidationException("Incorrect MobileNumber");
			}
		}
		return customer.get();
	}

	@Override
	public Customer updateCustomerEmailById(Long id, String oldEmail, String newEmail) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Customer> customer = customerRepository.findById(id);
		if (customer != null) {
			if (customer.get().getEmail().equals(oldEmail)) {
				customer.get().setEmail(newEmail);
				return customerRepository.save(customer.get());
			} else {
				throw new ValidationException("Incorrect EmailId");
			}
		}
		return customer.get();
	}
}