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
	public Payment getPaymentByTransactionId(Long bookingId) {
		// TODO Auto-generated method stub
		return paymentRepository.getById(bookingId);
	}
	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(id);
		return "success";
	}

	
}
