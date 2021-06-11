package com.sprint.otms.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.otms.exceptions.BookingNotFoundException;
import com.sprint.otms.exceptions.CustomerNotFoundException;
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
	
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

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
	public ResponseEntity<Customer> loginCustomer(@Valid @RequestBody  Customer customer) throws MethodArgumentNotValidException
	{
	
		
		LOGGER.info("customerLogin URL is opened");
		LOGGER.info("loginCustomer() is initiated");
		
		return new ResponseEntity<Customer>((Customer) customerServiceImpl.Login(customer.getEmail(),customer.getPassword(), customer.getUserType()),HttpStatus.OK);
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws MethodArgumentNotValidException{
		
		LOGGER.info("addCustomer URL is opened");
		LOGGER.info("createCustomer() is initiated");
		
		return new ResponseEntity<>(customerServiceImpl.addCustomer(customer), HttpStatus.OK);
	}

	@PatchMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) throws CustomerNotFoundException , MethodArgumentNotValidException{
		
		LOGGER.info("updateCustomer URL is opened");
		LOGGER.info("updateCustomer() is initiated");
		
		Customer newCustomer = customerServiceImpl.updateCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

//	@GetMapping("admin/securityAlert/{id}")
//	public ResponseEntity<SecurityAlert> getSecurityAlertById(@PathVariable Long id)
//	{
//		return new ResponseEntity<SecurityAlert>(securityAlertService.getSecurityAlertById(id),HttpStatus.OK);
//	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getById(@Valid @PathVariable Long id) throws CustomerNotFoundException , MethodArgumentNotValidException{
		
		LOGGER.info("getCustomer URL is opened");
		LOGGER.info("getById() is initiated");
		
		return new ResponseEntity<Customer>(customerServiceImpl.findCustomerById(id),HttpStatus.OK);
	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@Valid @PathVariable Long id) throws CustomerNotFoundException, MethodArgumentNotValidException {
		
		LOGGER.info("deleteCustomer URL is opened");
		LOGGER.info("deleteCustomer() is initiated");
		
		customerServiceImpl.delete(id);
	}

	@GetMapping("/customer/getTravels")
	public List<Travel> getTravels() {
		
		LOGGER.info("getTravels URL is opened");
		LOGGER.info("getTravels() is initiated");
		
		return travelServiceImpl.getAllTravel();
	}

	@GetMapping("/customer/getRoutes")
	public List<Route> getRoutes() {
		
		LOGGER.info("getRoutes URL is opened");
		LOGGER.info("getRoutes() is initiated");
		
		return routeServiceImpl.getAllRoute();
	}

	@GetMapping("/customer/getBuses")
	public List<Bus> getBuses() {
		
		LOGGER.info("getBuses URL is opened");
		LOGGER.info("getBuses() is initiated");
		
		return busServiceImpl.getAllBuses();
	}

//------------------------Booking-------------------------------------------------------

	@PostMapping("/customer/addBooking")
	public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking) throws MethodArgumentNotValidException{
		
		LOGGER.info("addBooking URL is opened");
		LOGGER.info("createBooking() is initiated");
		
		return new ResponseEntity<>(bookingServiceImpl.addBooking(booking), HttpStatus.OK);
	}
	
	
	@GetMapping("/customer/getBooking")
	public List<Booking> getBooking() {
		
		LOGGER.info("getBooking URL is opened");
		LOGGER.info("getBooking() is initiated");
		
		return bookingServiceImpl.getAllBookings();
	}

	@GetMapping("/customer/getBookingById/{id}")
	public Booking getByBookingId(@Valid @PathVariable Long id) throws BookingNotFoundException, MethodArgumentNotValidException {
		
		LOGGER.info("getBookingById URL is opened");
		LOGGER.info("getByBookingId() is initiated");
		//Booking b=
		return bookingServiceImpl.findByBookingId(id);
	}

	@DeleteMapping("/customer/cancelBooking/{id}")
	public void cancelBooking(@Valid @PathVariable Long id) throws BookingNotFoundException , MethodArgumentNotValidException{
		
		LOGGER.info("cancelBooking URL is opened");
		LOGGER.info("cancelBooking() is initiated");
		
		bookingServiceImpl.deleteBooking(id);
	}

	// ----------------------------------payment------------------------------------

	@GetMapping("/getPayment")
	public List<Payment> getPayment() {
		
		LOGGER.info("getPayment URL is opened");
		LOGGER.info("getPayment() is initiated");
		
		return paymentServiceImpl.getAllPayments();
	}

	@GetMapping("/getPaymentById")
	public Payment getPaymentById(@Valid @PathVariable Long transactionId) throws BookingNotFoundException ,MethodArgumentNotValidException{
	
		
		LOGGER.info("getPaymentsById URL is opened");
		LOGGER.info("getPaymentsById() is initiated");
		
		return paymentServiceImpl.getPaymentByTransactionId(transactionId);
	}
}