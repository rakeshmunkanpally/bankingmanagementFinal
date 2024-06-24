package com.bankmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.OtherBankTransfer;
import com.bankmanagement.payloads.PayeeDto;
import com.bankmanagement.payloads.PayeeDto2;
import com.bankmanagement.payloads.SameBankTransfer;
import com.bankmanagement.services.FundTransferServices;
import com.bankmanagement.services.PayeeServices;


@CrossOrigin
@RestController
@RequestMapping("/bankmanagement/fundtransfer")
public class FundTransferRestController {

	@Autowired
	PayeeServices payeeServices;
	@Autowired
	FundTransferServices fundTransferServices;
	
	@GetMapping("/{senderAccountNo}")
	public ResponseEntity<List<PayeeDto>> getAllPayee(@PathVariable("senderAccountNo") Integer senderAccountNo){
		return ResponseEntity.ok(payeeServices.getAllPayeeBySenderAccountNo(senderAccountNo));
	}
	@GetMapping("otherBank/{senderAccountNo}")
	public ResponseEntity<List<PayeeDto>> getAllPayee2(@PathVariable("senderAccountNo") Integer senderAccountNo){
		return ResponseEntity.ok(payeeServices.getAllOtherPayeeBySenderAccountNo(senderAccountNo));
	}
	@PostMapping("/createPayee")
	public ResponseEntity<?> addPayee(@RequestBody PayeeDto payeeDto){
		return ResponseEntity.ok(new ApiResponse(payeeServices.addPayee(payeeDto).getRecieverName(), true));
	}
	@PostMapping("/createPayee2/{senderAccountNo}")
	public ResponseEntity<?> addPayee2(@RequestBody PayeeDto2 payeeDto,@PathVariable Integer senderAccountNo){
		return ResponseEntity.ok(new ApiResponse(payeeServices.addPayee2(payeeDto,senderAccountNo).getRecieverName(), true));
	}
	
	@PostMapping("/createFundTransfer")
	public ResponseEntity<ApiResponse> addFundTransfer(@RequestBody SameBankTransfer sameBankTransfer){
		return ResponseEntity.ok(fundTransferServices.createFundTransfer(sameBankTransfer));
	}
	@PostMapping("/createFundTransfer2")
	public ResponseEntity<ApiResponse> addFundTransfer2(@RequestBody OtherBankTransfer otherBankTransfer){
		return ResponseEntity.ok(fundTransferServices.createFundTransfer2(otherBankTransfer));
	}
}
