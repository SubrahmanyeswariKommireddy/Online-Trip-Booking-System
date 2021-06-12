package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Bus;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Long> {

	@Query("select b from Bus b where b.travel.id = ?1  ")
	public List<Bus> getBusesByTravelId(Long travelId);

	@Query("select b from Bus b where b.travel.travelAgentName = ?1")
	public List<Bus> getBusesByTravelAgentName(String travelAgentName);
}
