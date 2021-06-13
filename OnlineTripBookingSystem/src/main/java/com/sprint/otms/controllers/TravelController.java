package com.sprint.otms.controllers;

import java.util.List;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

import com.sprint.otms.exceptions.CustomerNotFoundException;
import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Travel;
import com.sprint.otms.services.BusServiceImpl;
import com.sprint.otms.services.TravelServiceImpl;

@RestController
public class TravelController {

	static final Logger LOGGER = LoggerFactory.getLogger(TravelController.class);

	@Autowired
	private TravelServiceImpl travelServiceImpl;

	@Autowired
	private BusServiceImpl busServiceImpl;

	/**
	 * @return
	 */
	@GetMapping("/travels")
	public List<Travel> getAllTravels() {

		LOGGER.info("getAllTravels URL is opened");
		LOGGER.info("getAllTravels() is initiated");

		return travelServiceImpl.getAllTravel();
	}

	/**
	 * @param travelId
	 * @return
	 * @throws MethodArgumentNotValidException
	 */
	@GetMapping("/getTravelsById/{travelId}")
	public ResponseEntity<Travel> getById(@Valid @RequestParam Long travelId) throws MethodArgumentNotValidException {

		LOGGER.info("getTravelsbyId URL is opened");
		LOGGER.info("getById() is initiated");

		return new ResponseEntity<Travel>(travelServiceImpl.getTravelById(travelId), HttpStatus.OK);
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

	/**
	 * @param bus
	 * @return 
	 * @throws MethodArgumentNotValidException
	 */
	
	@PostMapping("/travel/addBus")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus) throws MethodArgumentNotValidException {

		LOGGER.info("addBus URL is opened");
		LOGGER.info("addBus() is initiated");

		return new ResponseEntity<>(busServiceImpl.addBus(bus), HttpStatus.OK);
	}

	/**
	 * @return
	 */
	
	@GetMapping("/getBuses")
	public List<Bus> get() {

		LOGGER.info("getBuses URL is opened");
		LOGGER.info("getBuses() is initiated");

		return busServiceImpl.getAllBuses();
	}

	/**
	 * @param id
	 * @return
	 * @throws MethodArgumentNotValidException
	 */
	
	@GetMapping("/getBus/{id}")
	public Bus getBusById(@PathVariable Long id) throws MethodArgumentNotValidException {

		LOGGER.info("getBusById URL is opened");
		LOGGER.info("getBusById() is initiated");

		return busServiceImpl.getBusById(id);
	}

	/**
	 * @param bus
	 * @return
	 * @throws MethodArgumentNotValidException
	 */
	@PutMapping("/updateBus/{id}")
	public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus) throws MethodArgumentNotValidException {

		LOGGER.info("updateBus URL is opened");
		LOGGER.info("updateBus() is initiated");

		Bus newBus = busServiceImpl.updateBus(bus);
		return new ResponseEntity<>(newBus, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param oldFare
	 * @param newFare
	 * @return
	 * @throws CustomerNotFoundException
	 * @throws MethodArgumentNotValidException
	 * @throws ValidationException
	 */
	@PatchMapping("/updateFareById/{id}")

	public ResponseEntity<Bus> updateFare(@Valid @PathVariable Long id, @RequestParam Float oldFare,
			@RequestParam Float newFare)
			throws CustomerNotFoundException, MethodArgumentNotValidException, ValidationException {
		LOGGER.info("updateFare URL is opened");
		LOGGER.info("updateFare() is initiated");
		return new ResponseEntity<Bus>(busServiceImpl.updateFareById(id, oldFare, newFare), HttpStatus.OK);

	}

	/**
	 * @param id
	 * @throws MethodArgumentNotValidException
	 */
	@DeleteMapping("/bus/{id}")
	public void deleteBus(@Valid @PathVariable Long id) throws MethodArgumentNotValidException {

		LOGGER.info("deleteBus URL is opened");
		LOGGER.info("deleteBus() is initiated");

		busServiceImpl.delete(id);
	}

//	@GetMapping("/buses/travel/{id}")
//	public List<Bus> getBusesByTravelId(@PathVariable Long travelId) {
//		return busServiceImpl.getBusesByTravelId(travelId);
//	}

}
