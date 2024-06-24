package com.bankmanagement.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.payloads.AccountUserDto;
import com.bankmanagement.payloads.TransactionDetails;
import com.bankmanagement.services.AccountServices;

@CrossOrigin
@RestController
@RequestMapping("/bankmanagement/account/")
public class AccountRestController {

	@Autowired
	AccountServices accountServices;
	@GetMapping("/{userId}")
	public ResponseEntity<Integer> getAccountById(@PathVariable("userId") Integer userId){
		return ResponseEntity.ok(accountServices.getAccountByUserId(userId).getAccountNo());
	}
	@GetMapping("/getAccounts/{accountNo}")
	public ResponseEntity<List<AccountUserDto>> getAll(@PathVariable("accountNo") Integer accountNo){
		return ResponseEntity.ok(accountServices.getAll(accountNo));
	}
	@GetMapping("/transactions/{accountNo}")
	public ResponseEntity<List<TransactionDetails>> getAllTransactionsByAccount(@PathVariable Integer accountNo){
		return ResponseEntity.ok(accountServices.getAllTransactions(accountNo));
	}
	@GetMapping("/getAccountsByBranchId/{branchId}")
	public ResponseEntity<?> getAllAccountsByBranchId(@PathVariable String branchId){
		return ResponseEntity.ok(null);
	}
	
	
}
