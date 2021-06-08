package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Long> {

	public Route findRouteByRouteId(Long routeId);

	public List<Route> getBySource(String source);

	public List<Route> getByDestination(String destination);

	public List<Route> getBySourceAndDestination(String source, String destination);
}
