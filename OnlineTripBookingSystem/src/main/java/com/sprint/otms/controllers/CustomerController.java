package com.sprint.otms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Booking;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Payment;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.services.BookingServiceImpl;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.CustomerServiceImpl;
import com.sprint.otms.services.PaymentServiceImpl;
import com.sprint.otms.services.RouteServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private TravelServiceImpl travelServiceImpl;

	@Autowired
	private RouteServiceImpl routeServiceImpl;

	@Autowired
	private BusServiceImpl busServiceImpl;

	@Autowired
	private BookingServiceImpl bookingServiceImpl;

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;

	@PostMapping("customer/login")
	public ResponseEntity<Customer> LoginCustomer(@RequestBody  Customer customer)
	{
		return new ResponseEntity<Customer>((Customer) customerServiceImpl.Login(customer.getEmail(),customer.getPassword(), customer.getUserType()),HttpStatus.OK);
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerServiceImpl.addCustomer(customer), HttpStatus.OK);
	}

	@PatchMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerServiceImpl.updateCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

//	@GetMapping("admin/securityAlert/{id}")
//	public ResponseEntity<SecurityAlert> getSecurityAlertById(@PathVariable Long id)
//	{
//		return new ResponseEntity<SecurityAlert>(securityAlertService.getSecurityAlertById(id),HttpStatus.OK);
//	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Long id) {
		return new ResponseEntity<Customer>(customerServiceImpl.findCustomerById(id),HttpStatus.OK);
	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerServiceImpl.delete(id);
	}

	@GetMapping("/customer/getTravels")
	public List<Travel> getTravels() {
		return travelServiceImpl.getAllTravel();
	}

	@GetMapping("/customer/getRoutes")
	public List<Route> getRoutes() {
		return routeServiceImpl.getAllRoute();
	}

	@GetMapping("/customer/getBuses")
	public List<Bus> getBuses() {
		return busServiceImpl.getAllBuses();
	}

//------------------------Booking-------------------------------------------------------

	@PostMapping("/customer/addBooking")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		return new ResponseEntity<>(bookingServiceImpl.addBooking(booking), HttpStatus.OK);
	}
	
	@GetMapping("/customer/getBooking")
	public List<Booking> getBooking() {
		return bookingServiceImpl.getAllBookings();
	}

	@GetMapping("/customer/getBookingById/{id}")
	public Booking getByBookingId(@PathVariable Long Id) {
		return bookingServiceImpl.findByBookingId(Id);
	}

	@DeleteMapping("/customer/cancelBooking/{id}")
	public void cancelBooking(@PathVariable Long id) {
		bookingServiceImpl.deleteBooking(id);
	}

	// ----------------------------------payment------------------------------------

	@GetMapping("/getPayment")
	public List<Payment> getPayment() {
		return paymentServiceImpl.getAllPayments();
	}

	@GetMapping("/getPaymentById")
	public Payment getPaymentById(@PathVariable Long transactionId) {
		return paymentServiceImpl.getPaymentByTransactionId(transactionId);
	}
}