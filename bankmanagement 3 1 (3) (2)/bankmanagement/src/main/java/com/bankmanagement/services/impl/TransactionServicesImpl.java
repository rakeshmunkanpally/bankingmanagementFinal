package com.bankmanagement.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Transaction;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.payloads.OtherBankTransfer;
import com.bankmanagement.payloads.SameBankTransfer;
import com.bankmanagement.payloads.TransactionDto;
import com.bankmanagement.repositories.TransactionRepository;
import com.bankmanagement.services.AccountServices;
import com.bankmanagement.services.TransactionServices;

@Service
public class TransactionServicesImpl implements TransactionServices {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountServices accountServices;
	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getByReferenceId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double depositAmount(TransactionDto deposit,Integer accountNo) {
		 Transaction transaction=latestTransaction(accountNo) ;
			double balance=transaction.getBalance()+deposit.getAmount();
			Transaction transaction2=new Transaction();
			transaction2.setAmount(deposit.getAmount().doubleValue());
			transaction2.setBalance(balance);
			transaction2.setAccount(accountServices.getById(accountNo));
			transaction2.setDescription("DEPOSIT");
			transaction2.setTrasactionDate(LocalDateTime.now());
			transaction2.setRemarks(deposit.getRemarks());
			transactionRepository.save(transaction2);
			return balance;
	}

	@Override
	public Double withdrawAmount(TransactionDto withdraw, Integer accountNo) {
		Transaction transaction=latestTransaction(accountNo);
		if(transaction.getBalance()>withdraw.getAmount()) {
			double balance=transaction.getBalance()-withdraw.getAmount();
			Transaction transaction2=new Transaction();
			transaction2.setAccount(accountServices.getById(accountNo));
			transaction2.setAmount(withdraw.getAmount().doubleValue());
			transaction2.setDescription("WITHDRAW");
			transaction2.setRemarks(withdraw.getRemarks());
			transaction2.setTrasactionDate(LocalDateTime.now());
			transaction2.setBalance(balance);
			transactionRepository.save(transaction2);
			return balance;
		}
		else
			throw new MyException("Error ! balance Is "+transaction.getBalance()+" but Trying To withdraw : "+withdraw.getAmount());
	}

	@Override
	public Transaction latestTransaction(Integer accountNo) {
		
		return transactionRepository.findTopByAccountAccountNoOrderByTransactionDateDesc(accountNo);
	}

	@Override
	public Transaction createTransactionBySameBank(SameBankTransfer sameBankTransfer, Integer referenceNo) {
		Transaction transaction= latestTransaction(sameBankTransfer.getSenderAccountNo());
		double balance=transaction.getBalance();
		if(balance>sameBankTransfer.getAmount()) {
			balance-=sameBankTransfer.getAmount();
			Transaction newTransaction=new Transaction(referenceNo, "DEBIT", sameBankTransfer.getAmount().doubleValue(),balance,LocalDateTime.now(), accountServices.getById(sameBankTransfer.getSenderAccountNo()),"Sent To : "+accountServices.getById(sameBankTransfer.getReceiverAccountNo()).getUser().getFirstName());
			transactionRepository.save(newTransaction);
			Transaction transaction2=new Transaction();
			transaction2.setAccount(accountServices.getById(sameBankTransfer.getReceiverAccountNo()));
			transaction2.setAmount(sameBankTransfer.getAmount().doubleValue());
			transaction2.setDescription("CREDIT");
			transaction2.setRemarks("Received from : "+transaction.getAccount().getUser().getFirstName());
			transaction=latestTransaction(sameBankTransfer.getReceiverAccountNo());
			
			transaction2.setBalance(transaction.getBalance()+transaction2.getAmount());
			transaction2.setTrasactionDate(LocalDateTime.now());
			transactionRepository.save(transaction2);
			return newTransaction;
		}
		throw new MyException("Insufficent Balance");
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction createTransactionByOtherBank(OtherBankTransfer otherBankTransfer, Integer referenceNo) {
		Transaction transaction=latestTransaction(otherBankTransfer.getSenderAccountNo());
		double balance=transaction.getBalance();
		if(balance>otherBankTransfer.getAmount()) {
			balance-=otherBankTransfer.getAmount();
			Transaction transaction2=new  Transaction(referenceNo,"DEBIT",otherBankTransfer.getAmount().doubleValue(), balance, LocalDateTime.now(), accountServices.getById(otherBankTransfer.getSenderAccountNo()), "Sent To "+ otherBankTransfer.getReceiverName());
			return transactionRepository.save(transaction2);
		}
			
		throw new MyException("Insufficent Balance");
	}

}
