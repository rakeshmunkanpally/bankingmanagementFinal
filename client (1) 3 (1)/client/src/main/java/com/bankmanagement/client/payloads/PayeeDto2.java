package com.bankmanagement.client.payloads;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PayeeDto2 {
	@NotNull(message = "Enter Account No")
	@DecimalMin(value = "0.0" , inclusive = false, message="UserId must be greater than 0")
	@Digits(integer = 9, fraction = 0, message = "Range (0,999999999)")
	private Integer receiverAccountNo;
	@NotBlank
	private String  branchId;
	@NotBlank
	private String branchName;
	
	@NotBlank
	private String  receiverName;
	
	public PayeeDto2() {
		super();
	}

	public PayeeDto2(Integer receiverAccountNo, @NotBlank String branchId, @NotBlank String branchName,
			@NotBlank String receiverName) {
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
