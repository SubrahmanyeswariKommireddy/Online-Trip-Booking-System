package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.List;

import com.sprint.otms.models.Payment;

public interface IPaymentService {

	public List<Payment> getAllPayments();

	public Payment getPaymentById(Long BookingiId);

	public List<Payment> getPaymentsByCustomerId(Long id);

	public List<Payment> getPaymentByJourneyDate(LocalDateTime dateTime);

}