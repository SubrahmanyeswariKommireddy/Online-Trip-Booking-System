//package com.sprint.otms;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import com.sprint.otms.models.Payment;
//import com.sprint.otms.models.TransactionMode;
//import com.sprint.otms.repositories.IPaymentRepository;
//import com.sprint.otms.services.PaymentServiceImpl;
//
//class PaymentServiceTest {
//	
//	@Autowired
//	PaymentServiceImpl paymentServiceImpl;
//	@MockBean
//	IPaymentRepository paymentRepository;
//
//
//	@Test
//	void testGetPayments() {
//		Payment payment = new Payment();
//		payment.setTransactionMode(TransactionMode.UPI);
//		when(paymentRepository.findAll()).thenReturn((List<Payment>) payment);
//		assertEquals(payment, paymentServiceImpl.getAllPayments());
//		
//	}
//	
//	@Test
//	void testGetRouteById() {
//		Payment payment1 = new Payment();
//		payment1.setTransactionId(10L);
//		when(paymentRepository.findById(10L)).thenReturn(Optional.of(payment1));
//		Optional<Payment> p = paymentServiceImpl.getPaymentById(10L);
//		assertEquals(payment1.toString(), p.toString());
//	}
////	@Test
////	void testGetPaymentById(Long id) {
////		List<Payment> payment1 = new ArrayList<Payment>();
////		payment1.add(1L); 
////		Mockito.when(paymentRepository.findById(id)).thenAnswer(x -> payment1)
////		//when(paymentRepository.findById(id)).thenReturn(id);
////		assertEquals(payment1, paymentServiceImpl.getPaymentById(id));
////	
////	}
//	
//
//}
