package com.sprint.otms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
@CrossOrigin
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

	/**
	 * @param customer
	 * @return Customer Login Status
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("customer/login")
	public ResponseEntity<Customer> loginCustomer(@Valid @RequestBody Customer customer)
			throws MethodArgumentNotValidException {

		LOGGER.info("customerLogin URL is opened");
		LOGGER.info("loginCustomer() is initiated");

		return new ResponseEntity<Customer>((Customer) customerServiceImpl.Login(customer.getEmail(),
				customer.getPassword(), customer.getUserType()), HttpStatus.OK);
	}

	/**
	 * @param customer
	 * @return Customer
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer)
			throws MethodArgumentNotValidException {

		LOGGER.info("addCustomer URL is opened");
		LOGGER.info("createCustomer() is initiated");

		return new ResponseEntity<>(customerServiceImpl.addCustomer(customer), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return Updated Customer Password By Id
	 * @throws CustomerNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws ValidationException
	 */
	@PatchMapping("/updateCustomerPassword/{id}")

	public ResponseEntity<Customer> updatePassword(@Valid @PathVariable Long id, @RequestParam String oldPassword,
			@RequestParam String newPassword)
			throws CustomerNotFoundException, MethodArgumentNotValidException, ValidationException {
		LOGGER.info("updateCustomerPassword URL is opened");
		LOGGER.info("updateCustomerPassword() is initiated");
		return new ResponseEntity<Customer>(
				customerServiceImpl.updateCustomerPasswordById(id, oldPassword, newPassword), HttpStatus.OK);

	}

	/**
	 * @param id
	 * @param oldMobileNo
	 * @param newMobileNo
	 * @return Updated Customer Mobile Number By Id
	 * @throws CustomerNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws ValidationException
	 */
	@PatchMapping("/updateCustomerMobileNo/{id}")
	public ResponseEntity<Customer> UpdateMobileNo(@Valid @PathVariable Long id, @RequestParam Long oldMobileNo,
			@RequestParam Long newMobileNo)
			throws CustomerNotFoundException, MethodArgumentNotValidException, ValidationException {
		LOGGER.info("updateCustomerMobileNo URL is opened");
		LOGGER.info("updateCustomerMobileNo() is initiated");
		return new ResponseEntity<Customer>(
				customerServiceImpl.updateCustomerMobileNoById(id, oldMobileNo, newMobileNo), HttpStatus.OK);

	}

	/**
	 * @param id
	 * @param oldEmail
	 * @param newEmail
	 * @return Updated Customer Email by Id
	 * @throws CustomerNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws ValidationException
	 */
	@PatchMapping("/updateCustomerEmail/{id}")
	public ResponseEntity<Customer> UpdateEmail(@Valid @PathVariable Long id, @RequestParam String oldEmail,
			@RequestParam String newEmail)
			throws CustomerNotFoundException, MethodArgumentNotValidException, ValidationException {
		LOGGER.info("updateCustomerEmail URL is opened");
		LOGGER.info("updateCustomerEmail() is initiated");
		return new ResponseEntity<Customer>(customerServiceImpl.updateCustomerEmailById(id, oldEmail, newEmail),
				HttpStatus.OK);

	}
	@PatchMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws MethodArgumentNotValidException {

		LOGGER.info("updateCustomer URL is opened");
		LOGGER.info("updateCustomer() is initiated");

		Customer cust = customerServiceImpl.updateCustomer(customer);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return Customer By Id
	 * @throws CustomerNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getById(@Valid @PathVariable Long id)
			throws CustomerNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getCustomer URL is opened");
		LOGGER.info("getById() is initiated");

		return new ResponseEntity<Customer>(customerServiceImpl.findCustomerById(id), HttpStatus.OK);
	}

	/**
	 * @param id
	 * @throws CustomerNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@Valid @PathVariable Long id)
			throws CustomerNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("deleteCustomer URL is opened");
		LOGGER.info("deleteCustomer() is initiated");

		customerServiceImpl.delete(id);
	}

	/**
	 * @return all Travels
	 */
	@GetMapping("/customer/getTravels")
	public List<Travel> getTravels() {

		LOGGER.info("getTravels URL is opened");
		LOGGER.info("getTravels() is initiated");

		return travelServiceImpl.getAllTravel();
	}

	/**
	 * @return all Routes
	 */
	@GetMapping("/customer/getRoutes")
	public List<Route> getRoutes() {

		LOGGER.info("getRoutes URL is opened");
		LOGGER.info("getRoutes() is initiated");

		return routeServiceImpl.getAllRoute();
	}

	/**
	 * @return all Buses
	 */
	@GetMapping("/customer/getBuses")
	public List<Bus> getBuses() {

		LOGGER.info("getBuses URL is opened");
		LOGGER.info("getBuses() is initiated");

		return busServiceImpl.getAllBuses();
	}

	//-------------------------------------Booking-------------------------------------//

	/**
	 * @param booking
	 * @return Booking
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("/customer/addBooking")
	public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking)
			throws MethodArgumentNotValidException {

		LOGGER.info("addBooking URL is opened");
		LOGGER.info("createBooking() is initiated");

		return new ResponseEntity<>(bookingServiceImpl.addBooking(booking), HttpStatus.OK);
	}

	/**
	 * @return all Bookings
	 */
	@GetMapping("/customer/getBooking")
	public List<Booking> getBooking() {

		LOGGER.info("getBooking URL is opened");
		LOGGER.info("getBooking() is initiated");

		return bookingServiceImpl.getAllBookings();
	}

	/**
	 * @param id
	 * @return Booking By Id
	 * @throws BookingNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("/customer/getBookingById/{id}")
	public Booking getByBookingId(@Valid @PathVariable Long id)
			throws BookingNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getBookingById URL is opened");
		LOGGER.info("getByBookingId() is initiated");
		// Booking b=
		return bookingServiceImpl.findByBookingId(id);
	}

	/**
	 * @param id
	 * @throws BookingNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("/customer/cancelBooking/{id}")
	public void cancelBooking(@Valid @PathVariable Long id)
			throws BookingNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("cancelBooking URL is opened");
		LOGGER.info("cancelBooking() is initiated");

		bookingServiceImpl.deleteBooking(id);
	}

	//-----------------------------------Payment------------------------------------//

	/**
	 * @param payment
	 * @param bookingId
	 * @param busId
	 * @return Payment
	 * @throws MethodArgumentNotValidException
	 */
	@PostMapping("/customer/addPayment")
	public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment payment, Long bookingId, Long busId)
			throws MethodArgumentNotValidException {

		LOGGER.info("addBooking URL is opened");
		LOGGER.info("createBooking() is initiated");

		return new ResponseEntity<>(paymentServiceImpl.addPayment(payment, bookingId, busId), HttpStatus.OK);
	}

	/**
	 * @return all Payments
	 */
	@GetMapping("/getPayment")
	public List<Payment> getPayment() {

		LOGGER.info("getPayment URL is opened");
		LOGGER.info("getPayment() is initiated");

		return paymentServiceImpl.getAllPayments();
	}

	/**
	 * @param transactionId
	 * @return Payment By Id or Transaction By Id
	 * @throws BookingNotFoundException
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("/getPaymentById/{transactionId}")
	public Payment getPaymentById(@Valid @PathVariable Long transactionId)
			throws BookingNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getPaymentsById URL is opened");
		LOGGER.info("getPaymentsById() is initiated");

		return paymentServiceImpl.getPaymentByTransactionId(transactionId);
	}
}