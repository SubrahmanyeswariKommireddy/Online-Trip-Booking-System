package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.IAdminRepository;
import com.sprint.otms.repositories.ICustomerRepository;
import com.sprint.otms.repositories.IRouteRepository;
import com.sprint.otms.repositories.ITravelRepository;
import com.sprint.otms.services.AdminServiceImpl;
import com.sprint.otms.services.CustomerServiceImpl;
import com.sprint.otms.services.RouteServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

/**
 * 
 * @author Susmitha
 *
 */
@SpringBootTest
class AdminServiceTest {

	@Mock
	private IAdminRepository adminRepository;

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

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
	void testAddAdmin() {
		Admin admin = new Admin("John", "123");
		when(adminRepository.save(admin)).thenReturn(admin);
		adminServiceImpl.addAdmin(admin);
		assertEquals("John", admin.getUserName());
		assertEquals("123", admin.getPassword());
	}

	@Test
	void testNotAddAdmin() {
		Admin admin1 = new Admin("John", "123");
		Admin admin2 = new Admin("abc", "1234");
		when(adminRepository.save(admin1)).thenReturn(admin1);
		assertEquals(admin1, adminServiceImpl.addAdmin(admin2));
	}

	@Test
	void testUpdateAdmin() {
		Admin admin = new Admin();
		admin.setUserName("John");
		when(adminRepository.save(admin)).thenReturn(admin);
		adminServiceImpl.updateAdmin(admin);
		assertEquals("John", admin.getUserName());
	}

	@Test
	void testNotUpdateAdmin() {
		Admin admin = new Admin();
		admin.setUserName("John");
		when(adminRepository.save(admin)).thenReturn(admin);
		adminServiceImpl.updateAdmin(admin);
		assertNotEquals("John", admin.getUserName());
	}

	@Test
	void testGetAllCustomer() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("ramesh", "123"));
		list.add(new Customer("suresh", "345"));
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), customerServiceImpl.getAllCustomer().size());
	}

	@Test
	void testNotGetAllCustomer() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("ramesh", "123"));
		list.add(new Customer("suresh", "345"));
		when(customerRepository.findAll()).thenReturn(list);
		assertNotEquals(list.size(), customerServiceImpl.getAllCustomer().size());
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
	public void testDeleteAdmin() {
		Admin admin = new Admin();
		admin.setId(2L);
		doNothing().when(adminRepository).deleteById(2L);
		when(adminRepository.getById(2L)).thenReturn(admin);
		assertEquals("success", adminServiceImpl.deleteAdmin(2L));
	}

	@Test
	public void testNotDeleteAdmin() {
		Admin admin = new Admin();
		admin.setId(2L);
		doNothing().when(adminRepository).deleteById(2L);
		when(adminRepository.getById(2L)).thenReturn(admin);
		assertNotEquals("success", adminServiceImpl.deleteAdmin(2L));
	}

}
