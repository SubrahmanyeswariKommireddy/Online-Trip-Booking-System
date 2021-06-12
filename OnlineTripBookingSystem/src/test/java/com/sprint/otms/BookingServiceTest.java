package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Booking;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Customer;
import com.sprint.otms.repositories.IBookingRepository;
import com.sprint.otms.services.BookingServiceImpl;

@SpringBootTest
class BookingServiceTest {

	@MockBean
	private IBookingRepository bookingRepository;

	@Autowired

	BookingServiceImpl bookingServiceImpl;

	@Test
	void testAddBooking() {
		Booking b = new Booking(5,LocalDateTime.of(2030,01,01,22,22,22));
		when(bookingRepository.save(b)).thenReturn(b);
		bookingServiceImpl.createBooking(b);
		assertEquals(5,b.getSeatsBooked());
	    assertEquals(LocalDateTime.of(2030,01,01,22,22,22), b.getDateAndTimeOfTravel());
	}
	
	@Test
	void testNotAddBooking() {
		Booking booking1 = new Booking(5,LocalDateTime.of(2030,01,01,22,22,22));		
		Booking booking2 = new Booking(7,LocalDateTime.of(2020,01,01,22,22,22));		
		when(bookingRepository.save(booking1)).thenReturn(booking1);
		assertNotEquals(booking1, bookingServiceImpl.createBooking(booking2));
	}

	@Test
	void testGetAllBookings() {
		List<Booking> list = new ArrayList<>();
		list.add(new Booking(3,LocalDateTime.of(2030,01,01,22,22,22)));
		list.add(new Booking(4,LocalDateTime.of(2031,01,01,22,22,22)));
		when(bookingRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), bookingServiceImpl.getAllBookings().size());	
	}

	@Test
	void testGetBookingById() {
		Booking booking = new Booking();
		booking.setBookingId(10L);
		when(bookingRepository.getById(booking.getBookingId())).thenReturn(booking);
		Booking b = bookingServiceImpl.findByBookingId(booking.getBookingId());
		assertEquals(booking.toString(), b.toString());
	}


	@Test
	public void cancelBookingById() {
		Booking booking = new Booking();
		booking.setBookingId(2L);
		when(bookingRepository.getById(booking.getBookingId())).thenReturn((booking));
		Assertions.assertEquals("success",bookingServiceImpl.deleteBooking(2L));
	}

}
