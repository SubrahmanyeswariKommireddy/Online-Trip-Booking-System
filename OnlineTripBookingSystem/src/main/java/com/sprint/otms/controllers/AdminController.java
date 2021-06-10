package com.sprint.otms.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	//--------------------------------Admin-------------------------------//
	
	
	@PostMapping("admin/login")
	public ResponseEntity<Admin> LoginAdmin(@Valid @RequestBody Admin admin) throws MethodArgumentNotValidException
	{
		return new ResponseEntity<Admin>((Admin) adminServiceImpl.Login(admin.getEmail(), admin.getPassword(), admin.getUserType()),HttpStatus.OK);
	}
	
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws MethodArgumentNotValidException {
		return new ResponseEntity<>(adminServiceImpl.addAdmin(admin), HttpStatus.OK);
	}

	@GetMapping("/getAdmin")
	public List<Admin> get() {
		return adminServiceImpl.getAdmin();
	}

	@PatchMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> partialUpdateAdmin(@Valid @PathVariable Long id, @RequestParam String oldMessage, @RequestParam String newMessage) throws AdminNotFoundException , MethodArgumentNotValidException{
		
		return new ResponseEntity<Admin>(adminServiceImpl.updateAdminById(id, oldMessage,newMessage), HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@Valid @PathVariable Long id) throws AdminNotFoundException, MethodArgumentNotValidException {
		adminServiceImpl.deleteAdmin(id);
	}
	

	// -----------------------------Travels---------------------------------//

	@PostMapping("/admin/addTravel")
	public ResponseEntity<Travel> addTravel(@Valid @RequestBody Travel travel) throws MethodArgumentNotValidException{
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
	public List<Bus> getBusesByTravelId(@Valid @PathVariable Long travelId) throws BusNotFoundException, TravelsNotFoundException ,MethodArgumentNotValidException{
		return busRepository.getBusesByTravelId(travelId);
	}
	
	@GetMapping("/admin/travel/{travelAgentName}/getBuses")
	public List<Bus> getBusesByTravelAgentName(@Valid @PathVariable String travelAgentName) throws BusNotFoundException, TravelsNotFoundException , MethodArgumentNotValidException{
		return busRepository.getBusesByTravelAgentName(travelAgentName);
	}

	@PatchMapping("/admin/updateTravel/{id}")
	public ResponseEntity<Travel> updateTravel(@Valid @RequestBody Travel travel) throws TravelsNotFoundException ,  MethodArgumentNotValidException{
		Travel newTravel = travelServiceImpl.updateTravel(travel);
		return new ResponseEntity<>(newTravel, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteTravel/{id}")
	public void deleteById(@Valid @PathVariable Long id) throws TravelsNotFoundException,  MethodArgumentNotValidException {
		travelServiceImpl.delete(id);
	}
	
	//--------------------------------Routes----------------------------------//
	
	@PostMapping("/admin/addRoute")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) throws MethodArgumentNotValidException{
		return new ResponseEntity<>(routeServiceImpl.addRoute(route), HttpStatus.OK);
	}

	@GetMapping("/admin/getRoutes")
	public List<Route> getRoutes() {
		return routeServiceImpl.getAllRoute();
	}

	@GetMapping("/admin/getRouteById/{id}")
	public ResponseEntity<Route> getRouteById(@Valid @PathVariable Long id) throws RouteNotFoundException,MethodArgumentNotValidException{
		return new ResponseEntity<Route>(routeServiceImpl.getRouteByRouteId(id),HttpStatus.OK);
	}

	@GetMapping("/admin/getRouteBySource/{source}")
	public List<Route> getRoutesBySource(@Valid @PathVariable String source) throws RouteNotFoundException , MethodArgumentNotValidException{
		return routeServiceImpl.getRouteBySource(source);
	}
	
	@GetMapping("/admin/getRoute/{source}/{destination}")
	public List<Route> getRoutesBySourceAndDestination(@Valid @PathVariable String source, String Destination) throws RouteNotFoundException,MethodArgumentNotValidException {
		return routeServiceImpl.getRouteBySourceAndDestination(source, Destination);
	}
	
	@PutMapping("/admin/updateRoute/{id}")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route) throws RouteNotFoundException, MethodArgumentNotValidException {
		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@PatchMapping("/admin/partialUpdateRoute/{id}")
	public ResponseEntity<Route> partialUpdateRoute(@Valid @RequestBody Route route) throws RouteNotFoundException,MethodArgumentNotValidException {
		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteRoute/{id}")
	public void deleteRouteById(@Valid @PathVariable Long id) throws RouteNotFoundException, MethodArgumentNotValidException {
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
