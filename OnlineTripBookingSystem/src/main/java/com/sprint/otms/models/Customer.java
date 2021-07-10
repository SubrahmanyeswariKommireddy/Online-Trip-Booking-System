package com.sprint.otms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Shourya
 *
 */
@Entity
@Table(name = "cust_table")
public class Customer extends User {

//	@OneToMany(mappedBy = "customer")
//	private List<BusBooking> booking;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "cust_booking", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "booking")
	private List<BusBooking> booking = new ArrayList<BusBooking>();

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
	public Customer(Long id, String userName, String password, String email, Long mobileNumber, List<BusBooking> booking) {
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
			List<BusBooking> booking) {
		super(userName, password, email, mobileNumber, userType);
		this.booking = booking;
	}

	/**
	 * @param booking
	 */
	public Customer(List<BusBooking> booking) {
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
	public List<BusBooking> getBooking() {
		return booking;
	}

	/**
	 * @param booking
	 */
	public void setBooking(List<BusBooking> booking) {
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
