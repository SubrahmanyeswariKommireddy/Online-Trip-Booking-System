package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Bus;

@Service
public interface IBusService {

	public Bus addBus(Bus bus);

	public Bus updateBus(Bus bus);

	public void delete(Long busId);

	public Bus getBusById(Long busId);

	public List<Bus> getAllBuses();

}
	



