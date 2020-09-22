package com.abc.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	@Column(name = "ngaymuon")
	private Date ngayMuon;

	@Column(name = "ngayhen")
	private Date ngayHen;

	@Column(name = "ngaytra")
	private Date ngayTra;

	@Column(name = "trangthai")
	private String trangThai;
	
	@Column(name = "status")
	private long status;
	
	public Invoice() {
		super();
	}
	
	public Invoice(long id, User user, Date ngayMuon, Date ngayHen, Date ngayTra, String trangThai, long status) {
		super();
		this.id = id;
		this.user = user;
		this.ngayMuon = ngayMuon;
		this.ngayHen = ngayHen;
		this.ngayTra = ngayTra;
		this.trangThai = trangThai;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayHen() {
		return ngayHen;
	}

	public void setNgayHen(Date ngayHen) {
		this.ngayHen = ngayHen;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

}
