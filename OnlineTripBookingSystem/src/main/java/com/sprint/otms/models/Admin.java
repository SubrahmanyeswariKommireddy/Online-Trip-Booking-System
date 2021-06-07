package com.sprint.otms.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="admin_otms_details")
public class Admin extends User{
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Travel> travels;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String userName, String password, String email, Long mobileNumber, List<Travel> travels) {
		super(id, userName, password, email, mobileNumber);
		// TODO Auto-generated constructor stub
		this.travels = travels;
	}

	public Admin(List<Travel> travels) {
		super();
		this.travels = travels;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "Admin [travels=" + travels + "]";
	}
}
