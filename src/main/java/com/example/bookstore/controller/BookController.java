package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.mgmt.service.BookMgmtService;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

@RestController
public class BookController {

	@Autowired
	private BookMgmtService bookMgmtService;
	
	@GetMapping("/books")
	public ResponseEntity<?> getBooks(){
		
		return bookMgmtService.getBooks();
	
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<?> getBook(@PathVariable String bookId){
		
		return bookMgmtService.getBook(bookId);
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> addBooks(@RequestBody BookModel bookModel){	
		
		return bookMgmtService.addBook(bookModel);
		
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable String bookId){
		
		return bookMgmtService.deleteBook(bookId);
		
	}
	
	@GetMapping("/books/purchase/{bookId}/{bookStock}")
	public ResponseEntity<?> purchaseBook(@PathVariable String bookId, @PathVariable String bookStock){
		
		return bookMgmtService.purchaseBook(bookId, bookStock);
		
	}
	
	@PutMapping("/books/update")
	public ResponseEntity<?> updateBookStock(@RequestBody BookStockModel bookStockModel){
		
		return bookMgmtService.updateBookStock(bookStockModel);
		
	}
	
}