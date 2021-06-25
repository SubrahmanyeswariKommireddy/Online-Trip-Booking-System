package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Route;

/**
 * 
 * @author Mehboob Subani
 *
 */
@Service
@Transactional
public interface IRouteService {

	/**
	 * @param route
	 * @return Route
	 */
	public Route addRoute(Route route);

	/**
	 * @return all Routes
	 */
	public List<Route> getAllRoute();

	/**
	 * @param route
	 * @return Updated Route
	 */
	public Route updateRoute(Route route);

	/**
	 * @param routeId
	 */
	public String delete(Long routeId);

	/**
	 * @param routeId
	 * @return Route By Route Id
	 */
	public Route getRouteByRouteId(Long routeId);

	/**
	 * @param source
	 * @return all Routes By source
	 */
	public List<Route> getRouteBySource(String source);

	/**
	 * @param destination
	 * @return all Routes By Destination
	 */
	public List<Route> getRouteByDestination(String destination);

	/**
	 * @param source
	 * @param destination
	 * @return Route By Source And Destination
	 */
	public List<Route> getRouteBySourceAndDestination(String source, String destination);

	/**
	 * @param id
	 * @param oldSource
	 * @param newSource
	 * @return Updated Source For a Route By Route Id
	 * @throws ValidationException
	 */
	public Route updateSourceById(Long id, String oldSource, String newSource) throws ValidationException;

	/**
	 * @param id
	 * @param oldDestination
	 * @param newDestination
	 * @return Updated Destination For a Route By Route Id
	 * @throws ValidationException
	 */
	public Route updateDestinationById(Long id, String oldDestination, String newDestination)
			throws ValidationException;
}
