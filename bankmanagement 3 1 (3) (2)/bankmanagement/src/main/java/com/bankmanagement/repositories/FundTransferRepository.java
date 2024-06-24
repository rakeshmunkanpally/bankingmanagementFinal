package com.bankmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.FundTransfer;
import com.bankmanagement.entities.Payee;
@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Integer> {

	FundTransfer findByPayee(Payee payee);
}
