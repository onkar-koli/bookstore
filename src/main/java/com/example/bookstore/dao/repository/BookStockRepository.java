package com.example.bookstore.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.dao.entitty.BookStock;

public interface BookStockRepository extends CrudRepository<BookStock, Integer>{

}
