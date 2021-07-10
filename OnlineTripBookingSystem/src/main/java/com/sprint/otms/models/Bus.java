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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

/**
 * 
 * @author Stephen
 *
 */
@Entity
@Table(name = "bus_tableOne")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long busId;

	@NotNull
	private Float fare;

	@NotNull
	private Long totalCapacity;
	private Long currentCapacity;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "Bus_Type")
	private BusType busType;

	@OneToOne(fetch = FetchType.LAZY)
	private Booking booking;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "bus_route")
	//@JsonBackReference
	private Route route;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "bus_travel")
	private Travel travel;

	public Bus() {
		super();
	}

	/**
	 * @param fare
	 * @param totalCapacity
	 */
	public Bus(Float fare, Long totalCapacity) {
		super();
		this.fare = fare;
		this.totalCapacity = totalCapacity;
	}

	/**
	 * @param busId
	 * @param fare
	 * @param totalCapacity
	 * @param busType
	 */
	public Bus(Long busId, Float fare, Long totalCapacity, BusType busType) {
		super();
		this.busId = busId;
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.busType = busType;
	}

	/**
	 * @param fare
	 * @param totalCapacity
	 * @param busType
	 */
	public Bus(Float fare, Long totalCapacity, BusType busType) {
		super();
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.busType = busType;
	}

	/**
	 * @param fare
	 */
	public Bus(float fare) {
		super();
		this.fare = fare;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param busId
	 * @param fare
	 * @param totalCapacity
	 * @param currentCapacity
	 * @param busType
	 * @param booking
	 * @param route
	 * @param travel
	 */
	public Bus(Long busId, Float fare, Long totalCapacity, Long currentCapacity, BusType busType, Booking booking,
			Route route, Travel travel) {
		super();
		this.busId = busId;
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.currentCapacity = currentCapacity;
		this.busType = busType;
		this.booking = booking;
		this.route = route;
		this.travel = travel;
	}

	/**
	 * @param fare
	 * @param totalCapacity
	 * @param currentCapacity
	 */
	public Bus(Float fare, Long totalCapacity, Long currentCapacity) {
		super();
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.currentCapacity = currentCapacity;
	}

	/**
	 * @param id
	 * @param fare
	 * @param totalCapacity
	 * @param currentCapacity
	 */
	public Bus(Long id, float fare, Long totalCapacity, Long currentCapacity) {
		// TODO Auto-generated constructor stub
		super();
		this.busId = id;
		this.fare = fare;
		this.totalCapacity = totalCapacity;
		this.currentCapacity = currentCapacity;
	}

	/**
	 * @return Bus By Id
	 */
	public Long getBusId() {
		return busId;
	}

	/**
	 * @param busId
	 */
	public void setBusId(Long busId) {
		this.busId = busId;
	}

	/**
	 * @return Fare
	 */
	public Float getFare() {
		return fare;
	}

	/**
	 * @param fare
	 */
	public void setFare(Float fare) {
		this.fare = fare;
	}

	/**
	 * @return Total Capacity of Bus
	 */
	public Long getTotalCapacity() {
		return totalCapacity;
	}

	/**
	 * @param totalCapacity
	 */
	public void setTotalCapacity(Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	/**
	 * @return Bus Type
	 */
	public BusType getBusType() {
		return busType;
	}

	/**
	 * @param busType
	 */
	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	/**
	 * @return Current Capacity Of a Bus
	 */
	public Long getCurrentCapacity() {
		return currentCapacity;
	}

	/**
	 * @param currentCapacity
	 */
	public void setCurrentCapacity(Long currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", fare=" + fare + ", totalCapacity=" + totalCapacity + ", currentCapacity="
				+ currentCapacity + ", busType=" + busType + ", booking=" + booking + ", route=" + route + ", travel="
				+ travel + "]";
	}
}
