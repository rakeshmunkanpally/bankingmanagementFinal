package com.bankmanagement.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.Admin;
import com.bankmanagement.entities.Branch;
import com.bankmanagement.entities.Transaction;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.Login;
import com.bankmanagement.payloads.UserDto;
import com.bankmanagement.repositories.AdminRepository;
import com.bankmanagement.services.AccountServices;
import com.bankmanagement.services.AdminServices;
import com.bankmanagement.services.BranchServices;
import com.bankmanagement.services.TransactionServices;
import com.bankmanagement.services.UserServices;

@Service
public class AdminServicesImpl implements AdminServices {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	UserServices userServices;
	@Autowired
	AccountServices accountServices;
	@Autowired
	BranchServices branchServices;
	@Autowired
	TransactionServices transactionServices;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public ApiResponse checkCredentials(Login login) {
		Admin admin= adminRepository.findById(login.getId()).orElseThrow(()->new MyException("Admin Id not Exists"));
		if(passwordEncoder.matches(login.getPassword(), admin.getPassword()))
			return new ApiResponse("Logged succuessfully",true);
		return new ApiResponse("Invalid Password",false);
	}

	@Override
	public Admin createAdmin(Admin admin) {
		if(adminRepository.findById(admin.getAdminId()).isEmpty()){
			
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			admin=adminRepository.save(admin);
		}
		else
			throw new MyException("Admin Id already Exist");
		return admin;
	}

	@Override
	public ApiResponse changeUserStatus(String status, Integer userId) {
		UserDto userDto=userServices.getById(userId);
		if(status.equals("A")) {
			userDto.setStatus("A");
			Branch branch=branchServices.getById(userDto.getBranchId());
			userServices.updateUser(status,userId);
			Account account=accountServices.createAccount(userDto, branch);
			Transaction transaction=new Transaction();
			transaction.setAmount(500.0);
			transaction.setBalance(500.0);
			transaction.setDescription("CREDIT");
			transaction.setRemarks("Joining Bonus");
			transaction.setAccount(account);
			transaction.setTrasactionDate(LocalDateTime.now());
			transaction=transactionServices.createTransaction(transaction);
			
			return new ApiResponse("Account is Created with Id : "+account.getAccountNo(), true);
		}
	
		
		userDto = userServices.updateUser(status,userId);
		return new ApiResponse("User with Id :"+userId+" is "+status, true);
	}

}
