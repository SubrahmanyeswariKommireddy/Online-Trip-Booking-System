package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Bus;

@Service
@Transactional
public interface IBusService {

	/**
	 * @param bus
	 * @return
	 */
	public Bus addBus(Bus bus);

	/**
	 * @param bus
	 * @return
	 */
	public Bus updateBus(Bus bus);

	/**
	 * @param busId
	 * @return
	 */
	public String delete(Long busId);

	/**
	 * @param busId
	 * @return
	 */
	public Bus getBusById(Long busId);

	/**
	 * @return
	 */
	public List<Bus> getAllBuses();

	/**
	 * @param id
	 * @param oldFare
	 * @param newFare
	 * @return
	 * @throws ValidationException
	 */
	public Bus updateFareById(Long id, Float oldFare, Float newFare) throws ValidationException;

//	public List<Bus> getBusesByTravelId(Long travelId);
//	
//	public List<Bus> getBusesByRouteId(Long routeId);

	// public List<Bus> getBusesByTravelAgentName(String travelAgentName);

}
