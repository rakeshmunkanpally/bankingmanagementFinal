package com.bankmanagement.client.payloads;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class PayeeDto {
	private Integer senderAccountNo;
	@NotNull(message = "Enter Account No")
	@DecimalMin(value = "0.0" , inclusive = false, message="UserId must be greater than 0")
	@Digits(integer = 9, fraction = 0, message = "Range (0,999999999)")
	private Integer receiverAccountNo;
	private String receiverName;
	public PayeeDto() {
		// TODO Auto-generated constructor stub
	}
	public PayeeDto(Integer senderAccountNo, @NotNull Integer receiverAccountNo, String receiverName) {
		super();
		this.senderAccountNo = senderAccountNo;
		this.receiverAccountNo = receiverAccountNo;
		this.receiverName = receiverName;
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
	@Override
	public String toString() {
		return "PayeeDto [senderAccountNo=" + senderAccountNo + ", receiverAccountNo=" + receiverAccountNo
				+ ", receiverName=" + receiverName + "]";
	}

	

}
