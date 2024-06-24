package com.bankmanagement.client.payloads;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class SameBankTransfer {

	private Integer senderAccountNo;
	@NotNull
	private Integer receiverAccountNo;
	@NotNull(message = "Enter Amonut")
	@DecimalMin(value = "0.0", inclusive = false, message = "Enter Value Greater than 0")
	@Digits(integer = 5,fraction = 0,message="Deposit Range 1-99999")
	private Integer amount;
	
	public SameBankTransfer() {
		// TODO Auto-generated constructor stub
	}

	public SameBankTransfer(Integer senderAccountNo, Integer receiverAccountNo,
			@NotNull(message = "Enter Amonut") @DecimalMin(value = "0.0", inclusive = false, message = "Enter Value Greater than 0") @Digits(integer = 5, fraction = 0, message = "Deposit Range 1-99999") Integer amount) {
		super();
		this.senderAccountNo = senderAccountNo;
		this.receiverAccountNo = receiverAccountNo;
		this.amount = amount;
	}

	public Integer getSenderAccountNo() {
		return senderAccountNo;
	}

	public void setSenderAccountNo(Integer senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}

	public Integer getReceiverAccountNo() {
		return receiverAccountNo;
	}

	public void setReceiverAccountNo(Integer receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	
}
