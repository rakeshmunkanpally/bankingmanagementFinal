package com.bankmanagement.entities;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(generator = "REFERENCE_NUMBER")
	private Integer referenceNo;
	@Column(length=40)
	private String description;
	private Double amount;
	private Double balance;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime transactionDate;
	@ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;
	@Column(length = 50)
	private String remarks;
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(Integer referenceNo, String description, Double amount, Double balance,
			LocalDateTime transactionDate, Account account, String remarks) {
		super();
		this.referenceNo = referenceNo;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
		this.transactionDate = transactionDate;
		this.account = account;
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
		return transactionDate;
	}
	public void setTrasactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Transaction [referenceNo=" + referenceNo + ", description=" + description + ", amount=" + amount
				+ ", balance=" + balance + ", trasactionDate=" + transactionDate + ", account=" + account + ", remarks="
				+ remarks + "]";
	}

	
}
