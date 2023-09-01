package com.example.bookstore.mgmt.validation.offlinebookvalidation.test;

import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.bookstore.mgmt.validation.offlinebookvalidation.OfflineValidator;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.impl.OfflineBookValidationImpl;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public class OfflineBookValidationTest {

	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}

	@InjectMocks
	private OfflineBookValidationImpl offlineBookValidation;

	@Mock
	private OfflineValidator offlineValidator;

	@Test
	public void bookAddingValidation() {
		
		doNothing().when(offlineValidator).checkBookName(Mockito.anyString(), Mockito.anyString());
		doNothing().when(offlineValidator).checkBookPrice(Mockito.anyString(), Mockito.anyString());
		doNothing().when(offlineValidator).checkBookStock(Mockito.anyString(), Mockito.anyString());
		offlineBookValidation.bookAddingValidation(getBookModel());
	
	}

	@Test
	public void bookPurchasingValidation() {
	
		doNothing().when(offlineValidator).checkBookId(Mockito.anyString(), Mockito.anyString());
		doNothing().when(offlineValidator).checkBookStock(Mockito.anyString(), Mockito.anyString());
		offlineBookValidation.bookPurchasingValidation("1", "1");
	
	}

	@Test
	public void getBookValidation() {
	
		doNothing().when(offlineValidator).checkBookId(Mockito.anyString(), Mockito.anyString());
		offlineBookValidation.getBookValidation("1");
	
	}

	@Test
	public void bookUpdatingValidation() {
	
		doNothing().when(offlineValidator).checkBookId(Mockito.anyString(), Mockito.anyString());
		doNothing().when(offlineValidator).checkBookStock(Mockito.anyString(), Mockito.anyString());
		offlineBookValidation.bookUpdatingValidation(getBookStockModel());
	
	}

	@Test
	public void bookDeletingValidation() {
	
		doNothing().when(offlineValidator).checkBookId(Mockito.anyString(), Mockito.anyString());
		offlineBookValidation.bookDeletingValidation("1");
	
	}

	private BookStockModel getBookStockModel() {
	
		BookStockModel bookStockModel = new BookStockModel();
		bookStockModel.setBookId("1");
		bookStockModel.setBookStock("10");
		return bookStockModel;
	
	}

	private BookModel getBookModel() {
	
		BookModel bookModel = new BookModel();
		bookModel.setBookName("c");
		bookModel.setBookDescription("c with desc");
		bookModel.setBookPrice("1000");
		bookModel.setBookStatus("true");
		bookModel.setBookStock("110");
		return bookModel;
	
	}

}