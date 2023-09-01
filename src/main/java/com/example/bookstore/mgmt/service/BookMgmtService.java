package com.example.bookstore.mgmt.service;

import org.springframework.http.ResponseEntity;

import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public interface BookMgmtService {

	public ResponseEntity<?> getBooks();

	public ResponseEntity<?> getBook(String bookId);

	public ResponseEntity<?> addBook(BookModel bookModel);

	public ResponseEntity<?> deleteBook(String bookId);

	public ResponseEntity<?> purchaseBook(String bookId, String bookStock);

	public ResponseEntity<?> updateBookStock(BookStockModel bookStockModel);

}
