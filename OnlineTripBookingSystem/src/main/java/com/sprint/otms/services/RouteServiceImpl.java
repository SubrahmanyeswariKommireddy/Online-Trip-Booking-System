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
	public String delete(Long routeId) {
		// TODO Auto-generated method stub
		routeRepository.deleteById(routeId);
		return "success";
	}

	@Override
	public Route getRouteByRouteId(Long routeId) {
		// TODO Auto-generated method stub
		return routeRepository.getById(routeId);
	}

	@Override
	public List<Route> getRouteBySource(String source) {
		// TODO Auto-generated method stub
		return routeRepository.getBySource(source);
	}

	@Override
	public List<Route> getRouteByDestination(String destination) {
		// TODO Auto-generated method stub
		return routeRepository.getByDestination(destination);
	}

	@Override
	public List<Route> getRouteBySourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		return routeRepository.getBySourceAndDestination(source, destination);
	}

}
