package com.bankmanagement.entities;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_TABLE")
public class User {
	@Id
	private Integer userId;
	@Column(length = 25)
	private String firstName;
	@Column(length=25)
	private String lastName;
	@Column(length = 50,unique = true)
	private String email;
	@Column(length = 25, unique = true)
	private String phoneNo;
	@DateTimeFormat
	private LocalDate dateOfBirth;
	@Column(length=10)
	private String gender;
	@Column(length=60)
	private String password;
	@Column(length=100)
	private String address;
	@Column(length=1)
	private String status;
	@Column(length=10)
	private String branchId;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, String firstName, String lastName, String email, String phoneNo, LocalDate dateOfBirth,
			String gender, String password, String address, String status, String branchId) {
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
	

	
}
