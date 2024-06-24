package com.bankmanagement.payloads;

public class OtherBankTransfer {

	private Integer senderAccountNo;
	private Integer receiverAccountNo;
	private String receiverName;
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
