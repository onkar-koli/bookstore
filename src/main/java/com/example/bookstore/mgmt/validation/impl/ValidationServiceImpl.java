package com.example.bookstore.mgmt.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dao.validation.OnlineBookValidation;
import com.example.bookstore.mgmt.validation.ValidationServices;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.OfflineBookValidation;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

@Service("validationServices")
public class ValidationServiceImpl implements ValidationServices {

	@Autowired
	private OfflineBookValidation offlineBookValidation;
	
	@Autowired
	private OnlineBookValidation onlineBookValidation;
	
	@Override
	public void bookAddingValidation(BookModel bookModel) {
		
		offlineBookValidation.bookAddingValidation(bookModel);
		onlineBookValidation.bookAddingValidation(bookModel);
	
	}

	@Override
	public void bookUpdatingValidation(BookStockModel bookStockModel) {
	
		offlineBookValidation.bookUpdatingValidation(bookStockModel);
		onlineBookValidation.bookUpdatingValidation(bookStockModel);
	
	}

	@Override
	public void bookPurchasingValidation(String bookId, String bookStock) {
	
		offlineBookValidation.bookPurchasingValidation(bookId, bookStock);
		onlineBookValidation.bookPurchasingValidation(bookId, bookStock);
	
	}

	@Override
	public void getBookValidation(String bookId) {
		
		offlineBookValidation.getBookValidation(bookId);
		onlineBookValidation.getBookValidation(bookId);
	
	}

	@Override
	public void bookDeletingValidation(String bookId) {
	
		offlineBookValidation.bookDeletingValidation(bookId);
		onlineBookValidation.bookDeletingValidation(bookId);
	
	}
	
}
