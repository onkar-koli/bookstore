package com.example.bookstore.dao.validation;

import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public interface OnlineBookValidation {
	
	public void bookAddingValidation(BookModel bookModel);

	public void bookUpdatingValidation(BookStockModel bookStockModel);

	public void bookPurchasingValidation(String bookId, String bookStock);

	public void bookDeletingValidation(String bookId);

	public void getBookValidation(String bookId);
	
}