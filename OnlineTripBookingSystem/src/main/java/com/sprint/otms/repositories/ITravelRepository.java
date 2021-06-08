package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Travel;

@Repository
public interface ITravelRepository extends JpaRepository<Travel, Long> {

	List<Travel> findOne(String travelAgentName);

}
