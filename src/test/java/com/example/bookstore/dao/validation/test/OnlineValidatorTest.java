package com.example.bookstore.dao.validation.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.repository.BookRepository;
import com.example.bookstore.dao.validation.impl.OnlineValidatorImpl;
import com.example.bookstore.mgmt.exception.ValidationException;

public class OnlineValidatorTest {
	
	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@InjectMocks
	private OnlineValidatorImpl onlineValidator;
	
	@Mock
	private BookRepository bookRepository;


	@Test
	public void checkBookNameTest() {
		
		when(bookRepository.getBookByName(Mockito.anyString())).thenReturn(null);
		onlineValidator.checkBookName("abc");
	
	}
	
	@Test
	public void checkBookNameTest01() {
	
		when(bookRepository.getBookByName(Mockito.anyString())).thenReturn(getBookEntity());
		assertThrows(ValidationException.class, () -> {			
			onlineValidator.checkBookName("abc");
		});
		
	}
	
	@Test
	public void checkBookIdTest() {
		
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		onlineValidator.checkBookId("1");
	
	}
	
	@Test
	public void checkBookIdTest01() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		assertThrows(ValidationException.class, () -> {
			onlineValidator.checkBookId("1");			
		});
	
	}
	
	@Test
	public void checkBookStockTest() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		onlineValidator.checkBookStock("1", "1");
	
	}
	
	@Test
	public void checkBookStockTest01() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		assertThrows(ValidationException.class, () -> {			
			onlineValidator.checkBookStock("1", "111");
		});
	
	}
	
	@Test
	public void checkBookStockTest02() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		assertThrows(ValidationException.class, () -> {
			onlineValidator.checkBookStock("1", "1");			
		});
	
	}
	
	@Test
	public void checkBookStatusTest() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		onlineValidator.checkBookStatus("1");
	
	}
	
	@Test
	public void checkBookStatusTest01() {
	
		Book bookEntity = getBookEntity();
		bookEntity.setBookStatus(false);
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(bookEntity));
		assertThrows(ValidationException.class, () -> {
			onlineValidator.checkBookStatus("1");			
		});
	
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