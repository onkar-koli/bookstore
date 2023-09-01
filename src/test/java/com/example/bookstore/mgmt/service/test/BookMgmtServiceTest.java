package com.example.bookstore.mgmt.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.entitty.BookStock;
import com.example.bookstore.dao.entitty.Sales;
import com.example.bookstore.dao.service.BookDaoService;
import com.example.bookstore.mgmt.exception.ValidationException;
import com.example.bookstore.mgmt.service.impl.BookMgmtServiceImpl;
import com.example.bookstore.mgmt.utility.EntityToModelUtility;
import com.example.bookstore.mgmt.utility.ModelToEntityUtility;
import com.example.bookstore.mgmt.validation.ValidationServices;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

public class BookMgmtServiceTest {

	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}

	@InjectMocks
	private BookMgmtServiceImpl bookMgmtService;

	@Mock
	private ValidationServices validationServices;

	@Mock
	private BookDaoService bookDaoService;

	@Mock
	private ModelToEntityUtility modelToEntityUtility;

	@Mock
	private EntityToModelUtility entityToModelUtility;

	@Test
	public void getBooksTest() {
		
		when(bookDaoService.getBooks()).thenReturn(Arrays.asList(getBookEntity()));
		ResponseEntity<?> entity = bookMgmtService.getBooks();
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void getBookTest() {
	
		doNothing().when(validationServices).getBookValidation(Mockito.anyString());
		when(bookDaoService.getBook(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		ResponseEntity<?> entity = bookMgmtService.getBook("1");
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void getBookTest01() {
	
		doNothing().when(validationServices).getBookValidation(Mockito.anyString());
		when(bookDaoService.getBook(Mockito.anyInt())).thenThrow(ValidationException.class);
		ResponseEntity<?> entity = bookMgmtService.getBook("1");
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	
	}

	@Test
	public void getBookTest02() {
	
		doNothing().when(validationServices).getBookValidation(Mockito.anyString());
		when(bookDaoService.getBook(Mockito.anyInt())).thenThrow(NullPointerException.class);
		ResponseEntity<?> entity = bookMgmtService.getBook("1");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	
	}

	@Test
	public void addBookTest() {
	
		doNothing().when(validationServices).bookAddingValidation(Mockito.any());
		when(bookDaoService.addBook(Mockito.any())).thenReturn(getBookEntity());
		ResponseEntity<?> entity = bookMgmtService.addBook(getBookModel());
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void addBookTest01() {
	
		doNothing().when(validationServices).bookAddingValidation(Mockito.any());
		when(bookDaoService.addBook(Mockito.any())).thenThrow(ValidationException.class);
		ResponseEntity<?> entity = bookMgmtService.addBook(getBookModel());
		assertEquals(HttpStatus.NOT_ACCEPTABLE, entity.getStatusCode());
	
	}

	@Test
	public void addBookTest02() {
	
		doNothing().when(validationServices).bookAddingValidation(Mockito.any());
		when(bookDaoService.addBook(Mockito.any())).thenThrow(NullPointerException.class);
		ResponseEntity<?> entity = bookMgmtService.addBook(getBookModel());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	
	}

	@Test
	public void deleteBookTest() {
	
		doNothing().when(validationServices).bookDeletingValidation(Mockito.anyString());
		when(bookDaoService.deleteBook(Mockito.anyInt())).thenReturn(getBookEntity());
		ResponseEntity<?> entity = bookMgmtService.deleteBook("1");
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void deleteBookTest01() {
		
		doNothing().when(validationServices).bookDeletingValidation(Mockito.anyString());
		when(bookDaoService.deleteBook(Mockito.anyInt())).thenThrow(ValidationException.class);
		ResponseEntity<?> entity = bookMgmtService.deleteBook("1");
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	
	}

	@Test
	public void deleteBookTest02() {
	
		doNothing().when(validationServices).bookDeletingValidation(Mockito.anyString());
		when(bookDaoService.deleteBook(Mockito.anyInt())).thenThrow(NullPointerException.class);
		ResponseEntity<?> entity = bookMgmtService.deleteBook("1");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	
	}

	@Test
	public void purchaseBookTest() {
	
		doNothing().when(validationServices).bookPurchasingValidation(Mockito.anyString(), Mockito.anyString());
		when(bookDaoService.purchaseBook(Mockito.anyInt(), Mockito.anyInt())).thenReturn(getBookEntity());
		ResponseEntity<?> entity = bookMgmtService.purchaseBook("1", "1");
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}

	@Test
	public void purchaseBookTest01() {
	
		doNothing().when(validationServices).bookPurchasingValidation(Mockito.anyString(), Mockito.anyString());
		when(bookDaoService.purchaseBook(Mockito.anyInt(), Mockito.anyInt())).thenThrow(ValidationException.class);
		ResponseEntity<?> entity = bookMgmtService.purchaseBook("1", "1");
		assertEquals(HttpStatus.NOT_ACCEPTABLE, entity.getStatusCode());
	
	}

	@Test
	public void purchaseBookTest02() {
	
		doNothing().when(validationServices).bookPurchasingValidation(Mockito.anyString(), Mockito.anyString());
		when(bookDaoService.purchaseBook(Mockito.anyInt(), Mockito.anyInt())).thenThrow(NullPointerException.class);
		ResponseEntity<?> entity = bookMgmtService.purchaseBook("1", "1");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	
	}

	@Test
	public void updateBookStock() {
	
		doNothing().when(validationServices).bookUpdatingValidation(Mockito.any());
		when(bookDaoService.updateBookStock(Mockito.any())).thenReturn(getBookStockEntity());
		ResponseEntity<?> entity = bookMgmtService.updateBookStock(getBookStockModel());
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	
	}
	
	@Test
	public void updateBookStock01() {
	
		doNothing().when(validationServices).bookUpdatingValidation(Mockito.any());
		when(bookDaoService.updateBookStock(Mockito.any())).thenThrow(ValidationException.class);
		ResponseEntity<?> entity = bookMgmtService.updateBookStock(getBookStockModel());
		assertEquals(HttpStatus.NOT_ACCEPTABLE, entity.getStatusCode());
	
	}
	
	@Test
	public void updateBookStock02() {
	
		doNothing().when(validationServices).bookUpdatingValidation(Mockito.any());
		when(bookDaoService.updateBookStock(Mockito.any())).thenThrow(NullPointerException.class);
		ResponseEntity<?> entity = bookMgmtService.updateBookStock(getBookStockModel());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	
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

	private Sales getSalesEntity() {
	
		Sales salesEntity = new Sales();
		salesEntity.setBookId(1);
		salesEntity.setCount(1);
		salesEntity.setPrice(1000);
		salesEntity.setTransactionDate(new Date());
		return salesEntity;
	
	}

	private BookStock getBookStockEntity() {
		
		BookStock bookStockEntity = new BookStock();
		bookStockEntity.setBookStockId(5);
		bookStockEntity.setBookId(1);
		bookStockEntity.setAdditionalBookStock(10);
		bookStockEntity.setUpdatingStockDate(new Date());
		return bookStockEntity;
	
	}

	private Book getBookEntity() {
	
		Book bookEntity = new Book();
		bookEntity.setBookId(1);
		bookEntity.setBookName("c");
		bookEntity.setBookDescription("c with desc");
		bookEntity.setBookPrice(1000);
		bookEntity.setBookStatus(true);
		bookEntity.setBookStock(110);
		bookEntity.setAddingDate(new Date());
		bookEntity.setSold(1);
		return bookEntity;
	
	}

}