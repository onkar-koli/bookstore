package com.example.bookstore.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.bookstore.dao.entitty.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
	
	@Query("select b FROM Book b WHERE bookName= :name")
	public Book getBookByName(@Param("name") String bookName);
	
}
