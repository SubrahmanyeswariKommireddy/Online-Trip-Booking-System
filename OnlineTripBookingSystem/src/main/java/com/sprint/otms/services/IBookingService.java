package com.sprint.otms.services;


import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;

@Service
public interface IBookingService {
	
	public Booking addBooking(Booking booking);

	public List<Booking> getAllBookings();

	public String deleteBooking(Long bookingId);
	
	 Booking findByBookingId(Long transactionId);

	//	List<Booking> findByDateAndTimeOfTravel(LocalDateTime dateTime);

}
