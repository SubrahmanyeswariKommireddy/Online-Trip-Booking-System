package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint.otms.models.Customer;
import com.sprint.otms.repositories.ICustomerRepository;
import com.sprint.otms.services.CustomerServiceImpl;

class CustomerServiceTest {
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	@MockBean
	ICustomerRepository customerRepository;

	@Test
	void testAddCustomer() {
		Customer c = new Customer();
		c.setUserName("xyz@11");
		c.setPassword("12");
		when(customerRepository.save(c)).thenReturn(c);
		assertEquals(c, customerServiceImpl.addCustomer(c));
	}
	@Test
	void testGetAllCustomer() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("shourya","123"));
		list.add(new Customer("dasari","345"));
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), customerServiceImpl.getAllCustomer().size());
		
	}
	@Test
	void testUpdateCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImpl.updateCustomer(customer));
	}
//	@Test
//	void testDelete() {
//		Customer customer1 = new Customer();
//		customer1.setId(2L);
//		doNothing().when(customerRepository).deleteById(2L);
//		when(customerRepository.findById(2L)).thenReturn(Optional.of(customer1));
//		assertEquals(customer1.getId(), customerServiceImpl.delete(2L));
//	}
//	@Test
//    public void removeCustomer() {
//		Customer customer1 = new Customer();
//		customer1.setId(2L);
//        when(customerRepository.findById(customer1.getId())).thenReturn(Optional.of(customer1));
//        Assertions.assertEquals(customer1, customerServiceImpl.delete(customer1.getId()));
//    }
}
