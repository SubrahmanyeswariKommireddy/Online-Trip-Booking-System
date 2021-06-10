package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Payment;

@Service
@Transactional
public interface IPaymentService {

	public List<Payment> getAllPayments();

	public Payment getPaymentByTransactionId(Long transactionId);

	public String delete(Long transactionId);

}
