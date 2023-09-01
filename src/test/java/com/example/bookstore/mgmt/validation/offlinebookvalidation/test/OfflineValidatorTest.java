package com.example.bookstore.mgmt.validation.offlinebookvalidation.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.example.bookstore.mgmt.exception.ValidationException;
import com.example.bookstore.mgmt.regularexpressions.RegularExpressions;
import com.example.bookstore.mgmt.validation.offlinebookvalidation.impl.OfflineValidatorImpl;

public class OfflineValidatorTest {
	
	@BeforeEach
	private void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@InjectMocks
	OfflineValidatorImpl offlineValidator;
	
	@Test
	public void checkBookNameTest() {
		
		offlineValidator.checkBookName("abc", RegularExpressions.azAz);
	
	}
	
	@Test
	public void checkBookNameTest01() {
	
		assertThrows(ValidationException.class, () -> {
			offlineValidator.checkBookName("011", RegularExpressions.azAz);			
		});
		
	}
	
	@Test
	public void checkBookPriceTest() {
		
		offlineValidator.checkBookPrice("110", RegularExpressions.number);
	
	}
	
	@Test
	public void checkBookPriceTest01() {
	
		assertThrows(ValidationException.class, () -> {
			offlineValidator.checkBookPrice("abs", RegularExpressions.number);
		});
	
	}
	
	@Test
	public void checkBookStockTest() {
	
		offlineValidator.checkBookStock("101", RegularExpressions.number);
	
	}
	
	@Test
	public void checkBookStockTest01() {
	
		assertThrows(ValidationException.class, () -> {			
			offlineValidator.checkBookStock("abc", RegularExpressions.number);
		});
	
	}
	
	@Test
	public void checkBookIdTest() {
	
		offlineValidator.checkBookId("101", RegularExpressions.number);
	
	}
	
	@Test
	public void checkBookIdTest01() {
	
		assertThrows(ValidationException.class, () -> {			
			offlineValidator.checkBookId("abc", RegularExpressions.number);
		});
	
	}

}