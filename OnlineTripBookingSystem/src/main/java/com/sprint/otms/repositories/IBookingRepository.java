package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Booking;

/**
 * 
 * @author Satish
 *
 */
@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

	/**
	 * @param transactionId
	 * @return Transaction Id by Booking Id
	 */
	Booking findByBookingId(Long transactionId);

	/**
	 * @param seatsBooked
	 * @return How Many Seats Booked
	 */
	public Booking findByseatsBooked(int seatsBooked);

}
