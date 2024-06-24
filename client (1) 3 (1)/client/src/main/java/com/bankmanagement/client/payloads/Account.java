package com.bankmanagement.client.payloads;

public class Account {


	private Integer accountNo;
	
	private String accountName;

	public Account() {
		super();
	}

	public Account(Integer accountNo, String accountName) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	

}
