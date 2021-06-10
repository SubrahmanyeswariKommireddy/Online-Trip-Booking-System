package com.sprint.otms.services;


import java.time.LocalDateTime;
import java.util.*;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;

@Service
@Transactional
public interface IBookingService {
	
	public Booking addBooking(Booking booking);

	public List<Booking> getAllBookings();

	public String deleteBooking(Long bookingId);
	
	 public Booking findByBookingId(Long transactionId);

	//	List<Booking> findByDateAndTimeOfTravel(LocalDateTime dateTime);

}
