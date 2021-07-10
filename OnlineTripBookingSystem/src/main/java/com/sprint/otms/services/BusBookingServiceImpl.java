//package com.sprint.otms.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Service;
//
//import com.sprint.otms.models.BusBooking;
//import com.sprint.otms.models.Customer;
//import com.sprint.otms.repositories.IBusBookingRepository;
//import com.sprint.otms.repositories.ICustomerRepository;
//
//@Service
//@Transactional
////public class BusBookingServiceImpl implements IBusBookingService{
//
//private IBusBookingRepository bookingRepository;
//
//private ICustomerRepository customerRepository;
//
////@Override
////public Customer addBooking(Long id,BusBooking booking) {
////	// TODO Auto-generated method stub
////	Optional<Customer> c= customerRepository.findById(id);
////	if(c!=null) {
////		System.out.println("customer");
////		c.get().getBooking().add(booking);
////		 return customerRepository.save(c.get());
////	}
////	return null;	
////}
//
//@Override
//public void deleteBooking(Long id) {
//	// TODO Auto-generated method stub
//	 bookingRepository.deleteById(id);
//}
//
//@Override
//public List<BusBooking> getAllBookings() {
//	// TODO Auto-generated method stub
//	return bookingRepository.findAll();
//}
//
//@Override
//public BusBooking getBookingById(Long id) {
//	// TODO Auto-generated method stub
//	return bookingRepository.getById(id);
//}
//
//
//}
