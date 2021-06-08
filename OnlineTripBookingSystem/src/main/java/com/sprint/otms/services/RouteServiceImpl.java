package com.sprint.otms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Optional<Route> getRouteById(Long routeId) {
		// TODO Auto-generated method stub
		return routeRepository.findById(routeId);
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
