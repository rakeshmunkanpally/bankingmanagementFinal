package com.bankmanagement.services;

import com.bankmanagement.entities.Admin;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.Login;

public interface AdminServices {

	Admin createAdmin(Admin admin);
	ApiResponse checkCredentials(Login adminLogin);
	ApiResponse changeUserStatus(String status, Integer userId);
}
