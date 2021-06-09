package com.sprint.otms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.otms.models.Route;
import com.sprint.otms.services.RouteServiceImpl;

@RestController
public class RouteController {
	
	@Autowired
	private RouteServiceImpl routeServiceImpl;
	
	@GetMapping("/routes")
	public List<Route> getAllRoutes() {
		return routeServiceImpl.getAllRoute();
	}
	
	@GetMapping("/route/{id}")
	public Route getRoutesById(@PathVariable Long id) {
		return routeServiceImpl.getRouteByRouteId(id);
	}
	
//	@GetMapping("/route/{id}/buses")
//	public List<Bus> getAllBuses(@PathVariable Long routeId) {
//		return busServiceImpl.getBusesByRouteId(routeId);
//	}
}
