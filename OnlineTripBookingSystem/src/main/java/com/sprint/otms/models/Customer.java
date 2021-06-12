package com.sprint.otms.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details_table1")
public class Customer extends User {

	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
	private Booking booking;

	public Customer() {
		super();
	}

	public Customer(Long id, String userName, String password, String email, Long mobileNumber, Booking booking) {
		super(id, userName, password, email, mobileNumber);
		// TODO Auto-generated constructor stub
		this.booking = booking;
	}

	public Customer(String userName, String password, String email, Long mobileNumber, User_Type userType,
			Booking booking) {
		super(userName, password, email, mobileNumber, userType);
		this.booking = booking;
	}

	public Customer(Booking booking) {
		super();
		this.booking = booking;
	}

	public Customer(String userName, String password) {
		// TODO Auto-generated constructor stub
		super(userName, password);
	}

	public Customer(Long id) {
		super(id);
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Customer [booking=" + booking + "]";
	}
}
