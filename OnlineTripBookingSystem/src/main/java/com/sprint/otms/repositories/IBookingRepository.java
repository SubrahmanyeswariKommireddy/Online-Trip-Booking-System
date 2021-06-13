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
	 * @return
	 */
	Booking findByBookingId(Long transactionId);

	/**
	 * @param seatsBooked
	 * @return
	 */
	public Booking findByseatsBooked(int seatsBooked);

}
