package com.sprint.otms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.services.AdminServiceImpl;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.RouteServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

@RestController
public class AdminController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Autowired
	private TravelServiceImpl travelServiceImpl;
	
	@Autowired
	private RouteServiceImpl routeServiceImpl;
	
	@Autowired
	private BusServiceImpl busServiceImpl;

	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminServiceImpl.addAdmin(admin), HttpStatus.OK);
	}

	@GetMapping("/admin")
	public List<Admin> get() {
		return adminServiceImpl.getAdmin();
	}

	@PatchMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		Admin newAdmin = adminServiceImpl.updateAdmin(admin);
		return new ResponseEntity<>(newAdmin, HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		adminServiceImpl.deleteAdmin(id);
	}
	
	//-------------------------------Buses----------------------------------//
	
	@GetMapping("/admin/buses")
	public List<Bus> getBuses() {
		return busServiceImpl.getAllBuses();
	}

	// -----------------------------Travels---------------------------------//

	@PostMapping("/admin/route/addTravel")
	public ResponseEntity<Travel> addTravel(@RequestBody Travel travel) {
		return new ResponseEntity<>(travelServiceImpl.addTravel(travel), HttpStatus.OK);
	}

	@GetMapping("/admin/travels")
	public List<Travel> getTravels() {
		return travelServiceImpl.getAllTravel();
	}

	@GetMapping("/admin/travels/{id}")
	public Travel getById(@PathVariable Long travelId) {
		return travelServiceImpl.getTravelById(travelId);
	}
	
//	@GetMapping("/admin/travel/{id}/buses")
//	public List<Bus> getBusesByTravelId(@PathVariable Long travelId) {
//		return busServiceImpl.getBusesByTravelId(travelId);
//	}
	
//	@GetMapping("/admin/travel/{travelAgentName}/buses")
//	public List<Bus> getBusesByTravelAgentName(@PathVariable String travelAgentName) {
//		return busServiceImpl.getBusesByTravelAgentName(travelAgentName);
//	}
//
//	@GetMapping("/admin/travels/{travelAgentName}")
//	public List<Travel> getByName(@PathVariable String travelAgentName) {
//		return travelServiceImpl.getTravelByName(travelAgentName);
//	}
	
//	@GetMapping("/admin/route/{id}/{travelAgentName}")
//	public List<Travel> getTravelByRoute(@PathVariable String travelAgentName) {
//		return travelServiceImpl.getRouteByTravelAgentName(travelAgentName);
//	}

	@PatchMapping("/admin/updateTravel/{id}")
	public ResponseEntity<Travel> updateTravel(@RequestBody Travel travel) {
		Travel newTravel = travelServiceImpl.updateTravel(travel);
		return new ResponseEntity<>(newTravel, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteTravel/{id}")
	public void deleteById(@PathVariable Long id) {
		travelServiceImpl.delete(id);
	}
	
	//--------------------------------Routes----------------------------------//
	
	@PostMapping("/admin/addRoute")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) {
		return new ResponseEntity<>(routeServiceImpl.addRoute(route), HttpStatus.OK);
	}

	@GetMapping("/admin/routes")
	public List<Route> getRoutes() {
		return routeServiceImpl.getAllRoute();
	}

	@GetMapping("/admin/route/{id}")
	public Route getByRouteId(@PathVariable Long id) {
		return routeServiceImpl.getRouteByRouteId(id);
	}

	@GetMapping("/admin/route/{source}")
	public List<Route> getBySource(@PathVariable String source) {
		return routeServiceImpl.getRouteBySource(source);
	}
	
	@GetMapping("/admin/route/{source}/{destination}")
	public List<Route> getBySourceAndDestination(@PathVariable String source, String Destination) {
		return routeServiceImpl.getRouteBySourceAndDestination(source, Destination);
	}
	
	@PutMapping("/admin/updateRoute/{id}")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) {
		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@PatchMapping("/admin/partialUpdateRoute/{id}")
	public ResponseEntity<Route> partialUpdateRoute(@RequestBody Route route) {
		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteRoute/{id}")
	public void deleteRouteById(@PathVariable Long id) {
		routeServiceImpl.delete(id);
	}
}
