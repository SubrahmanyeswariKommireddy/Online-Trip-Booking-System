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
	 * @return
	 */
	public Booking addBooking(Booking booking);

	/**
	 * @return
	 */
	public List<Booking> getAllBookings();

	/**
	 * @param bookingId
	 * @return
	 */
	public String deleteBooking(Long bookingId);

	/**
	 * @param transactionId
	 * @return
	 */
	public Booking findByBookingId(Long transactionId);

	/**
	 * @param seatsBooked
	 * @return
	 */
	Booking findBySeatsBooked(int seatsBooked);

}
