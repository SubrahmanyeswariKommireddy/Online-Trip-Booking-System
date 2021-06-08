//package com.sprint.otms.services;
//
//import java.time.LocalDateTime;
//import java.util.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sprint.otms.models.Booking;
//import com.sprint.otms.repositories.IBookingRepository;
//
//@Service
//public class BookingServiceImpl implements IBookingService {
//
//	@Autowired
//	private IBookingRepository bookingRepository;
//
//	@Override
//	public Booking addBooking(Booking booking) {
//		// TODO Auto-generated method stub
//		return bookingRepository.saveAndFlush(booking);
//	}
//
//	@Override
//	public List<Booking> getAllBookings() {
//		// TODO Auto-generated method stub
//		return bookingRepository.findAll();
//	}
//
//	@Override
//	public void deleteBooking(Long bookingId) {
//		// TODO Auto-generated method stub
//		bookingRepository.deleteById(bookingId);
//	}
//
//	@Override
//	public Booking getBookingById(Long bookingId) {
//		// TODO Auto-generated method stub
//		return bookingRepository.getById(bookingId);
//	}
//
//	@Override
//	public List<Booking> getBookingsByCustomerId(Long id) {
//		// TODO Auto-generated method stub
//		return bookingRepository.findByCustomerId(id);
//	}
//
//	@Override
//	public List<Booking> getBookingByDateAndTimeOfTravel(LocalDateTime dateTime) {
//		// TODO Auto-generated method stub
//		return bookingRepository.findByDateAndTimeOfTravel(dateTime);
//	}
////	@Override
////	public Booking getBookingByPayment(Long transactionId) {
////		// TODO Auto-generated method stub
////		return bookingRepository.findByTransactionId(transactionId);
////	}
//
//	
//	
//}
