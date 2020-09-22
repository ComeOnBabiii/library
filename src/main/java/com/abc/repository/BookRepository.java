package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("SELECT b FROM Book b WHERE b.id = :id")
	Book getById(@Param("id") long id);
	
	@Query("update Book set author = :author, title = :title, publisher = :publisher , category = :category, quantity = :quantity, images = :images, des = :des WHERE id = :id1")
	Book getId(@Param("id1") long id1);
	
	List<Book> findByCategory(String category);
	
	List<Book> findByTitleContaining(String title);

	long countByCategory(String category);
	
	@Query(value = "SELECT sum(quantity) FROM Book")
    long sumQuantities();
}
