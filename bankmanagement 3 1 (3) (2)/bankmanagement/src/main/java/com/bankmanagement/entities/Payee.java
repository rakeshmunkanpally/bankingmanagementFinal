package com.bankmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="PAYEE")
public class Payee {

	@EmbeddedId
	private PayeeCompositeClass payeeCompositeClass;
	@Column(length = 40)
	private String recieverName;
	@Column(length=20,nullable = true)
	private String branchId;
	
	public Payee() {
		// TODO Auto-generated constructor stub
	}

	public Payee(PayeeCompositeClass payeeCompositeClass, String recieverName, String branchId) {
		super();
		this.payeeCompositeClass = payeeCompositeClass;
		this.recieverName = recieverName;
		this.branchId = branchId;
	}

	public PayeeCompositeClass getPayeeCompositeClass() {
		return payeeCompositeClass;
	}

	public void setPayeeCompositeClass(PayeeCompositeClass payeeCompositeClass) {
		this.payeeCompositeClass = payeeCompositeClass;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	
}
