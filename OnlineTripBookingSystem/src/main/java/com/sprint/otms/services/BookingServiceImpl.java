package com.sprint.otms.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;
import com.sprint.otms.models.Bus;
import com.sprint.otms.repositories.IBookingRepository;
import com.sprint.otms.repositories.IBusRepository;

/**
 * 
 * @author Satish
 *
 */
@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;

	@Autowired
	private IBusRepository busRepository;

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		Bus bus = busRepository.getById(booking.getBus().getBusId());

		if (bus.getCurrentCapacity() <= bus.getTotalCapacity()) {
			Long capacity = bus.getCurrentCapacity();
			if (capacity - booking.getSeatsBooked() > 0 && bus.getCurrentCapacity() >= booking.getSeatsBooked()) {
				if (bus.getCurrentCapacity() >= 0) {
					bus.setCurrentCapacity(capacity - booking.getSeatsBooked());
					busRepository.save(bus);
					return bookingRepository.saveAndFlush(booking);
				}

			}

		}
		return null;
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public String deleteBooking(Long bookingId) {
		// TODO Auto-generated method stub
		bookingRepository.deleteById(bookingId);
		return "success";
	}

	@Override
	public Booking findByBookingId(Long transactionId) {
		// TODO Auto-generated method stub
		return bookingRepository.getById(transactionId);
	}

	@Override
	public Booking findBySeatsBooked(int seatsBooked) {
		// TODO Auto-generated method stub
		System.out.println("bookings are not allowed");
		return null;
	}

	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
}
