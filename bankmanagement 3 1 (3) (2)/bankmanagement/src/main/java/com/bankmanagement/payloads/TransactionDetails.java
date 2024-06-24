package com.bankmanagement.payloads;

import java.time.LocalDateTime;


public class TransactionDetails {
	private Integer referenceNo;
	private String description;
	private Double amount;
	private Double balance;
	private LocalDateTime trasactionDate;
	private String remarks;
	public TransactionDetails() {
		super();
	}
	public TransactionDetails(Integer referenceNo, String description, Double amount, Double balance,
			LocalDateTime trasactionDate, String remarks) {
		super();
		this.referenceNo = referenceNo;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
		this.trasactionDate = trasactionDate;
		this.remarks = remarks;
	}
	public Integer getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(Integer referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDateTime getTrasactionDate() {
		return trasactionDate;
	}
	public void setTrasactionDate(LocalDateTime trasactionDate) {
		this.trasactionDate = trasactionDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
