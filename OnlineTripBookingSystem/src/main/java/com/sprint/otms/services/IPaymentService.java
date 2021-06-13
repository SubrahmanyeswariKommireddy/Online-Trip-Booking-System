package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Payment;

/**
 * 
 * @author Satish
 *
 */
@Service
@Transactional
public interface IPaymentService {

	/**
	 * @return
	 */
	public List<Payment> getAllPayments();

	/**
	 * @param transactionId
	 * @return
	 */
	public Payment getPaymentByTransactionId(Long transactionId);

	/**
	 * @param transactionId
	 * @return
	 */
	public String delete(Long transactionId);

	/**
	 * @param payment
	 * @param bookingId
	 * @param busId
	 * @return
	 */
	public Payment addPayment(Payment payment, Long bookingId, Long busId);

}
