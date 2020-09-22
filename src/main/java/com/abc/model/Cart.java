package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "soluong")
	private int soLuong;
	
	@OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    
	@OneToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;
	
	@Column(name = "options")
	private Boolean options;
	
	public Cart() {
		super();
	}	

	public Cart(long id, int soLuong, Book bookId, Invoice invoice, Boolean options) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.book = bookId;
		this.invoice = invoice;
		this.options = options;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Boolean isOptions() {
		return options;
	}

	public void setOptions(Boolean options) {
		this.options = options;
	}
	
}
