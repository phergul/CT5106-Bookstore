package com.ct5106.bookstore.web;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Book;
import com.ct5106.bookstore.domain.BookRepository;

@RestController
public class BookController {
	
	private final BookRepository repository;
	
	public BookController(BookRepository repository)
	{
		this.repository	= repository;
	}
	
	@GetMapping("/findTitle")
	public Book findDistinctByTitle(@Param("title") String title) {
		return repository.findDistinctByTitle(title);
	}
	
	@GetMapping("/books/by-publisher")
    public List<Book> getBooksByPublisher(@RequestParam String publisherName) {
        return repository.findBooksByPublisher(publisherName);
    }
	
	@GetMapping(value = "/books")
	public Iterable<Book> getBooks()
	{
		return repository.findAll();
	}
}