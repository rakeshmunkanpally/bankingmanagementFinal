package com.bankmanagement.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.entities.Admin;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.Login;
import com.bankmanagement.services.AdminServices;
@CrossOrigin
@RestController
@RequestMapping("/bankmanagement/admin")
public class AdminRestController {

	@Autowired
	AdminServices adminServices;
	@PostMapping("/")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
		return ResponseEntity.ok(adminServices.createAdmin(admin));
		
	}
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> checkAdmin(@RequestBody Login login){
		ApiResponse apiResponse=adminServices.checkCredentials(login);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	@PutMapping("/userstatus/{status}/{userId}")
	public ResponseEntity<ApiResponse> changeStatus(@PathVariable("status") String status, @PathVariable("userId") Integer userId){
		ApiResponse apiResponse= adminServices.changeUserStatus(status, userId);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
}
