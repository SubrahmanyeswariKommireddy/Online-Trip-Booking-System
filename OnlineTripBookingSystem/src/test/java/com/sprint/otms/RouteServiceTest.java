package com.sprint.otms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.otms.models.Route;
import com.sprint.otms.repositories.IRouteRepository;
import com.sprint.otms.services.RouteServiceImpl;


class RouteServiceTest {
	@Autowired
	RouteServiceImpl routeService;
	@MockBean
	IRouteRepository routeRepository;

	@Test
	void testAddRoute() {
		Route r = new Route();
		r.setSource("Hyderabad");
		r.setDestination("Mumbai");
		when(routeRepository.save(r)).thenReturn(r);
		assertEquals(r, routeService.addRoute(r));
	}
}
