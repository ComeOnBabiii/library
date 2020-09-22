package com.abc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.model.Book;
import com.abc.model.Cart;
import com.abc.service.BookService;

@Controller
@RequestMapping("/client/cart")
public class CartController {

	@Autowired
	BookService bookService;
	
	@GetMapping("")
	public String cart() {
		return "client/cart";
	}
	
	@GetMapping("/{id}")
	  public String getByCartId(@PathVariable("id") String id, HttpSession session) {
	    Book book = bookService.getById(Long.parseLong(id));
	    
		Object obj = session.getAttribute("cart");
		
		if (obj == null) {
			Cart cart = new Cart();
			cart.setBook(book);
			cart.setSoLuong(1);
			cart.setOptions(false);
		
			Map<String, Cart> map = new HashMap<>();
			map.put(String.valueOf(id), cart);

			session.setAttribute("cart", map);
			session.setAttribute("error", "");
		} else {
			Map<String, Cart> map = (Map<String, Cart>) obj;
			Cart cart = map.get(String.valueOf(id));
			session.setAttribute("error", "");
			if (cart == null) {
				cart = new Cart();
				cart.setBook(book);
				cart.setSoLuong(1);
				cart.setOptions(false);

				map.put(String.valueOf(id), cart);
				
			} 
			else{
				
				cart.setSoLuong(cart.getSoLuong() + 1); 	
				
			}
			
			session.setAttribute("cart", map);
		}
		
	    return "redirect:/client/cart";
	  }	
	
	@GetMapping("/{id}/{option}")
	  public String getByCartAmountId(@PathVariable("id") String id,@PathVariable("option") String option, HttpSession session) {
	    Book book = bookService.getById(Long.parseLong(id));
    
		Object obj = session.getAttribute("cart");
		session.setAttribute("error", "");
		if (obj == null) {
			Cart cart = new Cart();
			cart.setBook(book);
			cart.setSoLuong(1);
			cart.setOptions(false);
		
			Map<String, Cart> map = new HashMap<>();
			map.put(String.valueOf(id), cart);

			session.setAttribute("cart", map);
		} else {
			Map<String, Cart> map = (Map<String, Cart>) obj;
			Cart cart = map.get(String.valueOf(id));
			session.setAttribute("error", "");
			if (cart == null) {
				cart = new Cart();
				cart.setBook(book);
				cart.setSoLuong(1);
				cart.setOptions(false);

				map.put(String.valueOf(id), cart);
				
			} 
			else{
				
				if (option.equals("plus")) {
					if(cart.getSoLuong()<100) {
						cart.setSoLuong(cart.getSoLuong() + 1); 
					}else {
						cart.setSoLuong(100);
					}
				} 
				else if (option.equals("minus")) {
					if(cart.getSoLuong()>1) {
						cart.setSoLuong(cart.getSoLuong() - 1); 
					}else {
						cart.setSoLuong(1); 
					}
				} 	
			}
			
			session.setAttribute("cart", map);
			
		}
		
	    return "redirect:/client/cart";
	  }	
	@GetMapping("/delete/{key}")
	public String getDeleteCartId(@PathVariable("key") String key, HttpSession session) {
		Object obj = session.getAttribute("cart");
		session.setAttribute("error", "");
		if (obj != null) {
			Map<String, Cart> map = (Map<String, Cart>) obj;
			map.remove(key);
			session.setAttribute("cart", map);
			session.removeAttribute("cart");
		}
		
		return "redirect:/client/cart";
	}
}
