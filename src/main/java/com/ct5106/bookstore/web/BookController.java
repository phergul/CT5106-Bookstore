package com.ct5106.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Book;
import com.ct5106.bookstore.domain.BookRepository;

@RestController
public class BookController {
	
	@Autowired
    private BookRepository bookRepository;
    
	@GetMapping("/findTitle")
	public Book findDistinctByTitle(@Param("title") String title) {
		return bookRepository.findDistinctByTitle(title);
	}
	
	@GetMapping("/books/by-publisher")
    public List<Book> getBooksByPublisher(@RequestParam String publisherName) {
        return bookRepository.findBooksByPublisher(publisherName);
    }
	
	@GetMapping(value = "/books")
	public Iterable<Book> getBooks()
	{
		return bookRepository.findAll();
	}
}