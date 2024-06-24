package com.bankmanagement.client.payloads;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Login {

	@NotNull(message = "Enter Id Number")
	@DecimalMin(value = "0.0" , inclusive = false, message="UserId must be greater than 0")
	@Digits(integer = 5, fraction = 0, message = "Range (0,99999)")
	private Integer id;
	@Size(min = 6, message = "Password min length 6")
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(@NotNull(message = "User ID should be Entered") Integer id,
			@Size(min = 6, message = "Password min length 6") String password) {
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
