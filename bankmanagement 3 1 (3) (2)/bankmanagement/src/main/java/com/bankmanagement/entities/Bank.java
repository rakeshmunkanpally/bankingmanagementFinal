package com.bankmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BANK")
public class Bank {
	@Id
	@Column(length=10)
	private String bankId;
	@Column(nullable = false,length = 25)
	private String bankName;
	public Bank() {
		// TODO Auto-generated constructor stub
	}
	public Bank(String bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
