package com.sprint.otms.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;

/**
 * 
 * @author Satish
 *
 */
@Service
@Transactional
public interface IBookingService {

	/**
	 * @param booking
	 * @return Booking
	 */
	public Booking addBooking(Booking booking);

	/**
	 * @return all Bookings
	 */
	public List<Booking> getAllBookings();

	/**
	 * @param bookingId
	 */
	public String deleteBooking(Long bookingId);

	/**
	 * @param transactionId
	 * @return Booking Details By Booking Id
	 */
	public Booking findByBookingId(Long transactionId);

	/**
	 * @param seatsBooked
	 * @return How Many Seats Booked
	 */
	Booking findBySeatsBooked(int seatsBooked);

}
