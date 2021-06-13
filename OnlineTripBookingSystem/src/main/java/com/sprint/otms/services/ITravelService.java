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
	 * @return
	 */
	public Travel addTravel(Travel travel);

	/**
	 * @return
	 */
	public List<Travel> getAllTravel();

	/**
	 * @param travel
	 * @return
	 */
	public Travel updateTravel(Travel travel);

	/**
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws ValidationException
	 */
	public Travel updateTravelById(Long id, TravelAgentName oldPassword, TravelAgentName newPassword)
			throws ValidationException;

	/**
	 * @param travelId
	 * @return
	 */
	public String delete(Long travelId);

	/**
	 * @param travelId
	 * @return
	 */
	public Travel getTravelById(Long travelId);

	/**
	 * @param travelAgentName
	 * @return
	 */
	public List<Travel> getTravelByName(String travelAgentName);

	// public List<Travel> getRouteByTravelAgentName(String travelAgentName);

}
