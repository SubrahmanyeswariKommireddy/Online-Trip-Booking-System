package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Payment;
import com.sprint.otms.repositories.IPaymentRepository;
import com.sprint.otms.services.PaymentServiceImpl;

/**
 * 
 * @author Satish
 *
 */
@SpringBootTest
class PaymentServiceTest {

	@Autowired
	PaymentServiceImpl paymentServiceImpl;

	@MockBean
	IPaymentRepository paymentRepository;

	@Test
	void testGetAllPayments() {
		List<Payment> payment = new ArrayList<Payment>();
		payment.add(new Payment(4L));
		payment.add(new Payment(23L));
		when(paymentRepository.findAll()).thenReturn(payment);
		assertEquals(payment, paymentServiceImpl.getAllPayments());

	}

	@Test
	void testGetPaymentById() {
		Payment payment = new Payment(10L);
		when(paymentRepository.getById(payment.getTransactionId())).thenReturn(payment);
		Payment p = paymentServiceImpl.getPaymentByTransactionId(10L);
		assertEquals(p, payment);
	}

	@Test
	void testDelete() {
		Payment p = new Payment();
		p.setTransactionId(12L);
		doNothing().when(paymentRepository).deleteById(12L);
		when(paymentRepository.getById(12L)).thenReturn(p);
		assertEquals("success", paymentServiceImpl.delete(12L));

	}

}
