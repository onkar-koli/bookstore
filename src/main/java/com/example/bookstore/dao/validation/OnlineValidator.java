package com.example.bookstore.dao.validation;

public interface OnlineValidator {
	
	public void checkBookName(String bookName);

	public void checkBookId(String bookId);

	public void checkBookStock(String bookId, String bookStock);

	public void checkBookStatus(String bookId);
	
}
