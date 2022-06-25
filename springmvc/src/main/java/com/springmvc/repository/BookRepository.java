package com.springmvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.springmvc.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public Book findById(int id);
	
	
	

}
