package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Travel;

@Repository
public interface ITravelRepository extends JpaRepository<Travel, Long> {

	// public List<Travel> getRouteByTravelAgentName(String travelAgentName);

	// @Query("select travel from Travel travel join travel.travelAgentName tan
	// where tan.")

//	@Query("select guard from Guard guard join guard.guardShifts gs where gs.inTime = ?1 and gs.outTime = ?2")
//	public List<Guard> getGuardsByTimings(LocalDateTime inTime, LocalDateTime outTime);
}
