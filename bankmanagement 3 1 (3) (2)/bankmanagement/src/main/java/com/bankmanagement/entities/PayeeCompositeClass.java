package com.bankmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PayeeCompositeClass {
	@ManyToOne
	@JoinColumn(name="SENDER_ACCOUNT_NO")
	private Account senderAccountNo;
	@Column(name="RECIEVER_ACCOUNT_NO")
	private Integer recieverAccountNo;
	public PayeeCompositeClass() {
		// TODO Auto-generated constructor stub
	}
	public PayeeCompositeClass(Account senderAccountNo, Integer recieverAccountNo) {
		super();
		this.senderAccountNo = senderAccountNo;
		this.recieverAccountNo = recieverAccountNo;
	}
	public Account getSenderAccountNo() {
		return senderAccountNo;
	}
	public void setSenderAccountNo(Account senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}
	public Integer getRecieverAccountNo() {
		return recieverAccountNo;
	}
	public void setRecieverAccountNo(Integer recieverAccountNo) {
		this.recieverAccountNo = recieverAccountNo;
	}
	@Override
	public String toString() {
		return "PayeeCompositeClass [senderAccountNo=" + senderAccountNo + ", recieverAccountNo=" + recieverAccountNo
				+ "]";
	}
	

}
