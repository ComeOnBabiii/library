package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
