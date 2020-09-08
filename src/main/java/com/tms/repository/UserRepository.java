package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
