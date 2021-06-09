package com.sprint.otms.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Booking;

@Repository
public interface IBookingRepository extends JpaRepository <Booking, Long> {

	 Booking findByBookingId(Long transactionId);
	 
	 
	 
//	List<Booking> findByDateAndTimeOfTravel(LocalDateTime dateTime);


	
}
