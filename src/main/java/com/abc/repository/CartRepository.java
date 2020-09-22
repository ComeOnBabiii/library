package com.abc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.model.Book;
import com.abc.model.Cart;
import com.abc.model.Invoice;

public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findByInvoice(Invoice invoice);
	
	List<Cart> findByInvoiceId(long invoice_id);
	
	@Query("SELECT sum(soLuong) FROM Cart")
    long tongSoluong();

	@Query("SELECT sum(soLuong) FROM Cart c WHERE c.options =:options")
    long totalSoluong(Boolean options);
}
