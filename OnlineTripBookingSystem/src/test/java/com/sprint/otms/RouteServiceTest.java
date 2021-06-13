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

import com.sprint.otms.models.Route;
import com.sprint.otms.repositories.IRouteRepository;
import com.sprint.otms.services.RouteServiceImpl;

/**
 * 
 * @author Subani
 *
 */
@SpringBootTest
class RouteServiceTest {

	@Mock
	IRouteRepository routeRepository;

	@InjectMocks
	RouteServiceImpl routeServiceImpl;

	@Test
	void testAddRoute() {
		Route r = new Route("Hyderabad", "Mumbai");
		when(routeRepository.saveAndFlush(r)).thenReturn(r);
		routeServiceImpl.addRoute(r);
		assertEquals("Hyderabad", r.getSource());
		assertEquals("Mumbai", r.getDestination());
	}

	@Test
	void testNotAddRoute() {
		Route route1 = new Route("Hyderabad", "Mumbai");
		Route route2 = new Route("Chennai", "Banglore");
		when(routeRepository.save(route1)).thenReturn(route1);
		assertEquals(route1, routeServiceImpl.addRoute(route2));
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
	void testGetRouteById() {
		Route route1 = new Route(10L);
		when(routeRepository.getById(route1.getRouteId())).thenReturn(route1);
		Route r = routeServiceImpl.getRouteByRouteId(route1.getRouteId());
		assertEquals(r, route1);
	}

	@Test
	void testGetRouteBySource() {
		List<Route> list = new ArrayList<>();
		list.add(new Route("Hyderabad"));
		list.add(new Route("Mumbai"));
		when(routeRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), routeServiceImpl.getAllRoute().size());
	}

	@Test
	void testGetRouteByDestination() {
		List<Route> list = new ArrayList<>();
		list.add(new Route("Mumbai"));
		list.add(new Route("Hyderabad"));
		when(routeRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), routeServiceImpl.getAllRoute().size());
	}

	@Test
	void testGetRouteBySourceAndDestination() {
		List<Route> list = new ArrayList<>();
		list.add(new Route("Mumbai", "Chennai"));
		list.add(new Route("Hyderabad", "Mumbai"));
		when(routeRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), routeServiceImpl.getAllRoute().size());
	}

	@Test
	void testDelete() {
		Route r = new Route();
		r.setRouteId(1L);
		doNothing().when(routeRepository).deleteById(1L);
		when(routeRepository.getById(1L)).thenReturn(r);
		assertEquals("success", routeServiceImpl.delete(12L));
	}
	
	@Test
	void testNotDelete() {
		Route r = new Route();
		r.setRouteId(1L);
		doNothing().when(routeRepository).deleteById(1L);
		when(routeRepository.getById(1L)).thenReturn(r);
		assertNotEquals("success", routeServiceImpl.delete(12L));
	}
}
