package com.abc.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.model.Book;
import com.abc.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	
	List<User> findByNameContaining(String name);	
	
	long countByFeatured(Boolean featured);
	
}
