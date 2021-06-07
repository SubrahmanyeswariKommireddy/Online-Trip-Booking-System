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

@Entity
@Table(name="travel_details")
public class Travel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long travelId;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "Travel_Agent_Name")
	private TravelAgentName travelAgentName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="travel", fetch=FetchType.LAZY)
	private List<Bus> buses;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
	@JoinColumn(name="admin_travel", nullable=false)
	private Admin admin;

	public Travel() {
		super();
	}

	public Travel(Long travelId, TravelAgentName travelAgentName, List<Bus> buses) {
		super();
		this.travelId = travelId;
		this.travelAgentName = travelAgentName;
		this.buses = buses;
	}

	public Travel(TravelAgentName travelAgentName, List<Bus> buses) {
		super();
		this.travelAgentName = travelAgentName;
		this.buses = buses;
	}

	public Long getTravelId() {
		return travelId;
	}

	public void setTravelId(Long travelId) {
		this.travelId = travelId;
	}

	public TravelAgentName getTravelAgentName() {
		return travelAgentName;
	}

	public void setTravelAgentName(TravelAgentName travelAgentName) {
		this.travelAgentName = travelAgentName;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return "Travel [travelId=" + travelId + ", travelAgentName=" + travelAgentName + ", buses=" + buses + "]";
	}
}
