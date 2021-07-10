package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.BusBooking;
import com.sprint.otms.models.Customer;

@Service
@Transactional
public interface IBusBookingService {

	public Customer addBooking(Long id,BusBooking booking);
	
	public void deleteBooking(Long id);
	
	public List<BusBooking> getAllBookings();
	
    public BusBooking getBookingById(Long id);
}
