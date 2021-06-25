package com.sprint.otms.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Shourya
 *
 */
@Entity
@Table(name = "customer_details_table1")
public class Customer extends User {

	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonBackReference
	private Booking booking;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param booking
	 */
	public Customer(Long id, String userName, String password, String email, Long mobileNumber, Booking booking) {
		super(id, userName, password, email, mobileNumber);
		// TODO Auto-generated constructor stub
		this.booking = booking;
	}

	/**
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 * @param booking
	 */
	public Customer(String userName, String password, String email, Long mobileNumber, User_Type userType,
			Booking booking) {
		super(userName, password, email, mobileNumber, userType);
		this.booking = booking;
	}

	/**
	 * @param booking
	 */
	public Customer(Booking booking) {
		super();
		this.booking = booking;
	}

	/**
	 * @param userName
	 * @param password
	 */
	public Customer(String userName, String password) {
		// TODO Auto-generated constructor stub
		super(userName, password);
	}

	/**
	 * @param id
	 */
	public Customer(Long id) {
		super(id);
	}

	/**
	 * @return all Bookings
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Customer [booking=" + booking + "]";
	}
}
