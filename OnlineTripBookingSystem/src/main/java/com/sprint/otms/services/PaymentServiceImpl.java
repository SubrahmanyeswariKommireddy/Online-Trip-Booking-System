package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Payment;
import com.sprint.otms.repositories.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {
@Autowired
private IPaymentRepository paymentRepository;
	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Long BookingiId) {
		// TODO Auto-generated method stub
		return paymentRepository.getById(BookingiId);
	}

	@Override
	public Optional<Payment> getPaymentsByCustomerId(Long id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

	@Override
	public Optional<Payment> getPaymentByJourneyDate(LocalDateTime dateTime) {
		// TODO Auto-generated method stub
		return paymentRepository.findOne(dateTime);
	}
	
}
