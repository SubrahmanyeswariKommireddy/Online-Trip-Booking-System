package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;
import com.sprint.otms.repositories.ITravelRepository;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Service
@Transactional
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
	public String delete(Long travelId) {
		// TODO Auto-generated method stub
		travelRepository.deleteById(travelId);
		return "success";
	}

	@Override
	public Travel getTravelById(Long travelId) {
		// TODO Auto-generated method stub
		Travel t = travelRepository.getById(travelId);
		return t;
	}

	@Override
	public List<Travel> getTravelByName(String travelAgentName) {
		// TODO Auto-generated method stub
		return travelRepository.findAll();
	}

	@Override
	public Travel updateTravelById(Long id, TravelAgentName oldName, TravelAgentName newName)
			throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Travel> travel = travelRepository.findById(id);
		if (travel != null) {
			if (travel.get().getTravelAgentName().equals(oldName)) {
				travel.get().setTravelAgentName(newName);
				return travelRepository.save(travel.get());
			} else {
				throw new ValidationException("Incorrect name");
			}
		}
		return travel.get();
	}

}
