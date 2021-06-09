//package com.sprint.otms.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sprint.otms.models.Bus;
//import com.sprint.otms.models.Travel;
//import com.sprint.otms.services.BusServiceImpl;
//import com.sprint.otms.services.TravelServiceImpl;
//
//@RestController
//public class BusController {
//
//	@Autowired
//	private BusServiceImpl busServiceImpl;
//
//	@PostMapping("/addBus")
//	public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
//		return new ResponseEntity<>(busServiceImpl.addBus(bus), HttpStatus.OK);
//	}
//
//	@GetMapping("/buses")
//	public List<Bus> get() {
//		return busServiceImpl.getAllBuses();
//	}
//
//	@GetMapping("/bus/{id}")
//	public Bus getBusById(@PathVariable Long id) {
//		return busServiceImpl.getBusById(id);
//	}
//
////	@GetMapping("/buses/travel/{id}")
////	public List<Bus> getBusesByTravelId(@PathVariable Long travelId) {
////		return busServiceImpl.getBusesByTravelId(travelId);
////	}
//
//	@PutMapping("/updateBus/{id}")
//	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
//		Bus newBus = busServiceImpl.updateBus(bus);
//		return new ResponseEntity<>(newBus, HttpStatus.OK);
//	}
//
//	@PatchMapping("/partialUpdateBus/{id}")
//	public ResponseEntity<Bus> partialUpdateBus(@RequestBody Bus bus) {
//		Bus newBus = busServiceImpl.updateBus(bus);
//		return new ResponseEntity<>(newBus, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/bus/{id}")
//	public void deleteBus(@PathVariable Long id) {
//		busServiceImpl.delete(id);
//	}
//}
