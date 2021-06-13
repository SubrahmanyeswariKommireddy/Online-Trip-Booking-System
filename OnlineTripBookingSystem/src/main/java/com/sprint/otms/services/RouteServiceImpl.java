package com.sprint.otms.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.otms.models.Route;
import com.sprint.otms.repositories.IRouteRepository;

/**
 * 
 * @author Subani
 *
 */
@Service
@Transactional
public class RouteServiceImpl implements IRouteService {

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

	@Override
	public Route updateSourceById(Long id, String oldSource, String newSource) throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Route> route = routeRepository.findById(id);
		if (route != null) {
			if (route.get().getSource().equals(oldSource)) {
				route.get().setSource(newSource);
				return routeRepository.save(route.get());
			} else {
				throw new ValidationException("Incorrect Source");
			}
		}
		return route.get();
	}

	@Override
	public Route updateDestinationById(Long id, String oldDestination, String newDestination)
			throws ValidationException {
		// TODO Auto-generated method stub
		java.util.Optional<Route> route = routeRepository.findById(id);
		if (route != null) {
			if (route.get().getDestination().equals(oldDestination)) {
				route.get().setDestination(newDestination);
				return routeRepository.save(route.get());
			} else {
				throw new ValidationException("Incorrect Destination");
			}
		}
		return route.get();
	}
}
