package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Payment;

@Service
@Transactional
public interface IPaymentService {

	public List<Payment> getAllPayments();

	public Payment getPaymentByTransactionId(Long transactionId);

	public String delete(Long transactionId);

	public Payment addPayment(Payment payment, Long bookingId, Long busId);

}
