package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

	Booking findByBookingId(Long transactionId);

	public Booking findByseatsBooked(int seatsBooked);

//	List<Booking> findByDateAndTimeOfTravel(LocalDateTime dateTime);

}
