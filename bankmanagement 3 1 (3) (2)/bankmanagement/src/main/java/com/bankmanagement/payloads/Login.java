package com.bankmanagement.payloads;
public class Login {

	private Integer id;
	private String password;
	public Login() {
		super();
	}
	public Login(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
