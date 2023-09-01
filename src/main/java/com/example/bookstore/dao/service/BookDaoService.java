package com.example.bookstore.dao.service;

import java.util.List;
import java.util.Optional;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.entitty.BookStock;

public interface BookDaoService {

	public List<Book> getBooks();

	public Optional<Book> getBook(int bookId);

	public Book addBook(Book book);

	public Book deleteBook(int bookId);

	public BookStock updateBookStock(BookStock bookStockEntity);

	public Book purchaseBook(int bookId, int bookStock);

}
