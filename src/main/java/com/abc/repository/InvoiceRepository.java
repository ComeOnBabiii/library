package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Invoice;
import com.abc.model.User;


public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	
	List<Invoice> findByTrangThaiContaining(String trangThai);
	
}