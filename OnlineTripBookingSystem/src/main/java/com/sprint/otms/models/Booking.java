package com.sprint.otms.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

/**
 * @author Satish
 *
 */
@Entity
@Table(name = "booking_table")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;

	@NotNull
	private int seatsBooked;
	private LocalDateTime dateAndTimeOfTravel;

	@OneToOne
	//@JsonManagedReference
	private Customer customer;

	@OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
	private Payment payment;

	@OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
	private Bus bus;

	/**
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param seatsBooked
	 * @param dateAndTimeOfTravel
	 * @param bus
	 */
	public Booking(int seatsBooked, LocalDateTime dateAndTimeOfTravel, Bus bus) {
		super();
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
		this.bus = bus;
	}

	/**
	 * @param seatsBooked
	 * @param bus
	 */
	public Booking(int seatsBooked, Bus bus) {
		super();
		this.seatsBooked = seatsBooked;
		this.bus = bus;
	}

	/**
	 * @param bookingId
	 * @param seatsBooked
	 * @param dateAndTimeOfTravel
	 * @param payment
	 * @param customer
	 * @param bus
	 */
	public Booking(Long bookingId, int seatsBooked, LocalDateTime dateAndTimeOfTravel, Payment payment,
			Customer customer, Bus bus) {
		super();
		this.bookingId = bookingId;
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
		this.payment = payment;
		this.customer = customer;
		this.bus = bus;
	}

	/**
	 * @param seatsBooked
	 * @param dateAndTimeOfTravel
	 * @param payment
	 * @param customer
	 * @param bus
	 */
	public Booking(int seatsBooked, LocalDateTime dateAndTimeOfTravel, Payment payment, Customer customer, Bus bus) {
		super();
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
		this.payment = payment;
		this.customer = customer;
		this.bus = bus;
	}

	/**
	 * @param seatsBooked
	 * @param dateAndTimeOfTravel
	 */
	public Booking(int seatsBooked, LocalDateTime dateAndTimeOfTravel) {
		super();
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
	}

	/**
	 * @param seatsBooked
	 */
	public Booking(int seatsBooked) {
		super();
		this.seatsBooked = seatsBooked;
	}

	/**
	 * @param bookingId
	 * @param seatsBooked
	 * @param dateAndTimeOfTravel
	 */
	public Booking(Long bookingId, int seatsBooked, LocalDateTime dateAndTimeOfTravel) {
		super();
		this.bookingId = bookingId;
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
	}

	/**
	 * @param bookingId
	 * @param seatsBooked
	 * @param bus
	 */
	public Booking(long bookingId, int seatsBooked, Bus bus) {
		// TODO Auto-generated constructor stub
		super();
		this.bookingId = bookingId;
		this.seatsBooked = seatsBooked;
		this.bus = bus;
	}

	/**
	 * @return all Booking Id's
	 */
	public Long getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId
	 */
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return Seats Booked
	 */
	public int getSeatsBooked() {
		return seatsBooked;
	}

	/**
	 * @param seatsBooked
	 */
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	/**
	 * @return Date and Time of Travel
	 */
	public LocalDateTime getDateAndTimeOfTravel() {
		return dateAndTimeOfTravel;
	}

	/**
	 * @param dateAndTimeOfTravel
	 */
	public void setDateAndTimeOfTravel(LocalDateTime dateAndTimeOfTravel) {
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
	}

	/**
	 * @return all Payments
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return all Customers
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return all Buses
	 */
	public Bus getBus() {
		return bus;
	}

	/**
	 * @param bus
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", seatsBooked=" + seatsBooked + ", dateAndTimeOfTravel="
				+ dateAndTimeOfTravel + ", payment=" + payment + ", customer=" + customer + ", bus=" + bus + "]";
	}
}
