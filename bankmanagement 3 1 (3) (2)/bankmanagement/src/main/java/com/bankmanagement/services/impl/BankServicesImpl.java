package com.bankmanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Bank;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.repositories.BankRepository;
import com.bankmanagement.services.BankServices;

@Service
public class BankServicesImpl implements BankServices {

	@Autowired
	BankRepository bankRepository;
	@Override
	public Bank insertBank(Bank bank) {
		// TODO Auto-generated method stub
		if(bankRepository.findById(bank.getBankId()).isPresent())
			throw new MyException("Bank ALready Present With This Id");
		return bankRepository.save(bank);
	}

}
