package com.example.bookstore.dao.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.entitty.BookStock;
import com.example.bookstore.dao.entitty.Sales;
import com.example.bookstore.dao.repository.BookRepository;
import com.example.bookstore.dao.repository.BookStockRepository;
import com.example.bookstore.dao.repository.SalesRepository;
import com.example.bookstore.dao.service.impl.BookDaoServiceImpl;

@SpringBootTest
class BookDaoServiceTest {

	@InjectMocks
	private BookDaoServiceImpl bookDaoServiceImpl;

	@Mock
	private BookRepository bookRepository;

	@Mock
	private BookStockRepository bookStockRepository;

	@Mock
	private SalesRepository salesRepository;

	@Test
	void addBookTest() {

		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBookEntity());
		Book bookEntity = bookDaoServiceImpl.addBook(getBookEntity());
		assertEquals(getBookEntity().getBookId(), bookEntity.getBookId());
		assertEquals(getBookEntity().getBookName(), bookEntity.getBookName());
		assertEquals(getBookEntity().getBookDescription(), bookEntity.getBookDescription());
		assertEquals(getBookEntity().getBookPrice(), bookEntity.getBookPrice());
		assertEquals(getBookEntity().getBookStatus(), bookEntity.getBookStatus());
		assertEquals(getBookEntity().getBookStock(), bookEntity.getBookStock());
		assertEquals(getBookEntity().getSold(), bookEntity.getSold());

	}

	@Test
	void updateBookTest() {

		Optional<Book> optional = Optional.of(getBookEntity());
		Mockito.when(bookRepository.findById(anyInt())).thenReturn(optional);
		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBookEntity());
		Mockito.when(bookStockRepository.save(Mockito.any())).thenReturn(getBookStockEntity());
		BookStock bookStockEntityOutput = bookDaoServiceImpl.updateBookStock(getBookStockEntity());
		assertEquals(1, bookStockEntityOutput.getBookId());
		assertEquals(10, bookStockEntityOutput.getAdditionalBookStock());

	}

	@Test
	public void getBooksTest() {
		
		when(bookRepository.findAll()).thenReturn(Arrays.asList(getBookEntity()));
		List<Book> books = bookDaoServiceImpl.getBooks();
		assertEquals(getBookEntity().getBookId(), books.get(0).getBookId());
		assertEquals(getBookEntity().getBookName(), books.get(0).getBookName());
		assertEquals(getBookEntity().getBookDescription(), books.get(0).getBookDescription());
		assertEquals(getBookEntity().getBookPrice(), books.get(0).getBookPrice());
		assertEquals(getBookEntity().getBookStatus(), books.get(0).getBookStatus());
		assertEquals(getBookEntity().getBookStock(), books.get(0).getBookStock());
		assertEquals(getBookEntity().getSold(), books.get(0).getSold());
	
	}

	@Test
	public void getBook() {
	
		Book bookInput = getBookEntity();
		Optional<Book> opt = Optional.of(bookInput);
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(opt);
		Book bookEntity = bookDaoServiceImpl.getBook(1).get();
		assertEquals(bookInput.getBookId(), bookEntity.getBookId());
		assertEquals(bookInput.getBookName(), bookEntity.getBookName());
		assertEquals(bookInput.getBookDescription(), bookEntity.getBookDescription());
		assertEquals(bookInput.getBookPrice(), bookEntity.getBookPrice());
		assertEquals(bookInput.getBookStatus(), bookEntity.getBookStatus());
		assertEquals(bookInput.getBookStock(), bookEntity.getBookStock());
		assertEquals(bookInput.getSold(), bookEntity.getSold());
		assertEquals(bookInput.getAddingDate(), bookEntity.getAddingDate());
	
	}

	@Test
	public void deleteBookTest() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		when(bookRepository.save(Mockito.any())).thenReturn(getBookEntity());
		Book bookEntity = bookDaoServiceImpl.deleteBook(1);
		assertEquals(getBookEntity().getBookId(), bookEntity.getBookId());
		assertEquals(getBookEntity().getBookName(), bookEntity.getBookName());
		assertEquals(getBookEntity().getBookDescription(), bookEntity.getBookDescription());
		assertEquals(getBookEntity().getBookPrice(), bookEntity.getBookPrice());
		assertEquals(!getBookEntity().getBookStatus(), bookEntity.getBookStatus());
		assertEquals(getBookEntity().getBookStock(), bookEntity.getBookStock());
		assertEquals(getBookEntity().getSold(), bookEntity.getSold());
	
	}

	@Test
	public void purchaseBookTest() {
	
		when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getBookEntity()));
		when(bookRepository.save(Mockito.any())).thenReturn(getBookEntity());
		when(salesRepository.save(Mockito.any())).thenReturn(getSalesEntity());
		Book bookEntity = bookDaoServiceImpl.purchaseBook(1, 1);
		assertEquals(getBookEntity().getBookId(), bookEntity.getBookId());
		assertEquals(getBookEntity().getBookName(), bookEntity.getBookName());
		assertEquals(getBookEntity().getBookDescription(), bookEntity.getBookDescription());
		assertEquals(getBookEntity().getBookPrice(), bookEntity.getBookPrice());
		assertEquals(getBookEntity().getBookStatus(), bookEntity.getBookStatus());
		assertEquals((getBookEntity().getBookStock() - getSalesEntity().getCount()), bookEntity.getBookStock());
		assertEquals(getBookEntity().getSold()+getSalesEntity().getCount(), bookEntity.getSold());
	
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