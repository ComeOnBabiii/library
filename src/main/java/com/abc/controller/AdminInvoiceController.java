package com.abc.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.model.Book;
import com.abc.model.Cart;
import com.abc.model.Invoice;
import com.abc.model.User;
import com.abc.repository.InvoiceRepository;
import com.abc.service.BookService;
import com.abc.service.CartService;
import com.abc.service.InvoiceService;
import com.abc.service.UserService;

@Controller
@RequestMapping("/admin/invoice")
public class AdminInvoiceController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	InvoiceRepository invoiceRepository;

	@GetMapping("/list")
	public String ListInvoices(Model model, HttpSession session) {
		List<Invoice> listInvoices = invoiceService.getListInvoice();
		
		model.addAttribute("invoices", listInvoices);
		return "admin/invoice/list-invoice";
	}
	
	@GetMapping("/edit/{id}")
	public String invoiceMuon(@PathVariable("id") long id,Model model,HttpSession session) {
		Optional<Invoice> invoices = invoiceService.findByInvoiceId(id);
		if (invoices.isPresent()) {
			model.addAttribute("invoice", invoices.get());
			
		}
		session.setAttribute("error", "");
		session.setAttribute("mess", "");
		return "admin/invoice/edit-invoice";
	}
	
	@PostMapping("/{option}/{id}")
	public String edit(@PathVariable("id") long id,@PathVariable("option") String option,
			@ModelAttribute Invoice invoiceRequest,HttpSession session) {
		session.setAttribute("mess", "");
		if(option.equals("0")) {
			Optional<Invoice> invoiceData = invoiceService.findByInvoiceId(id);
			if (invoiceData.isPresent()) {
				Invoice invoice = invoiceData.get();
				
				if(invoice.getNgayMuon().compareTo(invoiceRequest.getNgayHen()) > 0) {
					session.setAttribute("error", "Ngày hẹn không hợp lệ!"); 
					return "admin/invoice/edit-invoice";
				}else {
					invoice.setNgayHen(invoiceRequest.getNgayHen());
					invoice.setTrangThai("Đã mượn");
					invoice.setStatus(0);
					invoiceService.edit(invoice);
				}
					
			}			
		}
		
		return "redirect:/admin/invoice/list";
		
	}
	
	
	@GetMapping("/pay/{id}")
	public String accept(@PathVariable("id") long id, @ModelAttribute Invoice invoiceRequest,HttpSession session) {
		long time = System.currentTimeMillis();
		
		Optional<Invoice> invoiceData = invoiceService.findByInvoiceId(id);
		if (invoiceData.isPresent()) {
			Invoice invoice = invoiceData.get();
			if(invoice.getNgayHen() == null) {
				session.setAttribute("mess", "Sách chưa được cho mượn!");
				return "redirect:/admin/invoice/list";
			}
			invoice.setNgayTra(new Date(time));
			invoice.setTrangThai("Đã trả");
			invoice.setStatus(1);
			invoiceService.edit(invoice);
			if(invoice.getNgayTra().compareTo(invoice.getNgayHen()) > 0) {
				session.setAttribute("mess", "Bạn đã trả sách muộn! Tiền nộp phạt chậm là 20.000đ");
			}else {
				session.setAttribute("mess", "Trả sách thành công!");
			}
		}
		Invoice invoice = invoiceService.getById(id);
		List<Cart> detailInvoice = cartService.getList(invoice.getId()) ;
		for(Cart cart: detailInvoice) {
			Book book = bookService.getById(cart.getBook().getId());			
			book.setQuantity(cart.getBook().getQuantity() + cart.getSoLuong());
			
			bookService.edit(book);
			
			cart.setOptions(true);
			cartService.edit(cart);
			
		}	
		return "redirect:/admin/invoice/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleInvoice(@PathVariable("id") long id,Model model, HttpSession session) {
		try {
			invoiceService.deleteById(id);
		} catch (Exception e) {
		}
		session.setAttribute("mess", "");
		return "redirect:/admin/invoice/list";
	}
	
	@GetMapping("/search")
	 public String searchName(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
		String timkiem = request.getParameter("timkiem");		
		List<Invoice> listInvoices = invoiceService.searchTrangThai(timkiem);
		if(listInvoices.size()==0) {
			session.setAttribute("messa", "Không có trạng thái bạn cần tìm!");
			return "admin/invoice/list-invoice";
		}
		session.setAttribute("messa", "");
		model.addAttribute("invoices", listInvoices);
		
		return "admin/invoice/list-invoice";
	 }
	
	@GetMapping("/detail/{id}")
	 public String detailInvoice(@PathVariable("id") long id, Model model, HttpSession session) {
		session.setAttribute("mess", "");
		Invoice invoice = invoiceService.getById(id);
		List<Cart> detailInvoice = cartService.getList(invoice.getId()) ;
		model.addAttribute("carts", detailInvoice);
		model.addAttribute("invoice", invoice);
		return "admin/invoice/detail-invoice";
	 }
	
	
}
