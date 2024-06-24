package com.bankmanagement.client.payloads;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bankmanagement.client.bao.CheckDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDto {
	@NotNull(message = "Enter User Id")
	@Digits(integer = 5,fraction = 0,message = "Range(0-99999)")
	private Integer userId;
	@Size(min = 3,max = 25,message = "Range(3-25) letters")
	private String firstName;
	@Size(min = 3,max = 25,message = "Range(3-25) letters")
	private String lastName;
	@NotBlank
	@Email(message = "Enter Valid email")
	private String email;
	@Size(min = 10, max = 10,message = "Enter Valid Mobile No")
	private String phoneNo;
	@DateTimeFormat(iso = ISO.DATE)
	@CheckDate
	private LocalDate dateOfBirth;
	@NotBlank(message = "select Gender")
	private String gender;
	@Size(min = 6,message = "password must have min 6 letters")
	private String password;
	@NotBlank(message = "Enter Valid Address")
	private String address;
	
	private String status;
	@NotBlank(message = "Select Branch")
	private String branchId;
	public UserDto() {
		super();
	}
	public UserDto(
			@NotNull(message = "Enter User Id") @Digits(integer = 5, fraction = 0, message = "Range(0-99999)") Integer userId,
			@Size(min = 3, max = 25, message = "Range(3-25) letters") String firstName,
			@Size(min = 3, max = 25, message = "Range(3-25) letters") String lastName,
			@NotBlank @Email(message = "Enter Valid email") String email,
			@Size(min = 10, max = 10, message = "Enter Valid Mobile No") String phoneNo, LocalDate dateOfBirth,
			@NotBlank(message = "select Gender") String gender,
			@Size(min = 6, message = "password must have min 6 letters") String password,
			@NotBlank(message = "Enter Valid Address") String address, String status, String branchId) {
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
