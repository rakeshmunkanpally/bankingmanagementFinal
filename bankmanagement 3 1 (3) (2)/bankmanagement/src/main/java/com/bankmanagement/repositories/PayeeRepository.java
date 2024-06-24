package com.bankmanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.Payee;
import com.bankmanagement.entities.PayeeCompositeClass;
@Repository
public interface PayeeRepository extends JpaRepository<Payee, PayeeCompositeClass> {

	List<Payee> findAllByPayeeCompositeClassSenderAccountNo(Account senderAccount);
	Optional<Payee> findByPayeeCompositeClass(PayeeCompositeClass payeeCompositeClass);
}
