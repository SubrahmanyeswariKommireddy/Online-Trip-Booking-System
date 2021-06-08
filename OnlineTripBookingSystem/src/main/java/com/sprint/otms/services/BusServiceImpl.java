package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Bus;
import com.sprint.otms.repositories.IBusRepository;

@Service
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
	public void delete(Long busId) {
		// TODO Auto-generated method stub
		busRepository.deleteById(busId);
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
}
