package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Route;

/**
 * 
 * @author Mehboob Subani
 *
 */
@Repository
public interface IRouteRepository extends JpaRepository<Route, Long> {

	/**
	 * @param routeId
	 * @return Route by Route Id
	 */
	public Route findRouteByRouteId(Long routeId);

	/**
	 * @param source
	 * @return all sources
	 */
	public List<Route> getBySource(String source);

	/**
	 * @param destination
	 * @return all Destinations
	 */
	public List<Route> getByDestination(String destination);

	/**
	 * @param source
	 * @param destination
	 * @return source and Destination
	 */
	public List<Route> getBySourceAndDestination(String source, String destination);
}
