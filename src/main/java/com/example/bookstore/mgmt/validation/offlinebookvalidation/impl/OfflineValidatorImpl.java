package com.example.bookstore.mgmt.validation.offlinebookvalidation.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.bookstore.mgmt.exception.ValidationException;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.OfflineValidator;

@Service("offlineValidator")
public class OfflineValidatorImpl implements OfflineValidator{

	@Override
	public void checkBookName(String bookName, String azAZ) {
		
		if(!Pattern.matches(azAZ,bookName)) {
			throw new ValidationException("Book Name is Not Correct");
		}
		
	}

	@Override
	public void checkBookPrice(String bookPrice, String number) {
		
		if(!Pattern.matches(number, bookPrice)) {
			throw new ValidationException("Book price is Not Correct");
		}
		
	}

	@Override
	public void checkBookStock(String bookStock, String number) {
		
		if(!Pattern.matches(number, bookStock)) {
			throw new ValidationException("Book Stock Number is Not Correct");
		}
		
	}

	@Override
	public void checkBookId(String bookId, String number) {
		
		if(!Pattern.matches(number, bookId)) {
			throw new ValidationException("Book ID is Not Correct");
		}
		
	}

}