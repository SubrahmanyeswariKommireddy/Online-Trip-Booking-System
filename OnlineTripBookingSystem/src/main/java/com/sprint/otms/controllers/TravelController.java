package com.sprint.otms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/travels/{id}")
	public Travel getTravelsById(@PathVariable Long travelId) {
		return travelServiceImpl.getTravelById(travelId);
	}
	
//	@GetMapping("/travel/{id}/buses")
//	public List<Bus> getBusesByTravels(@PathVariable Long travelId) {
//		return busServiceImpl.getBusesByTravelId(travelId);
//	}
	
//	@GetMapping("/travel/{travelAgentName}/buses")
//	public List<Bus> getBusesByTravelAgents(@PathVariable String travelAgentName) {
//		return busServiceImpl.getBusesByTravelAgentName(travelAgentName);
//	}

	@PostMapping("/travel/route/addBus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
		return new ResponseEntity<>(busServiceImpl.addBus(bus), HttpStatus.OK);
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
//
//	@GetMapping("/admin/route/{id}/{travelAgentName}")
//	public List<Travel> getTravelByRoute(@PathVariable String travelAgentName) {
//		return travelServiceImpl.getRouteByTravelAgentName(travelAgentName);
//	}
}
