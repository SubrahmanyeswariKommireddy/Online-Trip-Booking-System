package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Admin;
import com.sprint.otms.models.Bus;

@Service
@Transactional
public interface IBusService {

	public Bus addBus(Bus bus);

	public Bus updateBus(Bus bus);

	public String delete(Long busId);

	public Bus getBusById(Long busId);

	public List<Bus> getAllBuses();
	
	public Bus updateFareById(Long id, Float oldFare, Float newFare) throws ValidationException;
	
//	public List<Bus> getBusesByTravelId(Long travelId);
//	
//	public List<Bus> getBusesByRouteId(Long routeId);
	
	//public List<Bus> getBusesByTravelAgentName(String travelAgentName);

}
	



