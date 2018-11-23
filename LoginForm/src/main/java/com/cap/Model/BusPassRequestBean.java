package com.cap.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BusPassRequestBean {
	
	private Integer requestId;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String email;
	private LocalDate dateOfJoining;
	private String location;
	private String pickUpLoc;
	private LocalTime pickUpTime;
	private String Designation;
	private String Status ="Pending";
	
	
	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public BusPassRequestBean() {
		super();
	}



	public BusPassRequestBean(Integer requestId, String employeeId, String firstName, String lastName, String gender,
			String address, String email, LocalDate dateOfJoining, String location, String pickUpLoc,
			LocalTime pickUpTime) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.location = location;
		this.pickUpLoc = pickUpLoc;
		this.pickUpTime = pickUpTime;
	
	}



	public String getDesignation() {
		return Designation;
	}



	public void setDesignation(String designation) {
		Designation = designation;
	}



	public Integer getRequestId() {
		return requestId;
	}



	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}



	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}



	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getPickUpLoc() {
		return pickUpLoc;
	}



	public void setPickUpLoc(String pickUpLoc) {
		this.pickUpLoc = pickUpLoc;
	}



	public LocalTime getPickUpTime() {
		return pickUpTime;
	}



	public void setPickUpTime(LocalTime pickuptime2) {
		this.pickUpTime = pickuptime2;
	}



	@Override
	public String toString() {
		return "BusPassRequestBean [requestId=" + requestId + ", employeeId=" + employeeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", address=" + address + ", email=" + email
				+ ", dateOfJoining=" + dateOfJoining + ", location=" + location + ", pickUpLoc=" + pickUpLoc
				+ ", pickUpTime=" + pickUpTime + "]";
	}
	
	
	
	
	

}
