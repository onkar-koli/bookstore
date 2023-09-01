package com.example.bookstore.mgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.entitty.BookStock;
import com.example.bookstore.dao.service.BookDaoService;
import com.example.bookstore.mgmt.exception.ValidationException;
import com.example.bookstore.mgmt.service.BookMgmtService;
import com.example.bookstore.mgmt.utility.EntityToModelUtility;
import com.example.bookstore.mgmt.utility.ModelToEntityUtility;
import com.example.bookstore.mgmt.validation.ValidationServices;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

@Service("bookMgmtService")
public class BookMgmtServiceImpl implements BookMgmtService {

	@Autowired
	private ValidationServices validationServices;

	@Autowired
	private BookDaoService bookDaoService;

	@Autowired
	private ModelToEntityUtility modelToEntityUtility;

	@Autowired
	private EntityToModelUtility entityToModelUtility;

	@Override
	public ResponseEntity<?> getBooks() {

		List<Book> books = bookDaoService.getBooks();
		List<BookModel> bookModels = new ArrayList<BookModel>();
		BookModel bookModel = new BookModel();
		for (int i = 0; i < books.size(); i++) {
			bookModel = entityToModelUtility.bookUtility(books.get(i));
			bookModels.add(bookModel);
		}
		return new ResponseEntity<>(bookModels, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> getBook(String bookId) {

		try {
			validationServices.getBookValidation(bookId);

			Book bookEntity = bookDaoService.getBook(Integer.parseInt(bookId)).get();
			BookModel bookModel = entityToModelUtility.bookUtility(bookEntity);

			return new ResponseEntity<>(bookModel, HttpStatus.OK);
		} catch (ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> addBook(BookModel bookModel) {

		try {
			validationServices.bookAddingValidation(bookModel);

			Book bookEntity = modelToEntityUtility.bookUtility(bookModel);
			BookModel boookModel = entityToModelUtility.bookUtility(bookDaoService.addBook(bookEntity));

			return new ResponseEntity<>(boookModel, HttpStatus.OK);

		} catch (ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> deleteBook(String bookId) {

		try {
			validationServices.bookDeletingValidation(bookId);
			Book bookEntity = bookDaoService.deleteBook(Integer.parseInt(bookId));
			BookModel bookModel = entityToModelUtility.bookUtility(bookEntity);
			return new ResponseEntity<>(bookModel, HttpStatus.OK);
		} catch (ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> purchaseBook(String bookId, String bookStock) {

		try {
			validationServices.bookPurchasingValidation(bookId, bookStock);
			Book bookEntity = bookDaoService.purchaseBook(Integer.parseInt(bookId), Integer.parseInt(bookStock));
			BookModel bookModel = entityToModelUtility.bookUtility(bookEntity);
			return new ResponseEntity<>(bookModel, HttpStatus.OK);
		} catch (ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<?> updateBookStock(BookStockModel bookStockModel) {

		try {
			validationServices.bookUpdatingValidation(bookStockModel);
			BookStock bookStockEntity = modelToEntityUtility.bookStockUtility(bookStockModel);
			return new ResponseEntity<>(bookDaoService.updateBookStock(bookStockEntity), HttpStatus.OK);
		} catch (ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
