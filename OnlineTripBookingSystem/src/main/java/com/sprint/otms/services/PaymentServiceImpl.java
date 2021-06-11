package com.sprint.otms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Booking;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Payment;
import com.sprint.otms.repositories.IBookingRepository;
import com.sprint.otms.repositories.IBusRepository;
import com.sprint.otms.repositories.IPaymentRepository;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Autowired
	private IBookingRepository bookingRepository;
	
	@Autowired
	private IBusRepository busRepository;

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentByTransactionId(Long transactionId) {
		// TODO Auto-generated method stub
		return paymentRepository.getById(transactionId);
	}

	@Override
	public String delete(Long transactionId) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(transactionId);
		return "success";
	}

	@Override
	public Payment addPayment(Payment payment, Long bookingId, Long busId) {
		// TODO Auto-generated method stub
		Booking b = bookingRepository.getById(bookingId);
		//Payment pay=paymentRepository.getById(b.getPayment());
		Bus bus=busRepository.getById(busId);
		
		payment.setAmount(bus.getFare()*b.getSeatsBooked());	
		return paymentRepository.save(payment);
	}

}
