package com.iiht.evaluation.eloan.model;

public class User {
	
	private String username;
	private String password;
	private String Mobile_No;
	private String Address;
	private String email_ID;
	public User() {
		
	}
	public String getMobileNo() {
		return Mobile_No;
	}
	public void setMobileNo(String mobile_No) {
		this.Mobile_No = mobile_No;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getEmail_ID() {
		return email_ID;
	}
	public void setEmail_ID(String email_ID) {
		this.email_ID = email_ID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password, String emailID, String address, String email_ID, String mobile_No) {
		super();
		this.username = username;
		this.password = password;
		this.email_ID = email_ID;
		this.Address = address;
		this.Mobile_No = mobile_No;

	}
	

}
