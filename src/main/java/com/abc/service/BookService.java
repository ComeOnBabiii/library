package com.abc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.Book;
import com.abc.repository.BookRepository;

@Service
public class BookService {

	@Autowired 
	BookRepository bookRepository;
	
	public List<Book> getList(){
		List<Book> listBooks = new ArrayList<Book>();
		bookRepository.findAll().forEach(listBooks::add);
		return listBooks;	
	}
	
	public void save(Book book) {
		Book newBook = new Book();		
		newBook.setTitle(book.getTitle());
		newBook.setAuthor(book.getAuthor());
		newBook.setCategory(book.getCategory());
		newBook.setPublisher(book.getPublisher());
		newBook.setQuantity(book.getQuantity());
		newBook.setImages(book.getImages());	
		newBook.setDes(book.getDes());
		try {
			bookRepository.save(newBook);
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	public void edit(Book book) {
		bookRepository.save(book);
	}
	
	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}
	
	public Optional<Book> findById(long id) {
		return bookRepository.findById(id);
	}
	
	public Book getById(long id) {
		return bookRepository.getById(id);
		
	}
	
	public Book getId(long id) {
		return bookRepository.getId(id);
		
	}
	
	public List<Book> search(String category){
		return bookRepository.findByCategory(category);
	}
	
	public List<Book> searchName(String title){
		return bookRepository.findByTitleContaining(title);
	}
	
	public long countCategory(String category) {
		return bookRepository.countByCategory(category);
	}
	
	public Long sumQuantities() {
		return bookRepository.sumQuantities();
	}
	
}
