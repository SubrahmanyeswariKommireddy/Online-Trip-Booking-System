package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Travel;
import com.sprint.otms.models.TravelAgentName;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Service
@Transactional
public interface ITravelService {

	/**
	 * @param travel
	 * @return Travel
	 */
	public Travel addTravel(Travel travel);

	/**
	 * @return all Travels
	 */
	public List<Travel> getAllTravel();

	/**
	 * @param travel
	 * @return Updated Travel
	 */
	public Travel updateTravel(Travel travel);

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return Updated Travel
	 * @throws ValidationException
	 */
	public Travel updateTravelById(Long id, TravelAgentName oldPassword, TravelAgentName newPassword)
			throws ValidationException;

	/**
	 * @param travelId
	 */
	public String delete(Long travelId);

	/**
	 * @param travelId
	 * @return Travel By Travel Id
	 */
	public Travel getTravelById(Long travelId);

	/**
	 * @param travelAgentName
	 * @return all Travels
	 */
	public List<Travel> getTravelByName(String travelAgentName);

	// public List<Travel> getRouteByTravelAgentName(String travelAgentName);

}
