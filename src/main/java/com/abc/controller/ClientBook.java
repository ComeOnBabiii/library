package com.abc.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.model.Book;
import com.abc.service.BookService;

@Controller
@RequestMapping("/client")
public class ClientBook {

	@Autowired
	BookService bookService;
	
	@GetMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model) {
	
		List<Book> listBooks = bookService.getList();
		model.addAttribute("books", listBooks);
			
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			
		} else {
			String username = principal.toString();
		}
		return "/client/list";
	}

	@GetMapping("/category/list")
	public String ListBook(Model model) {		
		return "client/list";
	}
	
	@GetMapping("/detail/id={id}")
	 public String getTutorialById(@PathVariable("id") long id, Model model) {
	    Optional<Book> bookData = bookService.findById(id);

	    if (bookData.isPresent()) {
	    	model.addAttribute("book", bookData.get());
	    }
	    return "client/detail";
	}
	
	@GetMapping("/vanhoc")
	 public String getCategoryTieuthuyet(Model model) {
		 List<Book> listBooks = bookService.search("văn học");
		 model.addAttribute("books", listBooks);
		 return "client/list";
	 }
	
	@GetMapping("/giaotrinh")
	 public String getCategoryGiaotrinh(Model model) {
		 List<Book> listBooks = bookService.search("giáo trình");
		 model.addAttribute("books", listBooks);
		 return "client/list";
	 }
	
	@GetMapping("/sachbao")
	 public String getCategoryName(Model model) {
		 List<Book> listBooks = bookService.search("sách báo");
		 model.addAttribute("books", listBooks);
		 return "client/list";
	 }
	
	@GetMapping("/search")
	 public String searchName(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
		String timkiem = request.getParameter("timkiem");
		List<Book> listBooks = bookService.searchName(timkiem);
		if(listBooks.size()==0) {
			session.setAttribute("messa", "Không có sách bạn cần tìm!");
			return "client/list";
		}
		session.setAttribute("messa", "");
		model.addAttribute("books", listBooks);
		return "client/list";
	 }
}
