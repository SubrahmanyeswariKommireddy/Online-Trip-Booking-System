package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;

@Service
@Transactional
public interface ITravelService {

	public Travel addTravel(Travel travel);

	public List<Travel> getAllTravel();

	public Travel updateTravel(Travel travel);

	public Travel updateTravelById(Long id, TravelAgentName oldPassword, TravelAgentName newPassword)
			throws ValidationException;

	public String delete(Long travelId);

	public Travel getTravelById(Long travelId);

	public List<Travel> getTravelByName(String travelAgentName);

	// public List<Travel> getRouteByTravelAgentName(String travelAgentName);

}
