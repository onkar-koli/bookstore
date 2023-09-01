package com.example.bookstore.mgmt.validation.test;

import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.bookstore.dao.validation.OnlineBookValidation;
import com.example.bookstore.mgmt.validation.impl.ValidationServiceImpl;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.OfflineBookValidation;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public class ValidationServiceTest {
	
	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@InjectMocks
	private ValidationServiceImpl validationService;
	
	@Mock
	private OfflineBookValidation offlineBookValidation;
	
	@Mock
	private OnlineBookValidation onlineBookValidation;
	
	@Test
	public void bookAddingValidationTest() {
		
		doNothing().when(offlineBookValidation).bookAddingValidation(Mockito.any());
		doNothing().when(onlineBookValidation).bookAddingValidation(Mockito.any());
		validationService.bookAddingValidation(getBookModel());
	
	}

	@Test
	public void bookUpdatingValidationTest() {
	
		doNothing().when(offlineBookValidation).bookUpdatingValidation(Mockito.any());
		doNothing().when(onlineBookValidation).bookUpdatingValidation(Mockito.any());
		validationService.bookUpdatingValidation(getBookStockModel());
	
	}

	@Test
	public void bookPurchasingValidationTest() {
	
		doNothing().when(offlineBookValidation).bookPurchasingValidation(Mockito.anyString(), Mockito.anyString());
		doNothing().when(onlineBookValidation).bookPurchasingValidation(Mockito.anyString(), Mockito.anyString());
		validationService.bookPurchasingValidation("1", "1");
	
	}

	@Test
	public void getBookValidationTest() {
	
		doNothing().when(offlineBookValidation).getBookValidation(Mockito.anyString());
		doNothing().when(onlineBookValidation).getBookValidation(Mockito.anyString());
		validationService.getBookValidation("1");
	
	}

	@Test
	public void bookDeletingValidationTest() {
	
		doNothing().when(offlineBookValidation).bookDeletingValidation(Mockito.anyString());
		doNothing().when(onlineBookValidation).bookDeletingValidation(Mockito.anyString());
		validationService.bookDeletingValidation("0");
	
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