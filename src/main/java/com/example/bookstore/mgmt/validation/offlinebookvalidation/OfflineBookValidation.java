package com.example.bookstore.mgmt.validation.offlinebookvalidation;

import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public interface OfflineBookValidation {
	
	public void bookAddingValidation(BookModel bookModel);

	public void bookUpdatingValidation(BookStockModel bookStockModel);

	public void bookPurchasingValidation(String bookId, String bookStock);

	public void getBookValidation(String bookId);

	public void bookDeletingValidation(String bookid);
	
}
