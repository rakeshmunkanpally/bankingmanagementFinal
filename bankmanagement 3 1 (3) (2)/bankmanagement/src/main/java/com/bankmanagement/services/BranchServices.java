package com.bankmanagement.services;

import java.util.List;

import com.bankmanagement.entities.Branch;

public interface BranchServices {

	Branch getById(String branchId);

	List<Branch> getAllBranches();
	List<Branch> getAllBrachesByBankId(String bankId);
	List<Branch> getAllBrachesByBankIdNot(String bankId);
	Branch insertBranch(Branch branch);
}
