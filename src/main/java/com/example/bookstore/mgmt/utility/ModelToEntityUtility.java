package com.example.bookstore.mgmt.utility;

import org.springframework.stereotype.Service;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.entitty.BookStock;
import com.example.bookstore.model.BookModel;
import com.example.bookstore.model.BookStockModel;

@Service("modelToEntityUtility")
public class ModelToEntityUtility {
	
	public Book bookUtility(BookModel bookModel) {
		
		Book bookEntity=new Book();
		bookEntity.setBookName(bookModel.getBookName());
		bookEntity.setBookDescription(bookModel.getBookDescription());
		bookEntity.setBookPrice(Integer.parseInt(bookModel.getBookPrice()));
		bookEntity.setBookStock(Integer.parseInt(bookModel.getBookStock()));
		bookEntity.setBookStatus(Boolean.parseBoolean(bookModel.getBookStatus()));
		bookEntity.setSold(0);
		return bookEntity;
	
	}	
	
	public BookStock bookStockUtility(BookStockModel bookStockModel) {
		
		BookStock bookStockEntity = new BookStock();
		bookStockEntity.setBookId(Integer.parseInt(bookStockModel.getBookId()));
		bookStockEntity.setAdditionalBookStock(Integer.parseInt(bookStockModel.getBookStock()));
		return bookStockEntity;
	
	}

}