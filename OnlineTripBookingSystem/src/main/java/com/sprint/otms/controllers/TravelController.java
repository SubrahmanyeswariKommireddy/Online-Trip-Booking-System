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

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.RouteServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

@RestController
public class TravelController {

	@Autowired
	private TravelServiceImpl travelServiceImpl;

	@Autowired
	private BusServiceImpl busServiceImpl;
	
	@GetMapping("/travels")
	public List<Travel> getAllTravels() {
		return travelServiceImpl.getAllTravel();
	}
	
	@GetMapping("/getTravelsById/{id}")
	public ResponseEntity<Travel> getById(@RequestParam Long travelId) {
		return new  ResponseEntity<Travel>(travelServiceImpl.getTravelById(travelId),HttpStatus.OK);
	}
//	@GetMapping("/travels/{id}")
//	public Travel getTravelsById(@PathVariable Long travelId) {
//		return travelServiceImpl.getTravelById(travelId);
//	}
	
//	@GetMapping("/travel/{id}/buses")
//	public List<Bus> getBusesByTravels(@PathVariable Long travelId) {
//		return busServiceImpl.getBusesByTravelId(travelId);
//	}
	
//	@GetMapping("/travel/{travelAgentName}/buses")
//	public List<Bus> getBusesByTravelAgents(@PathVariable String travelAgentName) {
//		return busServiceImpl.getBusesByTravelAgentName(travelAgentName);
//	}

	@PostMapping("/travel/addBus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
		return new ResponseEntity<>(busServiceImpl.addBus(bus), HttpStatus.OK);
	}
	
	@GetMapping("/getBuses")
	public List<Bus> get() {
		return busServiceImpl.getAllBuses();
	}

	@GetMapping("/getBus/{id}")
	public Bus getBusById(@PathVariable Long id) {
		return busServiceImpl.getBusById(id);
	}
	
	@PutMapping("/updateBus/{id}")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
		Bus newBus = busServiceImpl.updateBus(bus);
		return new ResponseEntity<>(newBus, HttpStatus.OK);
	}

	@PatchMapping("/partialUpdateBus/{id}")
	public ResponseEntity<Bus> partialUpdateBus(@RequestBody Bus bus) {
		Bus newBus = busServiceImpl.updateBus(bus);
		return new ResponseEntity<>(newBus, HttpStatus.OK);
	}
	
	@DeleteMapping("/bus/{id}")
	public void deleteBus(@PathVariable Long id) {
		busServiceImpl.delete(id);
	}
	
//	@GetMapping("/buses/travel/{id}")
//	public List<Bus> getBusesByTravelId(@PathVariable Long travelId) {
//		return busServiceImpl.getBusesByTravelId(travelId);
//	}

}
