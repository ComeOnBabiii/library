package com.abc.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.Book;
import com.abc.model.Cart;
import com.abc.repository.BookRepository;
import com.abc.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public Cart create(Cart c) {
		return cartRepository.save(c);
	}	

	public void edit(Cart c) {
		cartRepository.save(c);
	}
	
	public Cart getByIdCart(long id) {
		return cartRepository.findById(id).get();
	}
	
	public Cart findById(long id) {
		return cartRepository.findById(id).get();
	}
	
	public List<Cart> getList(long id){
		return cartRepository.findByInvoiceId(id);	
	}
	
	public Long sumSoluong() {
		return cartRepository.tongSoluong();
	}
	
	public Long totalSoluong(Boolean options) {
		return cartRepository.totalSoluong(options);
	}
}
