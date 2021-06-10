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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.otms.exceptions.AdminNotFoundException;
import com.sprint.otms.exceptions.TravelsNotFoundException;
import com.sprint.otms.exceptions.RouteNotFoundException;
import com.sprint.otms.exceptions.BusNotFoundException;
import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.User_Type;
import com.sprint.otms.repositories.IBusRepository;
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
	
	@Autowired
	private IBusRepository busRepository;

	
	@PostMapping("admin/login")
	public ResponseEntity<Admin> LoginAdmin(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>((Admin) adminServiceImpl.Login(admin.getEmail(), admin.getPassword(), admin.getUserType()),HttpStatus.OK);
	}
	//--------------------------------Admin-------------------------------//
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminServiceImpl.addAdmin(admin), HttpStatus.OK);
	}

	@GetMapping("/getAdmin")
	public List<Admin> get() {
		return adminServiceImpl.getAdmin();
	}

	@PatchMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> partialUpdateAdmin(@PathVariable Long id, @RequestParam String oldMessage, @RequestParam String newMessage) throws AdminNotFoundException{
		
		return new ResponseEntity<Admin>(adminServiceImpl.updateAdminById(id, oldMessage,newMessage), HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable Long id) throws AdminNotFoundException {
		adminServiceImpl.deleteAdmin(id);
	}
	

	// -----------------------------Travels---------------------------------//

	@PostMapping("/admin/addTravel")
	public ResponseEntity<Travel> addTravel(@RequestBody Travel travel) {
		return new ResponseEntity<>(travelServiceImpl.addTravel(travel), HttpStatus.OK);
	}


	@GetMapping("/admin/getTravels")
	public List<Travel> getTravels() {
		return travelServiceImpl.getAllTravel();
	}

//	@GetMapping("/admin/getTravelsById/{id}")
//	public ResponseEntity<Travel> getById(@PathVariable("travelId") Long travelId) throws TravelsNotFoundException{
//		return new  ResponseEntity<Travel>(travelServiceImpl.getTravelById(travelId),HttpStatus.OK);
//	}

	@GetMapping("/admin/travel/{id}/getBuses")
	public List<Bus> getBusesByTravelId(@PathVariable Long travelId) throws BusNotFoundException, TravelsNotFoundException {
		return busRepository.getBusesByTravelId(travelId);
	}
	
	@GetMapping("/admin/travel/{travelAgentName}/getBuses")
	public List<Bus> getBusesByTravelAgentName(@PathVariable String travelAgentName) throws BusNotFoundException, TravelsNotFoundException {
		return busRepository.getBusesByTravelAgentName(travelAgentName);
	}

	@PatchMapping("/admin/updateTravel/{id}")
	public ResponseEntity<Travel> updateTravel(@RequestBody Travel travel) throws TravelsNotFoundException {
		Travel newTravel = travelServiceImpl.updateTravel(travel);
		return new ResponseEntity<>(newTravel, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteTravel/{id}")
	public void deleteById(@PathVariable Long id) throws TravelsNotFoundException {
		travelServiceImpl.delete(id);
	}
	
	//--------------------------------Routes----------------------------------//
	
	@PostMapping("/admin/addRoute")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) {
		return new ResponseEntity<>(routeServiceImpl.addRoute(route), HttpStatus.OK);
	}

	@GetMapping("/admin/getRoutes")
	public List<Route> getRoutes() {
		return routeServiceImpl.getAllRoute();
	}

	@GetMapping("/admin/getRouteById/{id}")
	public ResponseEntity<Route> getRouteById(@PathVariable Long id) throws RouteNotFoundException{
		return new ResponseEntity<Route>(routeServiceImpl.getRouteByRouteId(id),HttpStatus.OK);
	}

	@GetMapping("/admin/getRouteBySource/{source}")
	public List<Route> getRoutesBySource(@PathVariable String source) throws RouteNotFoundException {
		return routeServiceImpl.getRouteBySource(source);
	}
	
	@GetMapping("/admin/getRoute/{source}/{destination}")
	public List<Route> getRoutesBySourceAndDestination(@PathVariable String source, String Destination) throws RouteNotFoundException {
		return routeServiceImpl.getRouteBySourceAndDestination(source, Destination);
	}
	
	@PutMapping("/admin/updateRoute/{id}")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) throws RouteNotFoundException {
		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@PatchMapping("/admin/partialUpdateRoute/{id}")
	public ResponseEntity<Route> partialUpdateRoute(@RequestBody Route route) throws RouteNotFoundException {
		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteRoute/{id}")
	public void deleteRouteById(@PathVariable Long id) throws RouteNotFoundException {
		routeServiceImpl.delete(id);
	}
	
//	@GetMapping("/route/{id}/buses")
//	public List<Bus> getAllBuses(@PathVariable Long routeId) {
//		return busServiceImpl.getBusesByRouteId(routeId);
//	}
	
	
	//-------------------------------Buses----------------------------------//
	
	@GetMapping("/admin/buses")
	public List<Bus> getBuses() {
		return busServiceImpl.getAllBuses();
	}
}
