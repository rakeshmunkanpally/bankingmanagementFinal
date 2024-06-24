package com.bankmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByUserUserId(Integer userId);
	
}
