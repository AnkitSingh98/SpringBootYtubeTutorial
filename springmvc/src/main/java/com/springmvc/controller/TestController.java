package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.entities.Book;
import com.springmvc.services.BookService;

import java.lang.String;
import java.util.List;


@RestController
public class TestController {
	
	@Autowired
	private BookService bookService;
	
	//1)*************   Test  ********************************************* 
	@GetMapping("/test")
	public String handleTest() 
	{
		return "testing";
	}
	
	//2)************* all books handler  ************************************
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public List<Book> getBooks() {
		
		return this.bookService.getAllBooks();
	}
	
	//3)************  book by id handler ************************************
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}
	
	//4)************  Add book handler  *************************************
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}
	
	//5)************  Delete book handler  **********************************
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}
	
	//6)***********  Update book handler  ***********************************
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable("id") int id) {
		 this.bookService.updateBook(book, id);
		 return book;
	}
	
	
		
		
	
	}

