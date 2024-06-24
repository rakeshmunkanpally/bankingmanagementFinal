package com.bankmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="BRANCH")
public class Branch {
	@Id
	@Column(length=10)
	private String branchId;
	@Column(length = 25)
	private String branchName;
	@ManyToOne
	@JoinColumn(name="BANK_ID")
	private Bank bank;
	public Branch() {
		// TODO Auto-generated constructor stub
	}
	public Branch(String branchId, String branchName, Bank bank) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.bank = bank;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
