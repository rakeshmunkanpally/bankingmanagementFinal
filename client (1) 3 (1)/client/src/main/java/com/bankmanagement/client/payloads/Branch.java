package com.bankmanagement.client.payloads;

public class Branch {

	private String branchId;
	private String branchName;
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
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", bank=" + bank + "]";
	}

	
}
