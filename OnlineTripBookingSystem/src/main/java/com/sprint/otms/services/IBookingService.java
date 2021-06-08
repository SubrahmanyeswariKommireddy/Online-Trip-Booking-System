package com.sprint.otms.services;


import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;

@Service
public interface IBookingService {
	
	public Booking addBooking(Booking busBooking);

	public List<Booking> getAllBookings();

	public void deleteBooking(Long id);

	public Optional<Booking> getBookingById(Long id);

	public List<Booking> getBookingsByCustomerId(Long id);

	public List<Booking> getBookingByJourneyDate(LocalDateTime dateTime);
	
	public Booking getBookingByPayment(Long transactionId);
}
