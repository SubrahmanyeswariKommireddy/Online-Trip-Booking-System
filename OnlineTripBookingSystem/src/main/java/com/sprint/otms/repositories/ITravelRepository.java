package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Bus;
import com.sprint.otms.models.Route;
import com.sprint.otms.models.Travel;

@Repository
public interface ITravelRepository extends JpaRepository<Travel, Long> {

	//public List<Travel> getRouteByTravelAgentName(String travelAgentName);

}
