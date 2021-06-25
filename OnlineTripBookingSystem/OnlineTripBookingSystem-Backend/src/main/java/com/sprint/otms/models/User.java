package com.sprint.otms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Entity
@Table(name = "user_details_table1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	@NotBlank(message = "Username is mandatory")
	private String userName;

	@NotBlank(message = "Password is mandatory")
	private String password;

	@Pattern(regexp = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b")
	private String email;

	@NotNull
	private Long mobileNumber;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "User_Type")
	private User_Type userType;

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public User(Long id) {
		super();
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 */
	public User(Long id, String userName, String password, String email, Long mobileNumber, User_Type userType) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.userType = userType;
	}

	/**
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 */
	public User(String userName, String password, String email, Long mobileNumber, User_Type userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.userType = userType;
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNumber
	 */
	public User(Long id, String userName, String password, String email, Long mobileNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @param userName
	 * @param password
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return User Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return User Name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Mobile Number
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return User Type
	 */
	public User_Type getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 */
	public void setUserType(User_Type userType) {
		this.userType = userType;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", userType=" + userType + "]";
	}
}
