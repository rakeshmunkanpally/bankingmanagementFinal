package com.bankmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank, String> {

}
