package com.sprint.otms.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name="bus_details")
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long busId;
	private Float fare;
	private Long totalCapacity;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "Bus_Type")
	private BusType busType;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Booking booking;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
	@JoinColumn(name="bus_route", nullable=false)
	private Route route;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="bus_travel", nullable=false)
	private Travel travel;

	public Bus() {
		super();
	}

	public Bus(Long busId, Float fare, Long totalCapacity, BusType busType) {
		super();
		this.busId = busId;
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.busType = busType;
	}

	public Bus(Float fare, Long totalCapacity, BusType busType) {
		super();
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.busType = busType;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Float getFare() {
		return fare;
	}

	public void setFare(Float fare) {
		this.fare = fare;
	}

	public Long getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", fare=" + fare + ", totalCapacity=" + totalCapacity + ", busType=" + busType
				+ "]";
	}
}
