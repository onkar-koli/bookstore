package com.example.bookstore.mgmt.validation.offlinebookvalidation;

public interface OfflineValidator {
	
	public void checkBookId(String bookId, String number);

	public void checkBookName(String bookName, String azAz);

	public void checkBookPrice(String bookPrice, String number);

	public void checkBookStock(String bookStock, String number);
	
}
