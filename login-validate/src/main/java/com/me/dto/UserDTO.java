package com.me.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
//DTO data transfer object server to client  
	
	private int usrId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private String password;
	private String userType;
	
	public UserDTO(int usrId, String firstName, String lastName, String email, String contactNo, String password , String userType) {
		super();
		this.usrId = usrId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
		this.userType = userType;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}