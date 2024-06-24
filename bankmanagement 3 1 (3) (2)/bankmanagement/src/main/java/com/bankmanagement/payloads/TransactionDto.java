package com.bankmanagement.payloads;


public class TransactionDto {

	private Integer amount;
	private String remarks;
	
	public TransactionDto() {
		// TODO Auto-generated constructor stub
	}

	public TransactionDto(Integer amount, String remarks) {
		super();
		this.amount = amount;
		this.remarks = remarks;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	
	
}
