package com.abc.controller;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.model.Book;
import com.abc.model.Cart;
import com.abc.model.Invoice;
import com.abc.model.User;
import com.abc.repository.UserRepository;
import com.abc.service.BookService;
import com.abc.service.CartService;
import com.abc.service.InvoiceService;
import com.abc.service.UserService;

@Controller
@RequestMapping("/client/invoice")
public class InvoiceController {

	@Autowired
	BookService bookService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	InvoiceService invoiceService;
	long time = System.currentTimeMillis();
	@GetMapping("/message")
	public String createInvoice( HttpSession session) {
		Object obj = session.getAttribute("cart");
		Invoice invoiceFromDb = null;
		Cart cartDB = null;
		if (obj != null) {
			@SuppressWarnings("unchecked")
			Map<String, Cart> map = (Map<String, Cart>) obj;

			Invoice invoice = new Invoice();
			
			invoice.setNgayMuon(new Date(time));
			
			invoice.setStatus(0);
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String username = ((UserDetails) principal).getUsername();
				User buyUser = userRepository.findByUsername(username);
				invoice.setUser(buyUser);
			} else {
				String username = principal.toString();
			}
			
			
			invoiceFromDb = invoiceService.create(invoice);
			
			for (Entry<String, Cart> entry : map.entrySet()) {
				Cart cart = entry.getValue();
				cart.setInvoice(invoiceFromDb);
				if(cart.getSoLuong() <= cart.getBook().getQuantity() ) {
						Book book = bookService.getById(cart.getBook().getId());			
						book.setQuantity(cart.getBook().getQuantity()-cart.getSoLuong());
						
						bookService.edit(book);
					
						
				}else {
					session.setAttribute("error", "Số lượng sách "+cart.getBook().getTitle()+" chỉ còn "+cart.getBook().getQuantity()+" quyển sách!");
					return "client/cart";
				}
				
				cartService.create(cart);
				
			}
			
			session.removeAttribute("cart");
		}else {
			session.setAttribute("error", "Bạn cần thêm sách vào giỏ hàng!");
			return "client/cart";
		}
		
		Invoice invoiveById = invoiceService.getById(invoiceFromDb.getId());
		session.setAttribute("invoice", invoiveById);
		
		
		List<Cart> listCart = cartService.getList(invoiceFromDb.getId());
		session.setAttribute("carts", listCart);
		
		return "client/bill";
	}
	
}
