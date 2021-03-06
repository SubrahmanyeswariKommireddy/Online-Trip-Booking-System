package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.exceptions.BusNotFoundException;
import com.sprint.otms.models.Bus;
import com.sprint.otms.repositories.IBusRepository;

/**
 * 
 * @author Stephen
 *
 */
@Service
@Transactional
public class BusServiceImpl implements IBusService {

	@Autowired
	private IBusRepository busRepository;

	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		bus.setTotalCapacity(32L);
		bus.setCurrentCapacity(bus.getTotalCapacity());
		return busRepository.saveAndFlush(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		// TODO Auto-generated method stub
		Optional<Bus> b= busRepository.findById(bus.getBusId());
		if(b!=null) {
			b.get().setFare(bus.getFare());
			b.get().setTotalCapacity(32L);
			return busRepository.save(b.get());
		}
		
		else {
			throw new BusNotFoundException("bus not found");
		}
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

	@Override
	public Bus updateFareById(Long id, Float oldFare, Float newFare) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Bus> bus = busRepository.findById(id);
		if (bus != null) {
			if (bus.get().getFare().equals(oldFare)) {
				bus.get().setFare(newFare);
				return busRepository.save(bus.get());
			} else {
				throw new ValidationException("Incorrect Fare");
			}
		}
		return bus.get();

	}

}
