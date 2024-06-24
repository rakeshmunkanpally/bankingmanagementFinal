package com.bankmanagement.services;

import java.util.List;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.Branch;
import com.bankmanagement.payloads.AccountUserDto;
import com.bankmanagement.payloads.TransactionDetails;
import com.bankmanagement.payloads.UserDto;

public interface AccountServices {

	Account createAccount(UserDto userDto, Branch branch);
	Account updateAccount(Account account);
	Account getById(Integer id);
	Account getAccountByUserId(Integer userId);
	List<AccountUserDto> getAll(Integer accountNo);
	List<TransactionDetails> getAllTransactions(Integer accoutNo);
}
