package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.model.Book;
import com.abc.service.BookService;
import com.abc.service.CartService;
import com.abc.service.UserService;

@Controller
@RequestMapping("/admin")
public class DashboardController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("")
	public String index(Model model) {
		
		long nguoidung = userService.countFeatured(true);
		long vanhoc = bookService.countCategory("Văn học");
		long sachbao = bookService.countCategory("Sách báo");
		long giaotrinh = bookService.countCategory("Giáo trình");
		long sachmuon = cartService.sumSoluong();				
		long sachtra = cartService.totalSoluong(true);
			
		
		model.addAttribute("nguoidung", nguoidung);
		model.addAttribute("vanhoc", vanhoc);
		model.addAttribute("sachbao", sachbao);
		model.addAttribute("giaotrinh", giaotrinh);
		model.addAttribute("sachmuon", sachmuon);
		model.addAttribute("sachtra", sachtra);
		return "/admin/index";
	}
}
