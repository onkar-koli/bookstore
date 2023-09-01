package com.example.bookstore.dao.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dao.validation.OnlineBookValidation;
import com.example.bookstore.dao.validation.OnlineValidator;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

@Service("onlineBookValidation")
public class OnlineBookValidationImpl implements OnlineBookValidation{

	@Autowired
	private OnlineValidator onlineValidator;
	
	@Override
	public void bookAddingValidation(BookModel bookModel) {
		
		onlineValidator.checkBookName(bookModel.getBookName());
	
	}

	@Override
	public void bookPurchasingValidation(String bookId, String bookStock) {
	
		onlineValidator.checkBookStatus(bookId);
		onlineValidator.checkBookId(bookId);
		onlineValidator.checkBookStock(bookId, bookStock);
	
	}

	@Override
	public void getBookValidation(String bookId) {
		
		onlineValidator.checkBookId(bookId);
	
	}

	@Override
	public void bookUpdatingValidation(BookStockModel bookStockModel) {
		
		onlineValidator.checkBookStatus(bookStockModel.getBookId());
		onlineValidator.checkBookId(bookStockModel.getBookId());		
	
	}

	@Override
	public void bookDeletingValidation(String bookId) {
		
		onlineValidator.checkBookId(bookId);
	
	}
}
