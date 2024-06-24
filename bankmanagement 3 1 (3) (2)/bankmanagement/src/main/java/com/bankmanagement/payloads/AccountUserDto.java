package com.bankmanagement.payloads;

public class AccountUserDto {
 
	private Integer accountNo;
	private String accountName;
	public AccountUserDto() {
		super();
	}
	public AccountUserDto(Integer accountNo, String accountName) {
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
