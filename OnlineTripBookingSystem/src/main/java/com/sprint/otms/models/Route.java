package com.sprint.otms.models;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="route_otms_details")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long routeId;
	private String source;
	private String destination;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="route", fetch=FetchType.LAZY)
	private List<Bus> buses;

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(Long routeId, String source, String destination, List<Bus> buses) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.buses = buses;
	}

	public Route(String source, String destination, List<Bus> buses) {
		super();
		this.source = source;
		this.destination = destination;
		this.buses = buses;
	}
	public Route(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	public Route(Long routeId) {
		this.routeId = routeId;
		// TODO Auto-generated constructor stub
	}

	public Route(String source) {
		this.source = source;
		// TODO Auto-generated constructor stub
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", buses=" + buses
				+ "]";
	}
}
