package com.bankmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	Transaction findTopByAccountAccountNoOrderByTransactionDateDesc(Integer accountNo);
}
