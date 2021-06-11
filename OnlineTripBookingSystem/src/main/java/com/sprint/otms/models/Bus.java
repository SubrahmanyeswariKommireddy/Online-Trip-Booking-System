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
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name="bus_otms_details3")
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long busId;
	@NotNull
	private Float fare;
    @NotNull
	private Long totalCapacity;
    private int currentEmptySeat;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "Bus_Type")
	private BusType busType;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Booking booking;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
	@JoinColumn(name="bus_route")
	private Route route;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="bus_travel")
	private Travel travel;

	public Bus() {
		super();
	}
	

	public Bus(Float fare, Long totalCapacity) {
		super();
		this.fare = fare;
		this.totalCapacity = totalCapacity;
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

	public Bus(float fare) {
		super();
		this.fare = fare;
		// TODO Auto-generated constructor stub
	}


	public Bus(Long busId, Float fare, Long totalCapacity, int currentEmptySeat, BusType busType, Booking booking,
			Route route, Travel travel) {
		super();
		this.busId = busId;
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.currentEmptySeat = currentEmptySeat;
		this.busType = busType;
		this.booking = booking;
		this.route = route;
		this.travel = travel;
	}


	public Bus(Float fare, Long totalCapacity, int currentEmptySeat) {
		super();
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.currentEmptySeat = currentEmptySeat;
	}


	public int getCurrentEmptySeat() {
		return currentEmptySeat;
	}


	public void setCurrentEmptySeat(int currentEmptySeat) {
		this.currentEmptySeat = currentEmptySeat;
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
		return "Bus [busId=" + busId + ", fare=" + fare + ", totalCapacity=" + totalCapacity + ", currentEmptySeat="
				+ currentEmptySeat + ", busType=" + busType + ", booking=" + booking + ", route=" + route + ", travel="
				+ travel + "]";
	}

}
