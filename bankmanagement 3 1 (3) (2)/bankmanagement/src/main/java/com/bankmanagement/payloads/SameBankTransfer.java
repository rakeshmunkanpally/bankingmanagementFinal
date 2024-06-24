package com.bankmanagement.payloads;


public class SameBankTransfer {

	private Integer senderAccountNo;
	private Integer receiverAccountNo;
	
	private Integer amount;
	
	public SameBankTransfer() {
		// TODO Auto-generated constructor stub
	}

	public SameBankTransfer(Integer senderAccountNo, Integer receiverAccountNo, Integer amount) {
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
