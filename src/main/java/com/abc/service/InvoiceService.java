package com.abc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.abc.model.Invoice;
import com.abc.model.User;
import com.abc.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	public Invoice create(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public Invoice getById(long id) {
		return invoiceRepository.findById(id).get();
	}
	
	public List<Invoice> getListInvoice(){
		List<Invoice> listInvoices = new ArrayList<Invoice>();
		invoiceRepository.findAll().forEach(listInvoices::add);
		return listInvoices;	
	}
	
	public Optional<Invoice> findByInvoiceId(long id){
		return invoiceRepository.findById(id);
	}
	
	public void edit(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	public void deleteById(long id) {
		invoiceRepository.deleteById(id);
	}
	
	public List<Invoice> searchTrangThai(String trangThai){
		return invoiceRepository.findByTrangThaiContaining(trangThai);
	}
	
}
