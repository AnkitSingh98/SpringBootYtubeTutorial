package com.springmvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.entities.Book;
import com.springmvc.repository.BookRepository;

@Component
public class BookService {
	
	
	/*
	 * private static List<Book> list=new ArrayList<>();
	 * 
	 * static { list.add(new Book(12,"Python Basics","xyz")); list.add(new
	 * Book(36,"PHP Basics","pqr")); list.add(new Book(48,"Scala Basics","abc")); }
	 * 
	 * //get all books public List<Book> getAllBooks(){ return list; }
	 * 
	 * //get book by id public Book getBookById(int id) { Book book=null;
	 * book=list.stream().filter(e->e.getId()==id).findFirst().get(); return book; }
	 */
	
	@Autowired
	private BookRepository bookRepository;
	
	//********  Get All books************************************
	public List<Book> getAllBooks(){
		return (List<Book>)this.bookRepository.findAll();
	}
	
	//*******  Get book by id  **********************************
	public Book getBookById(int id) {
		 return (Book)this.bookRepository.findById(id);
		 
	}
	
	
	//*******  Add Book  ****************************************
	public Book addBook(Book b) {
		return (Book)this.bookRepository.save(b);
	}
	
	
	//********  Delete a book  **********************************
	public void deleteBook(int bid) {
		this.bookRepository.deleteById(bid);
	}
	
	
	//********  Update a book  ***********************************
	public void updateBook(Book b,int bid) {
		b.setId(bid);
		this.bookRepository.save(b);
	}

	
	
}

