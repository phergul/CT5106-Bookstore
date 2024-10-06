package com.ct5106.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Author;
import com.ct5106.bookstore.domain.AuthorRepository;

@RestController
public class AuthorController {
	
	private final AuthorRepository repository;
	
	public AuthorController(AuthorRepository repository)
	{
		this.repository	= repository;
	}
	
	@GetMapping(value = "/authors")
	public Iterable<Author> getAuthors()
	{
		return repository.findAll();
	}
}