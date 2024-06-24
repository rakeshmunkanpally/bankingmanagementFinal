package com.bankmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Branch;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.repositories.BranchRepository;
import com.bankmanagement.services.BranchServices;

@Service
public class BranchServicesImpl implements BranchServices {

	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public Branch getById(String branchId) {
		return branchRepository.findById(branchId).orElseThrow(()->new MyException("Branch Not Found"));
	}

	@Override
	public List<Branch> getAllBranches() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}

	@Override
	public List<Branch> getAllBrachesByBankId(String bankId) {
		// TODO Auto-generated method stub
		return branchRepository.findAllByBankBankId(bankId);
	}

	@Override
	public List<Branch> getAllBrachesByBankIdNot(String bankId) {
		// TODO Auto-generated method stub
		return branchRepository.findAllByBankBankIdNot("B101");
	}

	@Override
	public Branch insertBranch(Branch branch) {
		// TODO Auto-generated method stub
		if(branchRepository.findById(branch.getBranchId()).isPresent())
			throw new MyException("Branch With this Id Already Present");
		
		return branchRepository.save(branch);
	}

}
