package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Customer;
import com.sprint.otms.models.Route;

@Service
@Transactional
public interface IRouteService {

	public Route addRoute(Route route);

	public List<Route> getAllRoute();

	public Route updateRoute(Route route);

	public String delete(Long routeId);

	public Route getRouteByRouteId(Long routeId);

	public List<Route> getRouteBySource(String source);

	public List<Route> getRouteByDestination(String destination);

	public List<Route> getRouteBySourceAndDestination(String source, String destination);
	
	public Route updateSourceById(Long id, String oldSource, String newSource) throws ValidationException;
	
	public Route updateDestinationById(Long id, String oldDestination, String newDestination) throws ValidationException;
}
