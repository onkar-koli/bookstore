package com.example.bookstore.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.bookstore.controller.BookController;
import com.example.bookstore.mgmt.service.BookMgmtService;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookControllerTest.class)
public class BookControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private BookController bookController;
	
	@BeforeEach
	private void init() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	
	}
	
	@Mock
	private BookMgmtService bookMgmtService;

	@Test
	public void getBooksTest() throws Exception{
	
		BookModel bookModel = getBookModel();
		ResponseEntity res = new ResponseEntity<>(bookModel, HttpStatus.OK);
		when(bookController.getBooks()).thenReturn(res);
		MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/books")).andReturn();
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
		
	}
	
	@Test
	public void getBookTest() throws Exception{
		
		BookModel bookModel = getBookModel();
		ResponseEntity res = new ResponseEntity<>(bookModel, HttpStatus.OK);
		when(bookController.getBook(Mockito.anyString())).thenReturn(res);
		MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/books").param("bookId", "1")).andReturn();
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
		
	}
	
	@Test
	public void addBookTest() throws Exception{
		
		BookModel bookModel = getBookModel();
		ResponseEntity res = new ResponseEntity<>(bookModel, HttpStatus.OK);
		String json = new ObjectMapper().writeValueAsString(bookModel);
		when(bookController.addBooks(Mockito.any())).thenReturn(res);
		MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/books")
				.contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
		
	}
	
	@Test
	public void deleteBookTest() throws Exception{
		
		BookModel bookModel = getBookModel();
		ResponseEntity res = new ResponseEntity<>(bookModel, HttpStatus.OK);
		when(bookController.deleteBook(Mockito.anyString())).thenReturn(res);
		MvcResult mvcResult = mockMvc.perform(delete("http://localhost:8080/books/{bookId}", "1")).andReturn();	
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
		
	}
	
	@Test
	public void purchaseBookTest() throws Exception{
		
		BookModel bookModel = getBookModel();
		ResponseEntity res = new ResponseEntity<>(bookModel, HttpStatus.OK);
		when(bookController.purchaseBook(Mockito.anyString(), Mockito.anyString())).thenReturn(res);
		MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/books/purchase")
				.param("bookId", "1").param("bookStock", "1")).andReturn();
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
		
	}
	
	@Test
	public void updateBookStockTest() throws Exception{
		
		BookStockModel bookStockModel = new BookStockModel();
		ResponseEntity res = new ResponseEntity<>(bookStockModel, HttpStatus.OK);
		String json = new ObjectMapper().writeValueAsString(bookStockModel);
		when(bookController.updateBookStock(Mockito.any())).thenReturn(res);
		MvcResult mvcResult = mockMvc.perform(put("http://localhost:8080/books/update")
				.contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
		
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