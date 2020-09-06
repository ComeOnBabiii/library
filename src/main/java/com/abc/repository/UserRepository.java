package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
