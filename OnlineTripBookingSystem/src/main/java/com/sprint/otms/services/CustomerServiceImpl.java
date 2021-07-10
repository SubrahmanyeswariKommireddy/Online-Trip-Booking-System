package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.exceptions.BusNotFoundException;
import com.sprint.otms.exceptions.CustomerNotFoundException;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.BusBooking;
import com.sprint.otms.models.Customer;
import com.sprint.otms.repositories.ICustomerRepository;

/**
 * 
 * @author Shourya
 *
 */
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
		Optional<Customer> c= customerRepository.findById(customer.getId());
		if(c!=null) {
			c.get().setMobileNumber(customer.getMobileNumber());
			
			return customerRepository.save(c.get());
		}
		else {
			throw new CustomerNotFoundException();
		}
	}

	public String delete(Long id) {
		customerRepository.deleteById(id);
		return "success";
	}

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
	
	@Override
	public Customer addBooking(Long id,BusBooking booking) {
		// TODO Auto-generated method stub
		Optional<Customer> c= customerRepository.findById(id);
		if(c!=null) {
			System.out.println("customer");
			List<BusBooking> list=c.get().getBooking();
			list.add(booking);
			c.get().setBooking(list);
			 return customerRepository.save(c.get());
		}
		return null;	
	}
	
	@Override
	public List<Customer> getAllBookings() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
}