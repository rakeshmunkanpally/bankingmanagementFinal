package com.bankmanagement.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@SequenceGenerator(name = "ACCOUNT", initialValue = 10001,sequenceName = "ACCOUNT_SEQUENCE",allocationSize = 1)
	@GeneratedValue(generator = "ACCOUNT")
	@Column(name = "ACCOUNT_NO",length=10)
	private Integer accountNo;
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;
	@ManyToOne
	@JoinColumn(name="BRANCH_ID")
	private Branch branch;
	@OneToMany(mappedBy = "account")
	private List<Transaction> trasaction;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(Integer accountNo, User user, Branch branch, List<Transaction> trasaction) {
		super();
		this.accountNo = accountNo;
		this.user = user;
		this.branch = branch;
		this.trasaction = trasaction;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<Transaction> getTrasaction() {
		return trasaction;
	}
	public void setTrasaction(List<Transaction> trasaction) {
		this.trasaction = trasaction;
	}



}
