package com.bankmanagement.client.payloads;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OtherBankTransfer {

	private Integer senderAccountNo;
	@NotNull
	private Integer receiverAccountNo;
	@NotBlank
	private String receiverName;
	@NotNull(message = "Enter Amonut")
	@DecimalMin(value = "0.0", inclusive = false, message = "Enter Value Greater than 0")
	@Digits(integer = 5,fraction = 0,message="Deposit Range 1-99999")
	private Integer amount;
	
	public OtherBankTransfer() {
		// TODO Auto-generated constructor stub
	}

	public OtherBankTransfer(Integer senderAccountNo, Integer receiverAccountNo, String receiverName, Integer amount) {
		super();
		this.senderAccountNo = senderAccountNo;
		this.receiverAccountNo = receiverAccountNo;
		this.receiverName = receiverName;
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

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
}
