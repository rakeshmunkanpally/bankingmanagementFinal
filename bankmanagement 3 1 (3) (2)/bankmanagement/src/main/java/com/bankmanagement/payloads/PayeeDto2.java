package com.bankmanagement.payloads;

public class PayeeDto2 {

	private Integer receiverAccountNo;
	private String  branchId;
	private String branchName;
	private String  receiverName;
	
	public PayeeDto2() {
		super();
	}

	public PayeeDto2(Integer receiverAccountNo, String branchId, String branchName, String receiverName) {
		super();
		this.receiverAccountNo = receiverAccountNo;
		this.branchId = branchId;
		this.branchName = branchName;
		this.receiverName = receiverName;
	}

	public Integer getReceiverAccountNo() {
		return receiverAccountNo;
	}

	public void setReceiverAccountNo(Integer receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	
	
}
