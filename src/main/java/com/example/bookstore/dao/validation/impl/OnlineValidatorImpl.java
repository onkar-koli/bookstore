package com.example.bookstore.dao.validation.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dao.entitty.Book;
import com.example.bookstore.dao.repository.BookRepository;
import com.example.bookstore.dao.validation.OnlineValidator;
import com.example.bookstore.mgmt.exception.ValidationException;

@Service("onlineValidator")
public class OnlineValidatorImpl implements OnlineValidator {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void checkBookName(String bookName) {
		
		if (bookRepository.getBookByName(bookName) != null) {
			throw new ValidationException("Book Name is Already Present");
		}
		
	}

	@Override
	public void checkBookId(String bookId) {
		
		if (!bookRepository.findById(Integer.parseInt(bookId)).isPresent()) {
			throw new ValidationException("Book Id is not Present");
		}
		
	}

	@Override
	public void checkBookStock(String bookId, String bookStock) {
		
		Optional<Book> entity = bookRepository.findById(Integer.parseInt(bookId));
		if (entity.isEmpty()) {
			throw new ValidationException("Book Id not present");
		}
		if (entity.get().getBookStock() < Integer.parseInt(bookStock)) {
			throw new ValidationException("Book Stock is not Sufficiant");
		}
		
	}

	@Override
	public void checkBookStatus(String bookId) {
		
		Book bookEntity = bookRepository.findById(Integer.parseInt(bookId)).get();
		if (!bookEntity.getBookStatus()) {
			throw new ValidationException("Book Status is Disabled");
		}
		
	}
}
