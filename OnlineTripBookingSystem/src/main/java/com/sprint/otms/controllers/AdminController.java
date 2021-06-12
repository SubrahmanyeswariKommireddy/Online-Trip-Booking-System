package com.sprint.otms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

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
import com.sprint.otms.exceptions.CustomerNotFoundException;
import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.services.AdminServiceImpl;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.CustomerServiceImpl;
import com.sprint.otms.services.RouteServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

@RestController
public class AdminController {

	static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Autowired
	private TravelServiceImpl travelServiceImpl;

	@Autowired
	private RouteServiceImpl routeServiceImpl;

	@Autowired
	private BusServiceImpl busServiceImpl;

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	// --------------------------------Admin-------------------------------//

	@PostMapping("admin/login")
	public ResponseEntity<Admin> loginAdmin(@Valid @RequestBody Admin admin) throws MethodArgumentNotValidException {

		LOGGER.info("adminLogin URL is opened");
		LOGGER.info("loginAdmin() is initiated");

		return new ResponseEntity<Admin>(
				(Admin) adminServiceImpl.Login(admin.getEmail(), admin.getPassword(), admin.getUserType()),
				HttpStatus.OK);
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws MethodArgumentNotValidException {

		LOGGER.info("addAdmin URL is opened");
		LOGGER.info("createAdmin() is initiated");

		return new ResponseEntity<>(adminServiceImpl.addAdmin(admin), HttpStatus.OK);
	}

	@GetMapping("/getAdmin")
	public List<Admin> get() {

		LOGGER.info("getAdmin URL is opened");
		LOGGER.info("getAdmin() is initiated");

		return adminServiceImpl.getAdmin();
	}

	@PatchMapping("/updateAdminPassword/{id}")
	public ResponseEntity<Admin> updateAdminPasswordById(@Valid @PathVariable Long id, @RequestParam String oldPassword,
			@RequestParam String newPassword)
			throws AdminNotFoundException, MethodArgumentNotValidException, ValidationException {

		LOGGER.info("updateAdminPassword URL is opened");
		LOGGER.info("updateAdminPassword() is initiated");

		return new ResponseEntity<Admin>(adminServiceImpl.updateAdminPasswordById(id, oldPassword, newPassword),
				HttpStatus.OK);
	}

	@PatchMapping("/updateAdminMobileNo/{id}")

	public ResponseEntity<Admin> UpdateMobileNo(@Valid @PathVariable Long id, @RequestParam Long oldMobileNo,
			@RequestParam Long newMobileNo)
			throws CustomerNotFoundException, MethodArgumentNotValidException, ValidationException {
		LOGGER.info("updateAdminMobileNo URL is opened");
		LOGGER.info("updateAdminMobileNo() is initiated");
		return new ResponseEntity<Admin>(adminServiceImpl.updateAdminMobileNoById(id, oldMobileNo, newMobileNo),
				HttpStatus.OK);

	}

	@PatchMapping("/updateAdminEmail/{id}")

	public ResponseEntity<Admin> updateEmail(@Valid @PathVariable Long id, @RequestParam String oldEmail,
			@RequestParam String newEmail)
			throws CustomerNotFoundException, MethodArgumentNotValidException, ValidationException {
		LOGGER.info("updateAdminEmail URL is opened");
		LOGGER.info("updateAdminEmail() is initiated");
		return new ResponseEntity<Admin>(adminServiceImpl.updateAdminEmailById(id, oldEmail, newEmail), HttpStatus.OK);

	}

	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@Valid @PathVariable Long id)
			throws AdminNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("deleteAdmin URL is opened");
		LOGGER.info("deleteAdmin() is initiated");

		adminServiceImpl.deleteAdmin(id);
	}

	// -----------------------------Travels---------------------------------//

	@PostMapping("/admin/addTravel")
	public ResponseEntity<Travel> addTravel(@Valid @RequestBody Travel travel) throws MethodArgumentNotValidException {

		LOGGER.info("addTravel URL is opened");
		LOGGER.info("addTravel() is initiated");

		return new ResponseEntity<>(travelServiceImpl.addTravel(travel), HttpStatus.OK);
	}

	@GetMapping("/admin/getTravels")
	public List<Travel> getTravels() {

		LOGGER.info("getTravels URL is opened");
		LOGGER.info("getTravels() is initiated");

		return travelServiceImpl.getAllTravel();
	}

//	@GetMapping("/admin/getTravelsById/{id}")
//	public ResponseEntity<Travel> getById(@PathVariable("travelId") Long travelId) throws TravelsNotFoundException{
//		return new  ResponseEntity<Travel>(travelServiceImpl.getTravelById(travelId),HttpStatus.OK);
//	}

//	@GetMapping("/admin/travel/{id}/getBuses")
//	public List<Bus> getBusesByTravelId(@Valid @PathVariable Long travelId) throws BusNotFoundException, TravelsNotFoundException ,MethodArgumentNotValidException{
//		
//		LOGGER.info("getBuses URL is opened");
//		LOGGER.info("getBusesByTravelId() is initiated");
//		
//		return busRepository.getBusesByTravelId(travelId);
//	}

//	@GetMapping("/admin/travel/{travelAgentName}/getBuses")
//	public List<Bus> getBusesByTravelAgentName(@Valid @PathVariable String travelAgentName) throws BusNotFoundException, TravelsNotFoundException , MethodArgumentNotValidException{
//		
//		LOGGER.info("getBusesByTravelAgentName URL is opened");
//		LOGGER.info("getBusesByTravelAgentName() is initiated");
//		
//		return busRepository.getBusesByTravelAgentName(travelAgentName);
//	}

	@PatchMapping("/admin/updateTravel/{id}")
	public ResponseEntity<Travel> updateTravel(@Valid @PathVariable Long id, @RequestParam TravelAgentName oldName,
			TravelAgentName newName)
			throws TravelsNotFoundException, MethodArgumentNotValidException, ValidationException {

		LOGGER.info("updateTravel URL is opened");
		LOGGER.info("updateTravel() is initiated");

		Travel newTravel = travelServiceImpl.updateTravelById(id, oldName, newName);
		return new ResponseEntity<>(newTravel, HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteTravel/{id}")
	public void deleteById(@Valid @PathVariable Long id)
			throws TravelsNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("deleteTravel URL is opened");
		LOGGER.info("deleteById() is initiated");

		travelServiceImpl.delete(id);
	}

	// --------------------------------Routes----------------------------------//

	@PostMapping("/admin/addRoute")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) throws MethodArgumentNotValidException {

		LOGGER.info("addRoute URL is opened");
		LOGGER.info("addRoute() is initiated");

		return new ResponseEntity<>(routeServiceImpl.addRoute(route), HttpStatus.OK);
	}

	@GetMapping("/admin/getRoutes")
	public List<Route> getRoutes() {

		LOGGER.info("getRoutes URL is opened");
		LOGGER.info("getRoutes() is initiated");

		return routeServiceImpl.getAllRoute();
	}

	@GetMapping("/admin/getRouteById/{id}")
	public ResponseEntity<Route> getRouteById(@Valid @PathVariable Long id)
			throws RouteNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getRouteById URL is opened");
		LOGGER.info("getRouteById() is initiated");

		return new ResponseEntity<Route>(routeServiceImpl.getRouteByRouteId(id), HttpStatus.OK);
	}

	@GetMapping("/admin/getRouteBySource/{source}")
	public List<Route> getRoutesBySource(@Valid @PathVariable String source)
			throws RouteNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getRouteBySource URL is opened");
		LOGGER.info("getRouteBySource() is initiated");

		return routeServiceImpl.getRouteBySource(source);
	}

	@GetMapping("/admin/getRoute/{source}/{destination}")
	public List<Route> getRoutesBySourceAndDestination(@Valid @PathVariable String source, String Destination)
			throws RouteNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("getRoute URL is opened");
		LOGGER.info("getRoutesBySourceAndDestination() is initiated");

		return routeServiceImpl.getRouteBySourceAndDestination(source, Destination);
	}

	@PutMapping("/admin/updateRoute/{id}")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route)
			throws RouteNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateRoute URL is opened");
		LOGGER.info("updateRoute() is initiated");

		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

	@PatchMapping("/updateSourceByRouteId/{id}")
	public ResponseEntity<Route> updateSourceByRouteId(@Valid @PathVariable Long id, @RequestParam String oldSource,
			@RequestParam String newSource) throws AdminNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateSourceByRouteId URL is opened");
		LOGGER.info("updateSourceByRouteId() is initiated");

		return new ResponseEntity<Route>(routeServiceImpl.updateSourceById(id, oldSource, newSource), HttpStatus.OK);
	}

	@PatchMapping("/updateDestinationByRouteId/{id}")
	public ResponseEntity<Route> updateDestinationByRouteId(@Valid @PathVariable Long id,
			@RequestParam String oldDestination, @RequestParam String newDestination)
			throws AdminNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("updateDestinationByRouteId URL is opened");
		LOGGER.info("updateDestinationByRouteId() is initiated");

		return new ResponseEntity<Route>(routeServiceImpl.updateDestinationById(id, oldDestination, newDestination),
				HttpStatus.OK);
	}

	@DeleteMapping("/admin/deleteRoute/{id}")
	public void deleteRouteById(@Valid @PathVariable Long id)
			throws RouteNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("deleteRoute URL is opened");
		LOGGER.info("deleteRouteById() is initiated");

		routeServiceImpl.delete(id);
	}

	@PatchMapping("/admin/partialUpdateRoute/{id}")
	public ResponseEntity<Route> partialUpdateRoute(@Valid @RequestBody Route route)
			throws RouteNotFoundException, MethodArgumentNotValidException {

		LOGGER.info("partialUpdateRoute URL is opened");
		LOGGER.info("partialUpdateRoute() is initiated");

		Route newRoute = routeServiceImpl.updateRoute(route);
		return new ResponseEntity<>(newRoute, HttpStatus.OK);
	}

//	@GetMapping("/route/{id}/buses")
//	public List<Bus> getAllBuses(@PathVariable Long routeId) {
//		return busServiceImpl.getBusesByRouteId(routeId);
//	}

	// -------------------------------Buses----------------------------------//

	@GetMapping("/admin/buses")
	public List<Bus> getBuses() {

		LOGGER.info("getBuses URL is opened");
		LOGGER.info("getBuses() is initiated");

		return busServiceImpl.getAllBuses();
	}

	// --------------------------Customers-------------------------------------//

	@GetMapping("/admin/getCustomers")
	public List<Customer> getCustomers() {
		LOGGER.info("getCustomers URL is opened");
		LOGGER.info("getCustomers() is initiated");

		return customerServiceImpl.getAllCustomer();
	}

}
