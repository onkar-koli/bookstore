package com.example.bookstore.dao.entitty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKSTOCK")
public class BookStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BOOKSTOCKID")
	private int bookStockId;

	@Column(name = "BOOKID")
	private int bookId;
	
	@Column(name = "ADDIONALSTOCK")
	private int additionalBookStock;
	
	@Column(name="UPDATINGSTOCKDATE")
	private Date updatingStockDate;
	
	public int getBookStockId() {
		return bookStockId;
	}

	public void setBookStockId(int bookStockId) {
		this.bookStockId = bookStockId;
	}

	public Date getUpdatingStockDate() {
		return updatingStockDate;
	}

	public void setUpdatingStockDate(Date updatingStockDate) {
		this.updatingStockDate = updatingStockDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAdditionalBookStock() {
		return additionalBookStock;
	}

	public void setAdditionalBookStock(int additionalBookStock) {
		this.additionalBookStock = additionalBookStock;
	}

}
