package com.bankmanagement.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.Branch;
import com.bankmanagement.entities.User;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.payloads.AccountUserDto;
import com.bankmanagement.payloads.TransactionDetails;
import com.bankmanagement.payloads.UserDto;
import com.bankmanagement.repositories.AccountRepository;
import com.bankmanagement.services.AccountServices;
import com.bankmanagement.services.BranchServices;

@Service
public class AccountServicesImpl implements AccountServices {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ModelMapper mapper;
	@Autowired
	BranchServices branchServices;
	@Override
	public Account createAccount(UserDto userDto, Branch branch) {
		Account account=new Account();
		User user=mapper.map(userDto, User.class);
		branchServices.getById(branch.getBranchId());
		account.setUser(user);
		account.setBranch(branch);
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getById(Integer id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).orElseThrow(()-> new MyException("Account Not Found!"));
	}

	@Override
	public Account getAccountByUserId(Integer userId) {
		return accountRepository.findByUserUserId(userId).orElseThrow(()-> new MyException("error"));
	}

	@Override
	public List<AccountUserDto> getAll(Integer accountNo) {
		// TODO Auto-generated method stub
		return accountRepository.findAll().stream().filter(obj->!obj.getAccountNo().equals(accountNo)).map(obj->new AccountUserDto(obj.getAccountNo(), obj.getUser().getFirstName())).collect(Collectors.toList());
	}

	public List<TransactionDetails> getAllTransactions(Integer accoutNo){
		return getById(accoutNo).getTrasaction().stream().map(obj->new TransactionDetails(obj.getReferenceNo(), obj.getDescription(), obj.getAmount(), obj.getBalance(), obj.getTrasactionDate(), obj.getRemarks())).collect(Collectors.toList());
	}

	

}
