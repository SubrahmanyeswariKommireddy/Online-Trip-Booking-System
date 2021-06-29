package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.ICustomerRepository;
import com.sprint.otms.repositories.IRouteRepository;
import com.sprint.otms.repositories.ITravelRepository;
import com.sprint.otms.services.CustomerServiceImpl;
import com.sprint.otms.services.RouteServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

/**
 * 
 * @author Shourya
 *
 */
@SpringBootTest
class CustomerServiceTest {

	@Mock
	ICustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	ITravelRepository travelRepository;

	@InjectMocks
	TravelServiceImpl travelServiceImpl;

	@Mock
	IRouteRepository routeRepository;

	@InjectMocks
	RouteServiceImpl routeServiceImpl;

	@Test
	void testAddCustomer() {
		Customer c = new Customer("xyz", "123");
		when(customerRepository.save(c)).thenReturn(c);
		customerServiceImpl.addCustomer(c);
		assertEquals("xyz", c.getUserName());
		assertEquals("123", c.getPassword());

	}

	@Test
	void testNotAddCustomer() {
		Customer customer1 = new Customer("xyz", "123");
		Customer customer2 = new Customer("abc", "1234");
		when(customerRepository.save(customer1)).thenReturn(customer1);
		assertEquals(customer1, customerServiceImpl.addCustomer(customer2));
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
	void testNotUpdateCustomer() {
		Customer customer = new Customer();
		customer.setUserName("Dawid");
		when(customerRepository.save(customer)).thenReturn(customer);
		customerServiceImpl.updateCustomer(customer);
		assertNotEquals("Dawid", customer.getUserName());
	}

	@Test
	void testGetCustomerById() {
		Customer customer = new Customer(10L);
		when(customerRepository.getById(customer.getId())).thenReturn(customer);
		Customer c = customerServiceImpl.findCustomerById(customer.getId());
		assertEquals(c, customer);
	}

	@Test
	void testNotGetCustomerById() {
		Customer customer = new Customer(10L);
		when(customerRepository.getById(customer.getId())).thenReturn(customer);
		Customer c = customerServiceImpl.findCustomerById(customer.getId());
		assertNotEquals(c, customer);
	}
	
	@Test
	void testGetAllTravels() {
		List<Travel> list = new ArrayList<>();
		Travel t = new Travel();
		t.setTravelAgentName(TravelAgentName.GREENLINE);
		Travel t1 = new Travel();
		t1.setTravelAgentName(TravelAgentName.GREENLINE);
		list.add(t);
		list.add(t1);
		when(travelRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), travelServiceImpl.getAllTravel().size());
	}

	@Test
	void testNotGetAllTravels() {
		List<Travel> list = new ArrayList<>();
		Travel t = new Travel();
		t.setTravelAgentName(TravelAgentName.GREENLINE);
		Travel t1 = new Travel();
		t1.setTravelAgentName(TravelAgentName.GREENLINE);
		list.add(t);
		list.add(t1);
		when(travelRepository.findAll()).thenReturn(list);
		assertNotEquals(list.size(), travelServiceImpl.getAllTravel().size());
	}

	@Test
	void testGetAllRoute() {
		List<Route> list = new ArrayList<>();
		Route r1 = new Route();
		r1.setRouteId(1L);
		Route r2 = new Route();
		r2.setRouteId(2L);
		list.add(r1);
		list.add(r2);
		when(routeRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), routeServiceImpl.getAllRoute().size());
	}

	@Test
	void testNotGetAllRoute() {
		List<Route> list = new ArrayList<>();
		Route r1 = new Route();
		r1.setRouteId(1L);
		Route r2 = new Route();
		r2.setRouteId(2L);
		list.add(r1);
		list.add(r2);
		when(routeRepository.findAll()).thenReturn(list);
		assertNotEquals(list.size(), routeServiceImpl.getAllRoute().size());
	}

	@Test
	public void testDeleteCustomer() {
		Customer customer1 = new Customer();
		customer1.setId(2L);
		doNothing().when(customerRepository).deleteById(2L);
		when(customerRepository.getById(2L)).thenReturn(customer1);
		assertEquals("success", customerServiceImpl.delete(2L));
	}

	@Test
	public void testNotDeleteCustomer() {
		Customer customer1 = new Customer();
		customer1.setId(2L);
		doNothing().when(customerRepository).deleteById(2L);
		when(customerRepository.getById(2L)).thenReturn(customer1);
		assertNotEquals("success", customerServiceImpl.delete(2L));
	}

}
