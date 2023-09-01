package com.example.bookstore.mgmt.utility;

import org.springframework.stereotype.Service;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.model.BookDetailModel;
import com.example.bookstore.model.BookModel;

@Service("entityToModelUtility")
public class EntityToModelUtility {
	
	public BookModel bookUtility(Book bookEntity) {
	
		BookModel bookModel=new BookModel();
		bookModel.setBookName(bookEntity.getBookName());
		bookModel.setBookDescription(bookEntity.getBookDescription());
		bookModel.setBookPrice(bookEntity.getBookPrice().toString());
		bookModel.setBookStock(bookEntity.getBookStock().toString());
		bookModel.setBookStatus(bookEntity.getBookStatus().toString());
		return bookModel;
	
	}
	
	public BookDetailModel bookDetailUtility(Book bookEntity) {
	
		BookDetailModel bookDetailModel=new BookDetailModel();
		bookDetailModel.setBookId(bookEntity.getBookId());
		bookDetailModel.setBookName(bookEntity.getBookName());
		bookDetailModel.setPrice(bookEntity.getBookPrice());
		bookDetailModel.setBookStatus(bookEntity.getBookStatus());
		return bookDetailModel;
		
	}
	
}
