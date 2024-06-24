package com.bankmanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.FundTransfer;
import com.bankmanagement.entities.Payee;
import com.bankmanagement.entities.PayeeCompositeClass;
import com.bankmanagement.entities.Transaction;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.OtherBankTransfer;
import com.bankmanagement.payloads.SameBankTransfer;
import com.bankmanagement.repositories.FundTransferRepository;
import com.bankmanagement.services.AccountServices;
import com.bankmanagement.services.FundTransferServices;
import com.bankmanagement.services.PayeeServices;
import com.bankmanagement.services.TransactionServices;

@Service
public class FundTransferServicesImpl implements FundTransferServices{

	@Autowired
	AccountServices accountServices;
	@Autowired
	FundTransferRepository fundTransferRepository;
	@Autowired
	TransactionServices transactionServices;
	@Autowired
	PayeeServices payeeServices;
	@Override
	public ApiResponse createFundTransfer(SameBankTransfer sameBankTransfer) {
		PayeeCompositeClass payeeCompositeClass=new PayeeCompositeClass();
		payeeCompositeClass.setSenderAccountNo(accountServices.getById(sameBankTransfer.getSenderAccountNo()));
		payeeCompositeClass.setRecieverAccountNo(sameBankTransfer.getReceiverAccountNo());
		Payee payee=payeeServices.getByPayeeCompositeClass(payeeCompositeClass);
		if(payee==null) {
			
		}
		FundTransfer fundTransfer=new FundTransfer();
		fundTransfer.setPayee(payee);
		fundTransfer= fundTransferRepository.save(fundTransfer);
		 Transaction transaction= transactionServices.createTransactionBySameBank(sameBankTransfer, fundTransfer.getReferenceNo());
		return new ApiResponse("reference Id : "+fundTransfer.getReferenceNo()+"Receiver ACCOUNT : "+sameBankTransfer.getReceiverAccountNo()+"Amount Sent : "+transaction.getAmount()+" Balance : "+transaction.getBalance(), true);
	}
	@Override
	public FundTransfer getByPayee(Payee payee) {
		
		return fundTransferRepository.findByPayee(payee);
	}
	@Override
	public ApiResponse createFundTransfer2(OtherBankTransfer otherBankTransfer) {
		PayeeCompositeClass payeeCompositeClass=new PayeeCompositeClass();
		payeeCompositeClass.setRecieverAccountNo(otherBankTransfer.getReceiverAccountNo());
		payeeCompositeClass.setSenderAccountNo(accountServices.getById(otherBankTransfer.getSenderAccountNo()));
		Payee payee=payeeServices.getByPayeeCompositeClass(payeeCompositeClass);
		payee.setRecieverName(otherBankTransfer.getReceiverName());
		FundTransfer fundTransfer=fundTransferRepository.findByPayee(payee);
		if(fundTransfer==null) {
			fundTransfer=new FundTransfer();
			fundTransfer.setPayee(payee);
			fundTransfer=fundTransferRepository.save(fundTransfer);			
		}
			
		transactionServices.createTransactionByOtherBank(otherBankTransfer, fundTransfer.getReferenceNo());
		
		return new ApiResponse("Transaction Succesful ", true);
	}

}
