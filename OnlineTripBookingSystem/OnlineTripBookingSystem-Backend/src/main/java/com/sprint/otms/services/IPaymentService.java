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
	 * @return all Payments
	 */
	public List<Payment> getAllPayments();

	/**
	 * @param transactionId
	 * @return Payment Details by Transaction Id
	 */
	public Payment getPaymentByTransactionId(Long transactionId);

	/**
	 * @param transactionId
	 */
	public String delete(Long transactionId);

	/**
	 * @param payment
	 * @param bookingId
	 * @param busId
	 * @return Payments
	 */
	public Payment addPayment(Payment payment, Long bookingId, Long busId);

}
