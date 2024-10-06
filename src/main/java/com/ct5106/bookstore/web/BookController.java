package com.ct5106.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/books")
	public Iterable<Book> getBooks()
	{
		return repository.findAll();
	}
	
	@PostMapping
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }
}