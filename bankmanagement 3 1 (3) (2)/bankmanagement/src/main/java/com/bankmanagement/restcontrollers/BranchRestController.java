package com.bankmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.entities.Branch;
import com.bankmanagement.services.BranchServices;



@CrossOrigin
@RestController
@RequestMapping("bankmanagement/branch")
public class BranchRestController {

	@Autowired
	BranchServices branchServices;
	
	@GetMapping("/")
	public ResponseEntity<List<Branch>> getBranchById(){
		
		return  new ResponseEntity<List<Branch>>(branchServices.getAllBrachesByBankId("B101"),HttpStatus.OK);
	}
	
	@GetMapping("/other")
	public ResponseEntity<List<Branch>> getBranchByIdNot(){
		
		return  new ResponseEntity<List<Branch>>(branchServices.getAllBrachesByBankIdNot(null),HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Branch> insertBranch(@RequestBody Branch branch){
		return new ResponseEntity<Branch>(branchServices.insertBranch(branch),HttpStatus.OK);
	}
}
