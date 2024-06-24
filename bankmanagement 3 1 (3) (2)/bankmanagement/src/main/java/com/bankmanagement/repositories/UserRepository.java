package com.bankmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByPhoneNo(String phoneNo);
	User findByEmail(String email);
	List<User> findAllByStatus(String status);
}
