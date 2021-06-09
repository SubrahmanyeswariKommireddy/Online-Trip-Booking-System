//package com.sprint.otms.controllers;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sprint.otms.models.Admin;
//import com.sprint.otms.models.Customer;
//import com.sprint.otms.services.CustomerServiceImpl;
//
//@RestController
//public class CustomerController {
//	
//	@Autowired
//	private CustomerServiceImpl customerServiceImpl;
//	
//	@PostMapping("/addCustomer")
//	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//		return new ResponseEntity<>(customerServiceImpl.addCustomer(customer), HttpStatus.OK);
//	}
//	
//	@PatchMapping("/updateCustomer/{id}")
//	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
//	 Customer newCustomer = customerServiceImpl.updateCustomer(customer);
//	 return new ResponseEntity<>(newCustomer, HttpStatus.OK);
//	}
//	
//	@GetMapping("/customer")
//	public List<Customer> get() {
//		return customerServiceImpl.getAllCustomers();
//	}
//	
//	@GetMapping("/customer/{id}")
//	public Optional<Customer> getById(@PathVariable Long Id) {
//		return customerServiceImpl.getCustomerById(Id);
//	}
//
//}
