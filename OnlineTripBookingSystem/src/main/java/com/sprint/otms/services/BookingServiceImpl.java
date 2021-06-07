package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;
import com.sprint.otms.repositories.IBookingRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking busBooking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsByCustomerId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingByJourneyDate(LocalDateTime dateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingByPayment(Long transactionId) {
		// TODO Auto-generated method stub
		return null;
	}



}
