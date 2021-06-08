package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint.otms.models.Route;
import com.sprint.otms.repositories.IRouteRepository;
import com.sprint.otms.services.RouteServiceImpl;


class RouteServiceTest {
	@Autowired
	RouteServiceImpl routeServiceImpl;
	@MockBean
	IRouteRepository routeRepository;

	@Test
	void testAddRoute() {
		Route r = new Route();
		r.setSource("Hyderabad");
		r.setDestination("Mumbai");
		when(routeRepository.save(r)).thenReturn(r);
		assertEquals(r, routeServiceImpl.addRoute(r));
	}
	@Test
	void testGetAllRoute() {
		List<Route>list = new ArrayList<>();
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
	void testGetRouteById() {
		Route route1 = new Route();
		route1.setRouteId(10L);
		when(routeRepository.findById(10L)).thenReturn(Optional.of(route1));
		Optional<Route> r = routeServiceImpl.getRouteById(10L);
		assertEquals(route1.toString(), r.toString());
	}
//	@Test
//	void testGetRouteById(Long id) {
//		Route route1 = new Route();
//		when(routeRepository.findById(id)).thenReturn(route1);
//		assertEquals(route1, routeService.getRouteById(id));
//		
//	}
//	@Test
//	void testDelete() {
//		Route r = new Route();
//		r.setRouteId(1L);
//		doNothing().when(routeRepository).deleteById(1L);
//		when(routeRepository.findRouteById(1L)).thenReturn(Optional.of(r));
//		assertEquals(r.getRouteId(), routeService.delete(1L));
//		
//	}
}
