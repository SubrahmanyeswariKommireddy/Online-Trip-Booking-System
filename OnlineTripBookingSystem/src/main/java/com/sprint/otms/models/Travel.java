package com.sprint.otms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author Subrahmanyeswari
 *
 */

@Entity
@Table(name = "travel_tableOne1")
public class Travel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long travelId;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "Travel_Agent_Name")
	private TravelAgentName travelAgentName;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "travel", fetch = FetchType.LAZY)
	private List<Bus> buses;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_travel")
	private Admin admin;

	/**
	 * Default Constructor
	 */
	public Travel() {
		super();
	}

	/**
	 * @param travelId
	 * @param travelAgentName
	 * @param buses
	 */
	public Travel(Long travelId, TravelAgentName travelAgentName, List<Bus> buses) {
		super();
		this.travelId = travelId;
		this.travelAgentName = travelAgentName;
		this.buses = buses;
	}

	/**
	 * @param travelAgentName
	 * @param buses
	 */
	public Travel(TravelAgentName travelAgentName, List<Bus> buses) {
		super();
		this.travelAgentName = travelAgentName;
		this.buses = buses;
	}

	/**
	 * @param travelAgentName
	 */
	public Travel(TravelAgentName travelAgentName) {
		super();
		this.travelAgentName = travelAgentName;
	}

	/**
	 * @param buses
	 */
	public Travel(List<Bus> buses) {
		super();
		this.buses = buses;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param travelId
	 */
	public Travel(long travelId) {
		super();
		this.travelId = travelId;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Travel By Id
	 */
	public Long getTravelId() {
		return travelId;
	}

	/**
	 * @param travelId
	 */
	public void setTravelId(Long travelId) {
		this.travelId = travelId;
	}

	/**
	 * @return all Travel Agent Names
	 */
	public TravelAgentName getTravelAgentName() {
		return travelAgentName;
	}

	/**
	 * @param travelAgentName
	 */
	public void setTravelAgentName(TravelAgentName travelAgentName) {
		this.travelAgentName = travelAgentName;
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
		return "Travel [travelId=" + travelId + ", travelAgentName=" + travelAgentName + ", buses=" + buses + "]";
	}
}
