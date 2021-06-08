package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Long> {

	public Route findRouteById(Long routeId);

	public List<Route> findBySourceName(String name);

	public List<Route> findByDestinationName(String name);

	public List<Route> findBySourceNameAndDestinationName(String source, String destination);
}
