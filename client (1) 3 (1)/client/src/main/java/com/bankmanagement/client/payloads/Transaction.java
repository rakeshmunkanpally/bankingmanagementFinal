package com.bankmanagement.client.payloads;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class Transaction {

	@NotNull(message = "Enter Amonut")
	@DecimalMin(value = "0.0", inclusive = false, message = "Enter Value Greater than 0")
	@Digits(integer = 5,fraction = 0,message="Deposit Range 1-99999")
	private Integer amount;
	private String remarks;
	
	public Transaction() {
		super();
	}
	public Transaction(
			@NotNull(message = "Enter Amonut") @DecimalMin(value = "0.0", inclusive = false, message = "Enter Value Greater than 0") @Digits(integer = 5, fraction = 0, message = "Deposit Range 1-99999") Integer amount,
			String remarks) {
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
