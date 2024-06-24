package com.bankmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.Branch;
@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {

	List<Branch> findAllByBankBankId(String bankId);
	List<Branch> findAllByBankBankIdNot(String bankId);
}
