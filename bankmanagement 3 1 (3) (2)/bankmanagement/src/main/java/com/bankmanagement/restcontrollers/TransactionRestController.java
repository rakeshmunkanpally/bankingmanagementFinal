package com.bankmanagement.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.entities.Transaction;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.TransactionDto;
import com.bankmanagement.payloads.UserProfile;
import com.bankmanagement.services.TransactionServices;

@RestController
@RequestMapping("/bankmanagement/transaction")
public class TransactionRestController {
@Autowired
TransactionServices transactionServices;
	
	@PostMapping("/deposit/{accountNo}")
	public ResponseEntity<?> depositAmount(@RequestBody TransactionDto deposit,@PathVariable("accountNo") Integer accountNo){
		return ResponseEntity.ok(transactionServices.depositAmount(deposit, accountNo));
	}
	@PostMapping("/withdraw/{accountNo}")
	public ResponseEntity<?> withdrawAmount(@RequestBody TransactionDto withdraw, @PathVariable("accountNo") Integer accountNo){
		return new ResponseEntity<>(new ApiResponse(transactionServices.withdrawAmount(withdraw, accountNo).toString(),true),HttpStatus.OK);
	}
	@GetMapping("/{accountNo}")
	public ResponseEntity<Double> getAccountBalance(@PathVariable Integer accountNo){
		return ResponseEntity.ok(transactionServices.latestTransaction(accountNo).getBalance());
	}
	@GetMapping("/userprofile/{accountNo}")
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable Integer accountNo){
		Transaction transaction=  transactionServices.latestTransaction(accountNo);
		return ResponseEntity.ok(new UserProfile(transaction.getAccount().getUser().getUserId(), transaction.getAccount().getUser().getFirstName(), transaction.getAccount().getUser().getLastName(),transaction.getAccount().getUser().getEmail(), transaction.getAccount().getUser().getPhoneNo(),transaction.getAccount().getUser().getDateOfBirth(), transaction.getAccount().getUser().getGender(), transaction.getAccount().getUser().getAddress(),transaction.getAccount().getAccountNo().toString(), transaction.getBalance()));
	}
}
