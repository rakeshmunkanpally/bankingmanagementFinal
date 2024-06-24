package com.bankmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="FUND_TRANSFER")
public class FundTransfer {
	@Id
	@SequenceGenerator(name="REFERENCE_NUMBER",sequenceName = "REFERENCE_SEQUENCE",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "REFERENCE_NUMBER")
	private Integer referenceNo;
	@ManyToOne
	@JoinColumns({@JoinColumn(name= "SENDER_ACCOUNT_NO",referencedColumnName = "SENDER_ACCOUNT_NO"),
			@JoinColumn(name="RECIEVER_ACCOUNT_NO",referencedColumnName = "RECIEVER_ACCOUNT_NO")})
	private Payee payee;
	public FundTransfer() {
		// TODO Auto-generated constructor stub
	}
	public FundTransfer(Integer referenceNo, Payee payee) {
		super();
		this.referenceNo = referenceNo;
		this.payee = payee;
	}
	public Integer getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(Integer referenceNo) {
		this.referenceNo = referenceNo;
	}
	public Payee getPayee() {
		return payee;
	}
	public void setPayee(Payee payee) {
		this.payee = payee;
	}

}
