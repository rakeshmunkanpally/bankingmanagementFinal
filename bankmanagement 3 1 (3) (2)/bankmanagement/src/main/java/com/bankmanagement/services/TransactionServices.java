package com.bankmanagement.services;

import java.util.List;

import com.bankmanagement.entities.Transaction;
import com.bankmanagement.payloads.OtherBankTransfer;
import com.bankmanagement.payloads.SameBankTransfer;
import com.bankmanagement.payloads.TransactionDto;

public interface TransactionServices {

	Transaction createTransaction(Transaction transaction);
	Transaction getByReferenceId(Integer id);
	Double depositAmount(TransactionDto deposit,Integer accountNo);
	Double withdrawAmount(TransactionDto withdraw,Integer accountNo);
	Transaction latestTransaction(Integer accountNo);
	Transaction createTransactionBySameBank(SameBankTransfer sameBankTransfer,Integer referenceNo);
	Transaction createTransactionByOtherBank(OtherBankTransfer otherBankTransfer, Integer referenceNo);
	List<Transaction> getAllTransactions();
}
