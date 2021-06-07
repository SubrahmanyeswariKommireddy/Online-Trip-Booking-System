package com.sprint.otms.services;
import java.util.List;

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;

public interface ITravelService {


		public Travel addTravel(Travel travel);

		public List<Travel> getAllTravel();

		public Travel updateTravel(Travel travel);

		public void  delete(Long travelId);

		public Travel getTravelById(Long travelId);

		public List<Travel> getTravelByName(String travelAgentName);

}
