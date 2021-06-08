package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.otms.models.Customer;
import com.sprint.otms.repositories.ICustomerRepository;
import com.sprint.otms.services.CustomerServiceImpl;

@SpringBootTest
class CustomerServiceTest {

	@Mock
	ICustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Test
	void testAddCustomer() {
		Customer c = new Customer("xyz", "123");
		when(customerRepository.save(c)).thenReturn(c);
		customerServiceImpl.addCustomer(c);
		assertEquals("xyz", c.getUserName());
		assertEquals("123", c.getPassword());

	}
//	@Test
//	void testNotAddCustomer() {
//		Customer customer1 = new Customer("xyz","123");		
//		Customer customer2 = new Customer("abc","1234");		
//		when(customerRepository.save(customer1)).thenReturn(customer1);
//		assertNotEquals(customer1, customerServiceImpl.addCustomer(customer2));
//	}

	@Test
	void testGetAllCustomer() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("ramesh", "123"));
		list.add(new Customer("suresh", "345"));
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), customerServiceImpl.getAllCustomer().size());
	}

	@Test
	void testUpdateCustomer() {
		Customer customer = new Customer();
		customer.setUserName("Dawid");
		when(customerRepository.save(customer)).thenReturn(customer);
		customerServiceImpl.updateCustomer(customer);
		assertEquals("Dawid", customer.getUserName());
	}

	@Test
	void testGetCustomerById() {
		Customer customer = new Customer(10L);	
		when(customerRepository.getById(customer.getId())).thenReturn(customer);
		Customer c = customerServiceImpl.findCustomerById(customer.getId());
		assertEquals(c, customer);
	}


//	@Test
//	public void testDeleteCustomer() {
//		Customer customer1 = new Customer();
//		customer1.setId(2L);
//		//doNothing().when(customerRepository).deleteById(2L);
//		when(customerRepository.getById(customer1.getId())).thenReturn(customer1);
//		Customer c1 = customerServiceImpl.delete(customer1.getId());
//		Assertions.assertEquals(customer1,c1);
//	}

}
