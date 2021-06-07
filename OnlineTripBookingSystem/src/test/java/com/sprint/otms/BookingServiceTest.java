package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Booking;
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

}
