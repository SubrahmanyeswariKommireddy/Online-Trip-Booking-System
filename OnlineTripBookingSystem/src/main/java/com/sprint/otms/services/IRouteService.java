package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Route;

@Service
@Transactional
public interface IRouteService {

	/**
	 * @param route
	 * @return
	 */
	public Route addRoute(Route route);

	/**
	 * @return
	 */
	public List<Route> getAllRoute();

	/**
	 * @param route
	 * @return
	 */
	public Route updateRoute(Route route);

	/**
	 * @param routeId
	 * @return
	 */
	public String delete(Long routeId);

	/**
	 * @param routeId
	 * @return
	 */
	public Route getRouteByRouteId(Long routeId);

	/**
	 * @param source
	 * @return
	 */
	public List<Route> getRouteBySource(String source);

	/**
	 * @param destination
	 * @return
	 */
	public List<Route> getRouteByDestination(String destination);

	/**
	 * @param source
	 * @param destination
	 * @return
	 */
	public List<Route> getRouteBySourceAndDestination(String source, String destination);

	/**
	 * @param id
	 * @param oldSource
	 * @param newSource
	 * @return
	 * @throws ValidationException
	 */
	public Route updateSourceById(Long id, String oldSource, String newSource) throws ValidationException;

	/**
	 * @param id
	 * @param oldDestination
	 * @param newDestination
	 * @return
	 * @throws ValidationException
	 */
	public Route updateDestinationById(Long id, String oldDestination, String newDestination)
			throws ValidationException;
}
