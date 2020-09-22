package com.abc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.abc.model.Book;
import com.abc.repository.BookRepository;
import com.abc.service.BookService;

@Controller
@RequestMapping("/admin/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/list")
	public String ListBooks(Model model) {
		List<Book> listBooks = bookService.getList();
		model.addAttribute("books", listBooks);
		return "admin/book/list-books";
	}
	
	@GetMapping("/add")
	public String AddBook(@ModelAttribute("bookRequest")Book bookRequest, Model model) {
		model.addAttribute("bookRequest",bookRequest);
		return "admin/book/add-book";
	}

	@PostMapping("/add")
	public String save(HttpServletRequest request, @ModelAttribute Book bookRequest,
			@RequestParam("file") MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		bookRequest.setImages(fileName);
		try {
			File newFile = new File("C:\\Users\\White_Tiger\\Desktop\\demo1\\demo\\library\\src\\main\\resources\\static\\images"
					+ file.getOriginalFilename());
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bookService.save(bookRequest);
		} catch (Exception e) {
		}
		return "redirect:/admin/book/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		try {
			bookService.deleteById(id);
		} catch (Exception e) {
		}
		
		return "redirect:/admin/book/list";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id,@ModelAttribute Book bookRequest) {
		Optional<Book> bookData = bookService.findById(id);
		if (bookData.isPresent()) {
			Book book = bookData.get();
			book.setAuthor(bookRequest.getAuthor());
			book.setTitle(bookRequest.getTitle());
			book.setPublisher(bookRequest.getPublisher());
			book.setQuantity(bookRequest.getQuantity());
			book.setDes(bookRequest.getDes());
			book.setCategory(bookRequest.getCategory());
			bookService.edit(book);
		}
		return "redirect:/admin/book/list";
	}
	
	 @GetMapping("/edit/{id}")
	  public String getTutorialById(@PathVariable("id") long id, Model model) {
	    Optional<Book> bookData = bookService.findById(id);

	    if (bookData.isPresent()) {
	    	model.addAttribute("book", bookData.get());
	    }
	    return "admin/book/edit-book";
	  }	
	 
	 @GetMapping("/search")
	 public String searchName(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
		String timkiem = request.getParameter("key");
		List<Book> listBooks = bookService.searchName(timkiem);
		if(listBooks.size()==0) {
			session.setAttribute("message", "Không có sách bạn cần tìm!");
			return "admin/book/list-books";
		}
		session.setAttribute("message", "");
		model.addAttribute("books", listBooks);
		return "admin/book/list-books";
	 }
}
