package com.bankmanagement.payloads;

public class PayeeDto {
	private Integer senderAccountNo;
	private Integer receiverAccountNo;
	private String receiverName;

	public PayeeDto() {
		// TODO Auto-generated constructor stub
	}

	public PayeeDto(Integer senderAccountNo, Integer receiverAccountNo, String receiverName) {
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

	
}
