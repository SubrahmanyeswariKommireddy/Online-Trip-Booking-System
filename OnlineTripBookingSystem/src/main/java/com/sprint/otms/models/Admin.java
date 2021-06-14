package com.sprint.otms.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Susmitha
 *
 */
@Entity
@Table(name = "admin_details_table1")
public class Admin extends User {

	@OneToMany(fetch = FetchType.LAZY)
	private List<Travel> travels;

	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 * @param travels
	 */
	public Admin(Long id, String userName, String password, String email, Long mobileNumber, User_Type userType,
			List<Travel> travels) {
		super(id, userName, password, email, mobileNumber, userType);
		// TODO Auto-generated constructor stub
		this.travels = travels;
	}

	/**
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 * @param travels
	 */
	public Admin(String userName, String password, String email, Long mobileNumber, User_Type userType,
			List<Travel> travels) {
		super(userName, password, email, mobileNumber, userType);
		this.travels = travels;
	}

	/**
	 * @param travels
	 */
	public Admin(List<Travel> travels) {
		super();
		this.travels = travels;
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 */
	public Admin(Long id, String userName, String password, String email, Long mobileNumber, User_Type userType) {
		super(id, userName, password, email, mobileNumber, userType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param password
	 */
	public Admin(String userName, String password) {
		// TODO Auto-generated constructor stub
		super(userName, password);
	}

	/**
	 * @return all Travels
	 */
	public List<Travel> getTravels() {
		return travels;
	}

	/**
	 * @param travels
	 */
	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Admin [travels=" + travels + "]";
	}
}
