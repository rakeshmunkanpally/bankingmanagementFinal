package com.bankmanagement.payloads;

import java.time.LocalDate;

public class UserDto {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private LocalDate dateOfBirth;
	private String gender;
	private String password;
	private String address;
	private String status;
	private String branchId;
	public UserDto() {
		super();
	}
	public UserDto(Integer userId, String firstName, String lastName, String email, String phoneNo,
			LocalDate dateOfBirth, String gender, String password, String address, String status, String branchId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.password = password;
		this.address = address;
		this.status = status;
		this.branchId = branchId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", password="
				+ password + ", address=" + address + ", status=" + status + ", branchId=" + branchId + "]";
	}

	
}
