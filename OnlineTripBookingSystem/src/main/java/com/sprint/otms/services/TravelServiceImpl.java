package com.sprint.otms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.otms.models.Travel;
import com.sprint.otms.repositories.ITravelRepository;

@Service
public class TravelServiceImpl implements ITravelService {
	@Autowired
	private ITravelRepository travelRepository;

	@Override
	public Travel addTravel(Travel travel) {
		// TODO Auto-generated method stub
		return travelRepository.saveAndFlush(travel);
	}

	@Override
	public List<Travel> getAllTravel() {
		// TODO Auto-generated method stub
		return travelRepository.findAll();
	}

	@Override
	public Travel updateTravel(Travel travel) {
		// TODO Auto-generated method stub
		return travelRepository.saveAndFlush(travel);
	}

	@Override
	public void delete(Long travelId) {
		// TODO Auto-generated method stub
		travelRepository.deleteById(travelId);
	}

	@Override
	public Travel getTravelById(Long travelId) {
		// TODO Auto-generated method stub
		return travelRepository.getById(travelId);
	}

	@Override
	public List<Travel> getTravelByName(String travelAgentName) {
		// TODO Auto-generated method stub
		return travelRepository.findAll();
	}

}
