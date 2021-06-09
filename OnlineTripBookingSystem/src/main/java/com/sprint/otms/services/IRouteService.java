package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprint.otms.models.Route;

@Service
public interface IRouteService {

	public Route addRoute(Route route);

	public List<Route> getAllRoute();

	public Route updateRoute(Route route);

	public String delete(Long routeId);

	public Route getRouteByRouteId(Long routeId);

	public List<Route> getRouteBySource(String source);

	public List<Route> getRouteByDestination(String destination);

	public List<Route> getRouteBySourceAndDestination(String source, String destination);
}
