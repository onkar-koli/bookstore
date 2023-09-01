package com.example.bookstore.dao.validation.test;

import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.bookstore.dao.validation.OnlineValidator;
import com.example.bookstore.dao.validation.impl.OnlineBookValidationImpl;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public class OnlineBookValidationTest {

	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}

	@InjectMocks
	private OnlineBookValidationImpl bookValidation;

	@Mock
	private OnlineValidator onlineValidator;

	@Test
	public void bookAddingValidationTest() {
		
		doNothing().when(onlineValidator).checkBookName(Mockito.anyString());
		bookValidation.bookAddingValidation(getBookModel());
	
	}

	@Test
	public void bookPurchasingValidationTest() {
	
		doNothing().when(onlineValidator).checkBookStatus(Mockito.anyString());
		doNothing().when(onlineValidator).checkBookId(Mockito.anyString());
		doNothing().when(onlineValidator).checkBookStock(Mockito.anyString(), Mockito.anyString());
		bookValidation.bookPurchasingValidation("1", "1");
	
	}

	@Test
	public void getBookValidationTest() {
	
		doNothing().when(onlineValidator).checkBookId(Mockito.anyString());
		bookValidation.getBookValidation("1");
	
	}

	@Test
	public void bookUpdatingValidationTest() {
	
		doNothing().when(onlineValidator).checkBookStatus(Mockito.anyString());
		doNothing().when(onlineValidator).checkBookId(Mockito.anyString());
		bookValidation.bookUpdatingValidation(getBookStockModel());
	
	}

	@Test
	public void bookDeletingValidationTest() {
	
		doNothing().when(onlineValidator).checkBookId(Mockito.anyString());
		bookValidation.bookDeletingValidation("1");
	
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