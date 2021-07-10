package com.sprint.otms.models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="busbooking_tableOne111")
@Embeddable
public class BusBooking {

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	
   private String name;
   private String email;
   private String mobileNumber;
   private String source;
   private String destination;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
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
public BusBooking(String name, String email, String mobileNumber, String source, String destination) {
	super();
	this.name = name;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.source = source;
	this.destination = destination;
}
public BusBooking() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BusBooking [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + ", source=" + source
			+ ", destination=" + destination + "]";
}

   
   
}
