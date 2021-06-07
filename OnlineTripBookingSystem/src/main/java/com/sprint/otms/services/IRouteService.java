package com.sprint.otms.services;

import java.util.List;

import com.sprint.otms.models.Route;




public interface IRouteService {

	public Route addRoute(Route route);

	public List<Route> getAllRoute();

	public Route updateRoute(Route route);

	public void  delete(Long routeId);

	public Route getRouteById(Long routeId);

	public List<Route> getRouteBySourceStation(String source);

	public List<Route> getRouteByDestinationtation(String destination);

	public List<Route> getRouteBySourceAndDestinationStation(String source, String destination);

}
