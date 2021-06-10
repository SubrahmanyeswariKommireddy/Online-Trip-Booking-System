package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Bus;
import com.sprint.otms.repositories.IBusRepository;

@Service
@Transactional
public class BusServiceImpl implements IBusService{
	
	@Autowired
	private IBusRepository busRepository;

	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.saveAndFlush(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.saveAndFlush(bus);
	}

	@Override
	public String delete(Long busId) {
		// TODO Auto-generated method stub
		busRepository.deleteById(busId);
		return "success";
	}

	@Override
	public Bus getBusById(Long busId) {
		// TODO Auto-generated method stub
		return busRepository.getById(busId);
	}

	@Override
	public List<Bus> getAllBuses() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}

//	@Override
//	public List<Bus> getBusesByTravelId(Long travelId) {
//		// TODO Auto-generated method stub
//		return busRepository.findAllById(travelId);
//	}
//
//	@Override
//	public List<Bus> getBusesByRouteId(Long routeId) {
//		// TODO Auto-generated method stub
//		return busRepository.findAllById(routeId);
//	}

//	@Override
//	public List<Bus> getBusesByTravelAgentName(String travelAgentName) {
//		// TODO Auto-generated method stub
//		return busRepository.findAllByTravelAgentName(travelAgentName);
//	}	
}
