package com.bankmanagement.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.entities.Bank;
import com.bankmanagement.services.impl.BankServicesImpl;

@CrossOrigin
@RestController
@RequestMapping("/bankmanagement/bank")
public class BankRestController {

	@Autowired
	BankServicesImpl bankServicesImpl;
	@PostMapping("/")
	public ResponseEntity<Bank> insertBank(@RequestBody Bank bank) {
		return ResponseEntity.ok(bankServicesImpl.insertBank(bank));
	}
}
