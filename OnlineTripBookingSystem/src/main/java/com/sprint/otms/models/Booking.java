package com.sprint.otms.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "booking_details_table1")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;

	@NotNull
	private int seatsBooked;
	private LocalDateTime dateAndTimeOfTravel;

	@OneToOne
	private Customer customer;

	@OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
	private Payment payment;

	@OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
	private Bus bus;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int seatsBooked, LocalDateTime dateAndTimeOfTravel, Bus bus) {
		super();
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
		this.bus = bus;
	}

	public Booking(int seatsBooked, Bus bus) {
		super();
		this.seatsBooked = seatsBooked;
		this.bus = bus;
	}

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

	public Booking(int seatsBooked, LocalDateTime dateAndTimeOfTravel, Payment payment, Customer customer, Bus bus) {
		super();
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
		this.payment = payment;
		this.customer = customer;
		this.bus = bus;
	}

	public Booking(int seatsBooked, LocalDateTime dateAndTimeOfTravel) {
		super();
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
	}

	public Booking(int seatsBooked) {
		super();
		this.seatsBooked = seatsBooked;
	}

	public Booking(Long bookingId, int seatsBooked, LocalDateTime dateAndTimeOfTravel) {
		super();
		this.bookingId = bookingId;
		this.seatsBooked = seatsBooked;
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
	}

	public Booking(long bookingId, int seatsBooked, Bus bus) {
		// TODO Auto-generated constructor stub
		super();
		this.bookingId = bookingId;
		this.seatsBooked = seatsBooked;
		this.bus = bus;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public LocalDateTime getDateAndTimeOfTravel() {
		return dateAndTimeOfTravel;
	}

	public void setDateAndTimeOfTravel(LocalDateTime dateAndTimeOfTravel) {
		this.dateAndTimeOfTravel = dateAndTimeOfTravel;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", seatsBooked=" + seatsBooked + ", dateAndTimeOfTravel="
				+ dateAndTimeOfTravel + ", payment=" + payment + ", customer=" + customer + ", bus=" + bus + "]";
	}
}
