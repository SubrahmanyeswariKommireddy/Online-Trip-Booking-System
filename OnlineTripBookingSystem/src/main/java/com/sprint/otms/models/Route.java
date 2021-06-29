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

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author mehboob subani
 *
 */
@Entity
@Table(name = "route_table")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long routeId;

	@NotBlank(message = "source is mandatory")
	private String source;

	@NotBlank(message = "destination is mandatory")
	private String destination;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "route", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Bus> buses;

	/**
	 * 
	 */
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param routeId
	 * @param source
	 * @param destination
	 * @param buses
	 */
	public Route(Long routeId, String source, String destination, List<Bus> buses) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.buses = buses;
	}

	/**
	 * @param source
	 * @param destination
	 * @param buses
	 */
	public Route(String source, String destination, List<Bus> buses) {
		super();
		this.source = source;
		this.destination = destination;
		this.buses = buses;
	}

	/**
	 * @param source
	 * @param destination
	 */
	public Route(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	/**
	 * @param routeId
	 */
	public Route(Long routeId) {
		this.routeId = routeId;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param source
	 */
	public Route(String source) {
		this.source = source;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Route By Id
	 */
	public Long getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId
	 */
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	/**
	 * @return all Sources
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return all destinations
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return all Buses
	 */
	public List<Bus> getBuses() {
		return buses;
	}

	/**
	 * @param buses
	 */
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", buses=" + buses
				+ "]";
	}
}
