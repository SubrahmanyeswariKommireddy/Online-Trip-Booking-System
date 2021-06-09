package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Payment;
@Service
public interface IPaymentService {

	public List<Payment> getAllPayments();

	public Payment getPaymentByTransactionId(Long BookingId);

	public String delete(Long id);

}
