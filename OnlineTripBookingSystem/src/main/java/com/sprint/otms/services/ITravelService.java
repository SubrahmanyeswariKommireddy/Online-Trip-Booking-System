package com.sprint.otms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;

@Service
public interface ITravelService {

		public Travel addTravel(Travel travel);

		public List<Travel> getAllTravel();

		public Travel updateTravel(Travel travel);

		public String  delete(Long travelId);

		public Travel getTravelById(Long travelId);

		public List<Travel> getTravelByName(String travelAgentName);
		
		//public List<Travel> getRouteByTravelAgentName(String travelAgentName);

}
