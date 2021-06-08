package com.sprint.otms.services;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.springframework.stereotype.Service;
>>>>>>> 7d6e68e752165ed2ff64803dd6d28e8f0c176ded

import com.sprint.otms.models.Route;
import com.sprint.otms.repositories.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService{
@Autowired
private IRouteRepository routeRepository;
	@Override
	public Route addRoute(Route route) {
		// TODO Auto-generated method stub
		return routeRepository.saveAndFlush(route);
	}

	@Override
	public List<Route> getAllRoute() {
		// TODO Auto-generated method stub
		return routeRepository.findAll();
	}

	@Override
	public Route updateRoute(Route route) {
		// TODO Auto-generated method stub
		return routeRepository.saveAndFlush(route);
	}

	@Override
	public void delete(Long routeId) {
		// TODO Auto-generated method stub
		routeRepository.deleteById(routeId);
	}

	@Override
	public Route getRouteById(Long routeId) {
		// TODO Auto-generated method stub
		return routeRepository.findRouteById(routeId);
	}

	@Override
	public List<Route> getRouteBySourceStation(String source) {
		// TODO Auto-generated method stub
		return routeRepository.findBySourceName(source);
	}

	@Override
	public List<Route> getRouteByDestinationtation(String destination) {
		// TODO Auto-generated method stub
		return routeRepository.findByDestinationName(destination);
	}

	@Override
	public List<Route> getRouteBySourceAndDestinationStation(String source, String destination) {
		// TODO Auto-generated method stub
		return routeRepository.findBySourceNameAndDestinationName(source, destination);
	}

}
