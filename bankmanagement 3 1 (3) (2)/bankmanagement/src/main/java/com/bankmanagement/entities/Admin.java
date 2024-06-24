package com.bankmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {
	@Id
	private Integer adminId;
	@Column(length=60)
	private String password;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(Integer adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
