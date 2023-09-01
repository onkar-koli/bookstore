package com.example.bookstore.dao.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.entitty.BookStock;
import com.example.bookstore.dao.entitty.Sales;
import com.example.bookstore.dao.repository.BookRepository;
import com.example.bookstore.dao.repository.BookStockRepository;
import com.example.bookstore.dao.repository.SalesRepository;
import com.example.bookstore.dao.service.BookDaoService;

@Service("bookDaoService")
public class BookDaoServiceImpl implements BookDaoService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookStockRepository bookStockRepository;

	@Autowired
	private SalesRepository salesRepository;

	@Override
	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBook(int bookId) {
		return bookRepository.findById(bookId);
	}

	@Override
	public Book addBook(Book book) {
		book.setAddingDate(new Date());
		bookRepository.save(book);
		return book;
	}

	@Override
	public Book deleteBook(int bookId) {
		Book bookEntity = bookRepository.findById(bookId).get();
		bookEntity.setBookStatus(false);
		bookRepository.save(bookEntity);
		return bookEntity;
	}

	@Override
	public BookStock updateBookStock(BookStock bookStockEntity) {
		Book bookEntity = bookRepository.findById(bookStockEntity.getBookId()).get();
		bookEntity.setBookStock(bookEntity.getBookStock()+bookStockEntity.getAdditionalBookStock());
		bookStockEntity.setUpdatingStockDate(new Date());
		bookStockRepository.save(bookStockEntity);
		bookRepository.save(bookEntity);
		return bookStockEntity;
	}

	@Override
	public Book purchaseBook(int bookId, int bookStock) {
		Book bookEntity = bookRepository.findById(bookId).get();
		bookEntity.setBookStock(bookEntity.getBookStock() - bookStock);
		bookEntity.setSold(bookEntity.getSold() + bookStock);
		bookRepository.save(bookEntity);
		Sales salesEntity = new Sales();
		salesEntity.setBookId(bookEntity.getBookId());
		salesEntity.setCount(bookStock);
		salesEntity.setPrice(bookStock * bookEntity.getBookPrice());
		salesEntity.setTransactionDate(new Date());
		salesRepository.save(salesEntity);
		return bookEntity;
	}
}
