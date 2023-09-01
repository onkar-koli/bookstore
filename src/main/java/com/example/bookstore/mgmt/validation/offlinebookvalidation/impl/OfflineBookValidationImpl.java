package com.example.bookstore.mgmt.validation.offlinebookvalidation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.mgmt.regularexpressions.RegularExpressions;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.OfflineBookValidation;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.OfflineValidator;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

@Service("offlineBookValidation")
public class OfflineBookValidationImpl implements OfflineBookValidation{

	@Autowired
	private OfflineValidator offlineValidator;
	
	@Override
	public void bookAddingValidation(BookModel bookModel) {
		
		offlineValidator.checkBookName(bookModel.getBookName(), RegularExpressions.azAz);
		offlineValidator.checkBookPrice(bookModel.getBookPrice(), RegularExpressions.number);
		offlineValidator.checkBookStock(bookModel.getBookStock(), RegularExpressions.number);
	
	}

	@Override
	public void bookPurchasingValidation(String bookId, String bookStock) {
	
		offlineValidator.checkBookId(bookId, RegularExpressions.number);
		offlineValidator.checkBookStock(bookStock, RegularExpressions.number);
	
	}

	@Override
	public void getBookValidation(String bookId) {
	
		offlineValidator.checkBookId(bookId, RegularExpressions.number);
	
	}

	@Override
	public void bookUpdatingValidation(BookStockModel bookStockModel) {
	
		offlineValidator.checkBookId(bookStockModel.getBookId(), RegularExpressions.number);
		offlineValidator.checkBookStock(bookStockModel.getBookStock(), RegularExpressions.number);
	
	}

	@Override
	public void bookDeletingValidation(String bookId) {
	
		offlineValidator.checkBookId(bookId, RegularExpressions.number);
	
	}
	
}
