package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Booking;
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
		Booking b = new Booking();
		b.setSeatsBooked(5);
		b.setDateAndTimeOfTravel(LocalDateTime.now());
		when(bookingRepository.save(b)).thenReturn(b);
		assertEquals(b, bookingServiceImpl.addBooking(b));
	}

	
	@Test
	void testGetAllBookings() {
		List<Booking> list = new ArrayList<>();
		list.add(new Booking(3,LocalDateTime.now()));
		list.add(new Booking(4,LocalDateTime.now()));
		when(bookingRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), bookingServiceImpl.getAllBookings().size());	
	}
	
	@Test
	void testGetBookingById() {
		Booking booking = new Booking();
		booking.setBookingId(10L);
		when(bookingRepository.findById(10L)).thenReturn(Optional.of(booking));
		Optional<Booking> b = bookingServiceImpl.getBookingById(10L);
		assertEquals(booking.toString(), b.toString());
	}


//	@Test
//	void testGetAllBookings() {
//		List<Booking> list = new ArrayList<>();
//		list.add(new Booking(1L, 10, LocalDateTime.now()));
//		list.add(new Booking(2L, 5, LocalDateTime.now()));
//		when(bookingRepository.findAll()).thenReturn(list);
//		assertEquals(list.size(), bookingServiceImpl.getAllBookings().size());
//	}

//	@Test
//	public void cancelBookingById() {
//		Booking booking = new Booking();
//		booking.setBookingId(2L);
//		when(bookingRepository.findById(booking.getBookingId())).thenReturn(Optional.of(booking));
//		Assertions.assertEquals(booking, bookingServiceImpl.deleteBooking(booking.getBookingId()));
//	}


}
