package com.bankmanagement.client.payloads;


public class Bank {

	private String bankId;
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
