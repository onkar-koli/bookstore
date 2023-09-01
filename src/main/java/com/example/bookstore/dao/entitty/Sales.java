package com.example.bookstore.dao.entitty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALES")
public class Sales {
	
	@Id
	@Column(name = "ITEMID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;

	@Column(name = "BOOKID")
	private int bookId;

	@Column(name = "COUNT")
	private int count;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "TRANSACTIONDATE")
	private Date transactionDate=null;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}
