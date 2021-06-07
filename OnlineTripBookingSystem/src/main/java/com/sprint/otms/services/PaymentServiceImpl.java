package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Payment;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPaymentById(Long BookingiId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getPaymentsByCustomerId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getPaymentByJourneyDate(LocalDateTime dateTime) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
